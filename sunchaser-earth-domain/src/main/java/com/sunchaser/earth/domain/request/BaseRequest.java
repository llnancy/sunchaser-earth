package com.sunchaser.earth.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/19
 */
@Data
public class BaseRequest implements Serializable {
    private static final long serialVersionUID = -3786317556051661658L;
    private Integer pageSize;
    private Integer pageNo;
}
