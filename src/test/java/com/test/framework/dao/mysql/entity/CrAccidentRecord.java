package com.test.framework.dao.mysql.entity;

import java.util.Date;

public class CrAccidentRecord {
    private Long id;

    private Long vehicleId;

    private Long orderId;

    private Date accidentTime;

    private String accidentAddress;

    private String accidentType;

    private String accidentClass;

    private String confirmationCode;

    private Date createTime;

    private Date updateTime;

    private String createBy;

    private String updateBy;

    private String accidentContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getAccidentTime() {
        return accidentTime;
    }

    public void setAccidentTime(Date accidentTime) {
        this.accidentTime = accidentTime;
    }

    public String getAccidentAddress() {
        return accidentAddress;
    }

    public void setAccidentAddress(String accidentAddress) {
        this.accidentAddress = accidentAddress == null ? null : accidentAddress.trim();
    }

    public String getAccidentType() {
        return accidentType;
    }

    public void setAccidentType(String accidentType) {
        this.accidentType = accidentType == null ? null : accidentType.trim();
    }

    public String getAccidentClass() {
        return accidentClass;
    }

    public void setAccidentClass(String accidentClass) {
        this.accidentClass = accidentClass == null ? null : accidentClass.trim();
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode == null ? null : confirmationCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public String getAccidentContent() {
        return accidentContent;
    }

    public void setAccidentContent(String accidentContent) {
        this.accidentContent = accidentContent == null ? null : accidentContent.trim();
    }
}