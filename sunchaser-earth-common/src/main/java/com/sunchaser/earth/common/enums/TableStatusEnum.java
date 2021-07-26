package com.sunchaser.earth.common.enums;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

/**
 * 表status状态枚举
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/17
 */
@Getter
@AllArgsConstructor
public enum TableStatusEnum {
    NORMAL(1, "正常"),
    DELETED(0, "已删除")
    ;
    private final Integer status;
    private final String desc;
    private static final Map<Integer, TableStatusEnum> enumMap = Maps.newHashMap();

    static {
        for (TableStatusEnum tableStatusEnum : TableStatusEnum.values())
            enumMap.put(tableStatusEnum.status, tableStatusEnum);
    }

    public static TableStatusEnum getTableStatusEnumByStatus(Integer status) {
        return enumMap.get(status);
    }
}
