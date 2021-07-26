package com.sunchaser.earth.domain.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/21
 */
@Data
public class PageBaseResponse implements Serializable {
    private static final long serialVersionUID = 3730552005193591285L;
    private Long count = 0L;
    private boolean hasNext = false;
}
