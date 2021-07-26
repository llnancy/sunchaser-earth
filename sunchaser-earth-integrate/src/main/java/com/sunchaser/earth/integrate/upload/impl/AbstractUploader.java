package com.sunchaser.earth.integrate.upload.impl;

import cn.hutool.core.io.FileTypeUtil;
import com.google.common.base.Preconditions;
import com.sunchaser.earth.common.enums.file.FileTypeEnum;
import com.sunchaser.earth.common.property.UploadProperties;
import com.sunchaser.earth.common.util.ImageUtils;
import com.sunchaser.earth.integrate.upload.Uploader;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.UUID;

import static com.sunchaser.earth.common.util.Constants.StringConstants.*;

/**
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/22
 */
public abstract class AbstractUploader implements Uploader {
    protected FileTypeEnum fileTypeEnum;

    @Override
    public FileTypeEnum getFileTypeEnum() {
        return this.fileTypeEnum;
    }

    @Override
    public void setFileTypeEnum(FileTypeEnum fileTypeEnum) {
        this.fileTypeEnum = fileTypeEnum;
    }

    @Autowired
    protected UploadProperties uploadProperties;

    protected String generateFileURI(MultipartFile multipartFile) throws Exception {
        String originalFilename = multipartFile.getOriginalFilename();
        Preconditions.checkArgument(StringUtils.isNotEmpty(originalFilename), "文件名不能为空");
        int lastIndexOf = originalFilename.lastIndexOf(".");
        String suffix = lastIndexOf == -1 ? EMPTY : originalFilename.substring(lastIndexOf);
        ImmutablePair<Integer, Integer> imageHeightAndWidth = ImageUtils.getImageHeightAndWidth(multipartFile);
        Integer height = imageHeightAndWidth.getLeft();
        Integer width = imageHeightAndWidth.getRight();
        return uploadProperties.getArtifactId() + FORWARD_SLASH +
                uploadProperties.getNamespace() + FORWARD_SLASH +
                LocalDate.now().toString() + FORWARD_SLASH +
                height + UNDERSCORE + width + DASH +
                UUID.randomUUID().toString().replaceAll(DASH, EMPTY) + suffix;
    }

    @Override
    public String upload(MultipartFile multipartFile) throws Exception {
        String originalFilename = multipartFile.getOriginalFilename();
        Preconditions.checkArgument(StringUtils.isNotEmpty(originalFilename), "文件名不能为空");
        String type = FileTypeUtil.getType(multipartFile.getInputStream(), originalFilename);
        Preconditions.checkArgument(this.getFileTypeEnum().getFileExtNameList().contains(type), "文件格式有误");
        String fileURI = generateFileURI(multipartFile);
        return doUpload(multipartFile, fileURI);
    }

    protected abstract String doUpload(MultipartFile multipartFile, String fileURI) throws Exception;
}
