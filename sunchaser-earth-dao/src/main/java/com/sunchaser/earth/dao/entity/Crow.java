package com.sunchaser.earth.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 乌鸦
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Crow extends MySqlBaseModel {
    private static final long serialVersionUID = 6932572115587634598L;

    /**
     * 分类名
     */
    private String crow;

    /**
     * 父级分类ID
     */
    private Long parentId;

    /**
     * 分类描述
     */
    private String desc;
}
