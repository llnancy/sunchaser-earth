package com.sunchaser.earth.common.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/21
 */
@Component
@Data
@ConfigurationProperties(prefix = "upload")
public class UploadProperties {

    private String artifactId;

    private String namespace;

    private Qiniu qiniu;

    public UploadProperties() {
        this.qiniu = new Qiniu();
    }

    @Data
    public static class Qiniu {
        private String domain;
        private String accessKey;
        private String secretKey;
        private String bucketName;
    }
}
