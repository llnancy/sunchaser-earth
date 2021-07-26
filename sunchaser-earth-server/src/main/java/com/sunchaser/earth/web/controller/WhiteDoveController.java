package com.sunchaser.earth.web.controller;

import com.sunchaser.earth.common.model.EarthResponse;
import com.sunchaser.earth.domain.request.SelectWhiteDoveRequest;
import com.sunchaser.earth.domain.response.vo.WhiteDoveVO;
import com.sunchaser.earth.service.WhiteDoveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/20
 */
@RestController
@Slf4j
@RequestMapping("/whitedove")
public class WhiteDoveController {
    @Autowired
    private WhiteDoveService whiteDoveService;

    @PostMapping("/upload")
    public EarthResponse<String> uploadWhiteDove(@RequestParam MultipartFile file) {
        try {
            String path = whiteDoveService.saveWhiteDove(file);
            return EarthResponse.success(path);
        } catch (Exception e) {
            log.error("上传失败", e);
            return EarthResponse.error(e.getMessage());
        }
    }

    @GetMapping("/list")
    public EarthResponse<WhiteDoveVO> list(SelectWhiteDoveRequest selectWhiteDoveRequest) {
        try {
            WhiteDoveVO whiteDoveVO = whiteDoveService.pageSelectList(selectWhiteDoveRequest);
            return EarthResponse.success(whiteDoveVO);
        } catch (Exception e) {
            log.error("查询失败", e);
            return EarthResponse.error(e.getMessage());
        }
    }
}
