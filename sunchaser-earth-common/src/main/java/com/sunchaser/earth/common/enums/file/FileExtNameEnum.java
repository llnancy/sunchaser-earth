package com.sunchaser.earth.common.enums.file;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Borrowed from cn.hutool.core.io.FileTypeUtil#FILE_TYPE_MAP
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/22
 */
@Getter
@AllArgsConstructor
public enum FileExtNameEnum {
    JPEG("jpg", "JPEG (jpg)"),
    PNG("png", "PNG (png)"),
    GIF("gif", "GIF (gif)"),

    TIFF("tif", "TIFF (tif)"),
    BMP("bmp", "16色位图(bmp)/24色位图(bmp)/256色位图(bmp)"),
    DWG("dwg", "CAD (dwg)"),
    ;
    private final String extName;
    private final String desc;
}
