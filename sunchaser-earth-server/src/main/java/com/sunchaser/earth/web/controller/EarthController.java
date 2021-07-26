package com.sunchaser.earth.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/2/15
 */
@RestController
public class EarthController {

    @GetMapping("/ping")
    public String ping(@RequestParam String ping) {
        return "pong";
    }
}
