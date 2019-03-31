package com.example.mybatisplusdemo.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 操作记录表
 * </p>
 *
 * @author jobob
 * @since 2019-03-31
 */
@Data
@Accessors(chain = true)
public class MybatisDemoLog {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * uid
     */
    private String uId;

    /**
     * 操作类型 01 浏览 02 新增 03 更新 04 删除
     */
    private String optType;

    private String extraInfo;

    /**
     * 是否删除 Y-是 N-否
     */
    private String isDeleted;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreated;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;


}
