package com.sunchaser.earth.domain.response.vo;

import com.sunchaser.earth.domain.response.PageBaseResponse;
import com.sunchaser.earth.domain.response.dto.WhiteDoveDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.List;

/**
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/20
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WhiteDoveVO extends PageBaseResponse {
    private static final long serialVersionUID = 6282130056002259476L;
    private List<WhiteDoveDTO> records = Collections.emptyList();
}
