package com.test.framework.dao.mysql.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "um_account")
public class UmAccount {
    /**
     * 用户ID
     */
    @Id
    private Long id;

    /**
     * 用户登录账号
     */
    @Column(name = "login_account")
    private String loginAccount;

    /**
     * 用户登录密码
     */
    @Column(name = "login_pwd")
    private String loginPwd;

    /**
     * 账号类型，枚举值，如用户账号、车辆账号等
VIRTUAL_VEHICLE  虚拟车辆账号
USER  用户账号
     */
    @Column(name = "account_type")
    private String accountType;

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
     * 获取用户ID
     *
     * @return id - 用户ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置用户ID
     *
     * @param id 用户ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户登录账号
     *
     * @return login_account - 用户登录账号
     */
    public String getLoginAccount() {
        return loginAccount;
    }

    /**
     * 设置用户登录账号
     *
     * @param loginAccount 用户登录账号
     */
    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount == null ? null : loginAccount.trim();
    }

    /**
     * 获取用户登录密码
     *
     * @return login_pwd - 用户登录密码
     */
    public String getLoginPwd() {
        return loginPwd;
    }

    /**
     * 设置用户登录密码
     *
     * @param loginPwd 用户登录密码
     */
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    /**
     * 获取账号类型，枚举值，如用户账号、车辆账号等
VIRTUAL_VEHICLE  虚拟车辆账号
USER  用户账号
     *
     * @return account_type - 账号类型，枚举值，如用户账号、车辆账号等
VIRTUAL_VEHICLE  虚拟车辆账号
USER  用户账号
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * 设置账号类型，枚举值，如用户账号、车辆账号等
VIRTUAL_VEHICLE  虚拟车辆账号
USER  用户账号
     *
     * @param accountType 账号类型，枚举值，如用户账号、车辆账号等
VIRTUAL_VEHICLE  虚拟车辆账号
USER  用户账号
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
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