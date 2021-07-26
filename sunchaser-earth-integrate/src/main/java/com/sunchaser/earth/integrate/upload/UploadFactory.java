package com.sunchaser.earth.integrate.upload;

import com.sunchaser.earth.common.enums.file.FileTypeEnum;
import com.sunchaser.earth.integrate.upload.impl.qiniu.QiniuCloudUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/21
 */
@Component
public class UploadFactory {

    @Autowired
    private ApplicationContext applicationContext;

    public Uploader getUploader(FileTypeEnum fileTypeEnum) {
        QiniuCloudUploader bean = applicationContext.getBean(QiniuCloudUploader.class);
        bean.setFileTypeEnum(fileTypeEnum);
        return bean;
    }
}
