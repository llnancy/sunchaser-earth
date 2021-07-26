package com.sunchaser.earth.integrate.upload;

import com.sunchaser.earth.common.enums.file.FileTypeEnum;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/17
 */
public interface Uploader {

    String upload(MultipartFile multipartFile) throws Exception;

    default FileTypeEnum getFileTypeEnum() {
        return FileTypeEnum.ALL;
    }

    default void setFileTypeEnum(FileTypeEnum fileTypeEnum) {

    }
}
