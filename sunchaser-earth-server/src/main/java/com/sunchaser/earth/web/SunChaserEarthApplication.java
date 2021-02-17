package com.sunchaser.earth.web;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/2/15
 */
@SpringBootApplication
public class SunChaserEarthApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SunChaserEarthApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
