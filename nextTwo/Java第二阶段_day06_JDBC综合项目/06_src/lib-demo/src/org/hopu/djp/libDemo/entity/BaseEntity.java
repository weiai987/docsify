package org.hopu.djp.libDemo.entity;

import java.time.LocalDateTime;

/**
 * 实体类基类，提供创建者、创建时间、修改者、修改时间
 * 启用标识、删除标识字段
 */
public class BaseEntity {
    protected LocalDateTime createTime;
    protected Integer createOpr;
    protected LocalDateTime updateTime;
    protected Integer updateOpr;
//    启用/停用标识，1-启用, 0-停用
    protected Boolean enableFlag;
    public static final int EnableFlag_enable = 1;
    public static final int EnableFlag_disable = 0;
//    删除标识，1-已删，0-未删
    protected Boolean deleteFlag;
    public static final int DeleteFlag_del = 1;
    public static final int DeleteFlag_undel = 0;

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateOpr() {
        return createOpr;
    }

    public void setCreateOpr(Integer createOpr) {
        this.createOpr = createOpr;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateOpr() {
        return updateOpr;
    }

    public void setUpdateOpr(Integer updateOpr) {
        this.updateOpr = updateOpr;
    }

    public Boolean getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Boolean enableFlag) {
        this.enableFlag = enableFlag;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public static String getBaseField() {
        StringBuffer result = new StringBuffer();
        result.append("create_time,");
        result.append("create_opr,");
        result.append("update_time,");
        result.append("update_opr,");
        result.append("enable_flag,");
        result.append("delete_flag");
        return result.toString();
    }
}
