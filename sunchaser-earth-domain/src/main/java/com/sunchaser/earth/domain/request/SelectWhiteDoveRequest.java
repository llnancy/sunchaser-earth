package com.sunchaser.earth.domain.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/19
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SelectWhiteDoveRequest extends BaseRequest {
    private static final long serialVersionUID = -3064116954056424421L;
    private Long crowId;
}
