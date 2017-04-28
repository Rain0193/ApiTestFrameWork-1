package com.test.framework.dao.mysql.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "um_account_security")
public class UmAccountSecurity {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 账号ID
     */
    @Column(name = "account_id")
    private Long accountId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建用户
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 修改用户
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取账号ID
     *
     * @return account_id - 账号ID
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * 设置账号ID
     *
     * @param accountId 账号ID
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取创建用户
     *
     * @return create_by - 创建用户
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建用户
     *
     * @param createBy 创建用户
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取修改用户
     *
     * @return update_by - 修改用户
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置修改用户
     *
     * @param updateBy 修改用户
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}