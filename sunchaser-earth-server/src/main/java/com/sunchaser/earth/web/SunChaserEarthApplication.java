package com.sunchaser.earth.web;

import com.sunchaser.earth.common.property.UploadProperties;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/2/15
 */
@SpringBootApplication
@EnableConfigurationProperties(value = {UploadProperties.class})
@ComponentScan(basePackages = "com.sunchaser.earth")
public class SunChaserEarthApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SunChaserEarthApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
