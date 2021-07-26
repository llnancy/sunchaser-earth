package com.sunchaser.earth.common.enums;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

/**
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/17
 */
@Getter
@AllArgsConstructor
public enum WhiteDoveTypeEnum {
    IMAGE(1, "图片"),
    ;
    private final Integer type;
    private final String desc;
    private static final Map<Integer, WhiteDoveTypeEnum> enumMap = Maps.newHashMap();

    static {
        for (WhiteDoveTypeEnum whiteDoveTypeEnum : WhiteDoveTypeEnum.values())
            enumMap.put(whiteDoveTypeEnum.type, whiteDoveTypeEnum);
    }

    public static WhiteDoveTypeEnum getWhiteDoveTypeEnumByType(Integer type) {
        return enumMap.get(type);
    }
}
