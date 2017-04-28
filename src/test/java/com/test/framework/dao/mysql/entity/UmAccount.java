package com.test.framework.dao.mysql.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "um_account")
public class UmAccount {
    /**
     * �û�ID
     */
    @Id
    private Long id;

    /**
     * �û���¼�˺�
     */
    @Column(name = "login_account")
    private String loginAccount;

    /**
     * �û���¼����
     */
    @Column(name = "login_pwd")
    private String loginPwd;

    /**
     * �˺����ͣ�ö��ֵ�����û��˺š������˺ŵ�
VIRTUAL_VEHICLE  ���⳵���˺�
USER  �û��˺�
     */
    @Column(name = "account_type")
    private String accountType;

    /**
     * ����ʱ��
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * ����ʱ��
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * �����û�
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * �޸��û�
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * ��ȡ�û�ID
     *
     * @return id - �û�ID
     */
    public Long getId() {
        return id;
    }

    /**
     * �����û�ID
     *
     * @param id �û�ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * ��ȡ�û���¼�˺�
     *
     * @return login_account - �û���¼�˺�
     */
    public String getLoginAccount() {
        return loginAccount;
    }

    /**
     * �����û���¼�˺�
     *
     * @param loginAccount �û���¼�˺�
     */
    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount == null ? null : loginAccount.trim();
    }

    /**
     * ��ȡ�û���¼����
     *
     * @return login_pwd - �û���¼����
     */
    public String getLoginPwd() {
        return loginPwd;
    }

    /**
     * �����û���¼����
     *
     * @param loginPwd �û���¼����
     */
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    /**
     * ��ȡ�˺����ͣ�ö��ֵ�����û��˺š������˺ŵ�
VIRTUAL_VEHICLE  ���⳵���˺�
USER  �û��˺�
     *
     * @return account_type - �˺����ͣ�ö��ֵ�����û��˺š������˺ŵ�
VIRTUAL_VEHICLE  ���⳵���˺�
USER  �û��˺�
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * �����˺����ͣ�ö��ֵ�����û��˺š������˺ŵ�
VIRTUAL_VEHICLE  ���⳵���˺�
USER  �û��˺�
     *
     * @param accountType �˺����ͣ�ö��ֵ�����û��˺š������˺ŵ�
VIRTUAL_VEHICLE  ���⳵���˺�
USER  �û��˺�
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    /**
     * ��ȡ����ʱ��
     *
     * @return create_time - ����ʱ��
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * ���ô���ʱ��
     *
     * @param createTime ����ʱ��
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * ��ȡ����ʱ��
     *
     * @return update_time - ����ʱ��
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * ���ø���ʱ��
     *
     * @param updateTime ����ʱ��
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * ��ȡ�����û�
     *
     * @return create_by - �����û�
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * ���ô����û�
     *
     * @param createBy �����û�
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * ��ȡ�޸��û�
     *
     * @return update_by - �޸��û�
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * �����޸��û�
     *
     * @param updateBy �޸��û�
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}