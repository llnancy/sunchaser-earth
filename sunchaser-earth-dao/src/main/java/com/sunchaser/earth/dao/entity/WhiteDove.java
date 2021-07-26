package com.sunchaser.earth.dao.entity;

import com.sunchaser.earth.common.util.Constants;
import com.sunchaser.earth.domain.response.dto.WhiteDoveDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 白鸽🕊
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WhiteDove extends MySqlBaseModel {

    private static final long serialVersionUID = -8468904888957475637L;

    /**
     * 资源
     */
    private String source;

    /**
     * 资源类别
     */
    private Integer type;

    /**
     * 资源分类ID
     */
    private Long crowId;

    public WhiteDoveDTO doConvert() {
        WhiteDoveDTO whiteDoveDTO = new WhiteDoveDTO();
        whiteDoveDTO.setUrl(this.source);
        int forwardSlashLastIndex = this.source.lastIndexOf(Constants.StringConstants.FORWARD_SLASH);
        int dashLastIndex = this.source.lastIndexOf(Constants.StringConstants.DASH);
        String heightAndWidth = this.source.substring(forwardSlashLastIndex + 1, dashLastIndex);
        String[] split = heightAndWidth.split(Constants.StringConstants.UNDERSCORE);
        whiteDoveDTO.setHeight(split[0]);
        whiteDoveDTO.setWidth(split[1]);
        return whiteDoveDTO;
    }
}
