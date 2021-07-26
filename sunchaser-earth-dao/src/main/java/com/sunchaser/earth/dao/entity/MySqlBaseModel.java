package com.sunchaser.earth.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/20
 */
@Data
public class MySqlBaseModel implements Serializable {

    private static final long serialVersionUID = 4411940472173357948L;

    /**
     * 自增主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 数据状态
     */
    private Integer status;
}
