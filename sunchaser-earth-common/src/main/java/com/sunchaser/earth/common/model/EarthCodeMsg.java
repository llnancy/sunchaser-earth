package com.sunchaser.earth.common.model;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

/**
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/20
 */
@Getter
@AllArgsConstructor
public enum EarthCodeMsg {
    SUCCESS("20000", "成功"),
    FAIL("50000", "失败"),
    ;
    private final String code;
    private final String msg;
    private static final Map<String, EarthCodeMsg> enumMap = Maps.newHashMap();

    static {
        for (EarthCodeMsg earthCodeMsg : EarthCodeMsg.values()) {
            enumMap.put(earthCodeMsg.code, earthCodeMsg);
        }
    }

    public static EarthCodeMsg getEarthCodeMsgByCode(String code) {
        return enumMap.get(code);
    }
}
