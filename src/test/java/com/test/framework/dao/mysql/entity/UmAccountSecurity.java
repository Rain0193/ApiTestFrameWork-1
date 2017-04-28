package com.test.framework.dao.mysql.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "um_account_security")
public class UmAccountSecurity {
    /**
     * ����
     */
    @Id
    private Long id;

    /**
     * �˺�ID
     */
    @Column(name = "account_id")
    private Long accountId;

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
     * ��ȡ����
     *
     * @return id - ����
     */
    public Long getId() {
        return id;
    }

    /**
     * ��������
     *
     * @param id ����
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * ��ȡ�˺�ID
     *
     * @return account_id - �˺�ID
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * �����˺�ID
     *
     * @param accountId �˺�ID
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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