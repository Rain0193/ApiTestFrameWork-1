package com.test.framework.api.datasource;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ApiSet {

    /*用户服务*/
    private String userFeedbackUrlPath;
    private String getUserListUrlPath;
    private String resigerAndLoginUrlPath;
    private String auditUserUrlPath;
    private String commitUserUrlPath;
    private String getUserIdphotocopiesUrlPath;
    private String getUserPicsUrlPath;
    private String lockOrUnLockUserUrlPath;
    private String getUserInfoUrlPath;
    private String getUsersOrdersUrlPath;
    private String getUserCouponsUrlPath;
    private String getUserMessagesUrlPath;
    private String modifyUserInfoUrlPath;
    private String getAllTagsUrlPath;

    /*车辆服务*/
    private String reportAbnormitiesUrlPath;
    private String remoteLockDoorUrlPath;
    private String remoteUnLockDoorUrlPath;
    private String getDrivingLicenseUrlPath;
    private String getVechiclesListUrlPath;
    private String getVechiclesDetailUrlPath;
    private String addVehicleUrlPath;
    private String vehicleOnlineUrlPath;
    private String vehicleOfflineUrlPath;
    private String vehicleConditionStatusUrlPath;
    private String vehicleAbnormitiesUrlPath;
    private String vehicleLockUrlPath;
    private String vehicleUnlockUrlPath;
    private String getVehiclesUrlPath;
    private String findCarFlashHornUrlPath;


    /*实用服务*/
    private String uploadPicturesUrlPath;
    private String deletePicturesUrlPath;
    private String sendSmsVerificationCodeUrlPath;
    private String vechiclesDetailUrlPath;
    private String sendMessagesUrlPath;


    /*订单服务*/
    private String reserveOrdersUrlPath;
    private String getOrdersListUrlPath;
    private String getOrderInfoUrlPath;
    private String modifOrderStatusUrlPath;
    private String closeOrderUrlPath;
    private String confirmOrCancelOrderUrlPath;
    private String getOrderDetailsUrlPath;
    private String returnVehicleUrlPath;
    private String prepayOrderUrlPath;

    /*站点服务*/
    private String modifySiteInfoUrlPath;
    private String addSitesUrlPath;
    private String searchSiteUrlPath;
    private String siteOnlineUrlPath;
    private String siteOfflineUrlPath;
    private String siteNotificationsUrlPath;
    private String getSiteUrlPath;


    /*地区服务*/
    private String getCityAreasUrlPath;
    private String getCityUrlPath;
    private String getHotCitiesUrlPath;
    private String getAreasStreetsUrlPath;
    private String getOpenedCitiesUrlPath;
    private String searchStreetsUrlPath;
    private String getProvincesUrlPath;

    /*车型服务*/
    private String getPriceRulesUrlPath;
    private String deleteVehicleModelUrlPath;
    private String addVehicleModelsUrlPath;
    private String searchVehicleModelsUrlPath;

    public String getGetSiteUrlPath() {
        return getSiteUrlPath;
    }

    public void setGetSiteUrlPath(String getSiteUrlPath) {
        this.getSiteUrlPath = getSiteUrlPath;
    }

    public String getGetProvincesUrlPath() {
        return getProvincesUrlPath;
    }

    public void setGetProvincesUrlPath(String getProvincesUrlPath) {
        this.getProvincesUrlPath = getProvincesUrlPath;
    }

    public String getSearchVehicleModelsUrlPath() {
        return searchVehicleModelsUrlPath;
    }

    public void setSearchVehicleModelsUrlPath(String searchVehicleModelsUrlPath) {
        this.searchVehicleModelsUrlPath = searchVehicleModelsUrlPath;
    }

    public String getDeleteVehicleModelUrlPath() {
        return deleteVehicleModelUrlPath;
    }

    public void setDeleteVehicleModelUrlPath(String deleteVehicleModelUrlPath) {
        this.deleteVehicleModelUrlPath = deleteVehicleModelUrlPath;
    }

    public String getGetPriceRulesUrlPath() {
        return getPriceRulesUrlPath;
    }

    public void setGetPriceRulesUrlPath(String getPriceRulesUrlPath) {
        this.getPriceRulesUrlPath = getPriceRulesUrlPath;
    }

    public String getSearchSiteUrlPath() {return searchSiteUrlPath;}

    public void setSearchSiteUrlPath(String searchSiteUrlPath) {this.searchSiteUrlPath = searchSiteUrlPath;}

    public String getAddVehicleModelsUrlPath() {
        return addVehicleModelsUrlPath;
    }

    public void setAddVehicleModelsUrlPath(String addVehicleModelsUrlPath) {
        this.addVehicleModelsUrlPath = addVehicleModelsUrlPath;
    }

    public String getGetAllTagsUrlPath() {
        return getAllTagsUrlPath;
    }

    public void setGetAllTagsUrlPath(String getAllTagsUrlPath) {
        this.getAllTagsUrlPath = getAllTagsUrlPath;
    }

    public String getGetVehiclesUrlPath() {
        return getVehiclesUrlPath;
    }

    public void setGetVehiclesUrlPath(String getVehiclesUrlPath) {
        this.getVehiclesUrlPath = getVehiclesUrlPath;
    }

    public String getUserFeedbackUrlPath() {
        return userFeedbackUrlPath;
    }

    public void setUserFeedbackUrlPath(String userFeedbackUrlPath) {
        this.userFeedbackUrlPath = userFeedbackUrlPath;
    }

    public String getVehicleUnlockUrlPath() {
        return vehicleUnlockUrlPath;
    }

    public void setVehicleUnlockUrlPath(String vehicleUnlockUrlPath) {
        this.vehicleUnlockUrlPath = vehicleUnlockUrlPath;
    }

    public String getVehicleLockUrlPath() {
        return vehicleLockUrlPath;
    }

    public void setVehicleLockUrlPath(String vehicleLockUrlPath) {
        this.vehicleLockUrlPath = vehicleLockUrlPath;
    }

    public String getSiteOnlineUrlPath() {
        return siteOnlineUrlPath;
    }

    public void setSiteOnlineUrlPath(String siteOnlineUrlPath) {
        this.siteOnlineUrlPath = siteOnlineUrlPath;
    }

    public String getAddSitesUrlPath() {return addSitesUrlPath;}

    public void setAddSitesUrlPath(String addSitesUrlPath) {this.addSitesUrlPath = addSitesUrlPath;}

    public String getGetUserMessagesUrlPath() {
        return getUserMessagesUrlPath;
    }

    public void setGetUserMessagesUrlPath(String getUserMessagesUrlPath) {
        this.getUserMessagesUrlPath = getUserMessagesUrlPath;
    }

    public String getGetUserCouponsUrlPath() {
        return getUserCouponsUrlPath;
    }

    public void setGetUserCouponsUrlPath(String getUserCouponsUrlPath) {
        this.getUserCouponsUrlPath = getUserCouponsUrlPath;
    }

    public String getReturnVehicleUrlPath() {
        return returnVehicleUrlPath;
    }

    public void setReturnVehicleUrlPath(String returnVehicleUrlPath) {
        this.returnVehicleUrlPath = returnVehicleUrlPath;
    }

    public String getVehicleOfflineUrlPath() {
        return vehicleOfflineUrlPath;
    }

    public void setVehicleOfflineUrlPath(String vehicleOfflineUrlPath) {
        this.vehicleOfflineUrlPath = vehicleOfflineUrlPath;
    }

    public String getReportAbnormitiesUrlPath() {
        return reportAbnormitiesUrlPath;
    }

    public void setReportAbnormitiesUrlPath(String reportAbnormitiesUrlPath) {
        this.reportAbnormitiesUrlPath = reportAbnormitiesUrlPath;
    }

    public String getRemoteLockDoorUrlPath() {
        return remoteLockDoorUrlPath;
    }

    public void setRemoteLockDoorUrlPath(String remoteLockDoorUrlPath) {
        this.remoteLockDoorUrlPath = remoteLockDoorUrlPath;
    }

    public String getRemoteUnLockDoorUrlPath() {
        return remoteUnLockDoorUrlPath;
    }

    public void setRemoteUnLockDoorUrlPath(String remoteUnLockDoorUrlPath) {
        this.remoteUnLockDoorUrlPath = remoteUnLockDoorUrlPath;
    }

    public String getGetDrivingLicenseUrlPath() {
        return getDrivingLicenseUrlPath;
    }

    public void setGetDrivingLicenseUrlPath(String getDrivingLicenseUrlPath) {
        this.getDrivingLicenseUrlPath = getDrivingLicenseUrlPath;
    }

    public String getFindCarFlashHornUrlPath() {
        return findCarFlashHornUrlPath;
    }

    public void setFindCarFlashHornUrlPath(String findCarFlashHornUrlPath) {
        this.findCarFlashHornUrlPath = findCarFlashHornUrlPath;
    }

    public String getGetUserListUrlPath() {
        return getUserListUrlPath;
    }

    public void setGetUserListUrlPath(String getUserListUrlPath) {
        this.getUserListUrlPath = getUserListUrlPath;
    }

    public String getResigerAndLoginUrlPath() {
        return resigerAndLoginUrlPath;
    }

    public void setResigerAndLoginUrlPath(String resigerAndLoginUrlPath) {
        this.resigerAndLoginUrlPath = resigerAndLoginUrlPath;
    }

    public String getAuditUserUrlPath() {
        return auditUserUrlPath;
    }

    public void setAuditUserUrlPath(String auditUserUrlPath) {
        this.auditUserUrlPath = auditUserUrlPath;
    }

    public String getCommitUserUrlPath() {
        return commitUserUrlPath;
    }

    public void setCommitUserUrlPath(String commitUserUrlPath) {
        this.commitUserUrlPath = commitUserUrlPath;
    }

    public String getGetUserIdphotocopiesUrlPath() {
        return getUserIdphotocopiesUrlPath;
    }

    public void setGetUserIdphotocopiesUrlPath(String getUserIdphotocopiesUrlPath) {
        this.getUserIdphotocopiesUrlPath = getUserIdphotocopiesUrlPath;
    }

    public String getGetUserPicsUrlPath() {
        return getUserPicsUrlPath;
    }

    public void setGetUserPicsUrlPath(String getUserPicsUrlPath) {
        this.getUserPicsUrlPath = getUserPicsUrlPath;
    }

    public String getLockOrUnLockUserUrlPath() {
        return lockOrUnLockUserUrlPath;
    }

    public void setLockOrUnLockUserUrlPath(String lockOrUnLockUserUrlPath) {
        this.lockOrUnLockUserUrlPath = lockOrUnLockUserUrlPath;
    }

    public String getGetUserInfoUrlPath() {
        return getUserInfoUrlPath;
    }

    public void setGetUserInfoUrlPath(String getUserInfoUrlPath) {
        this.getUserInfoUrlPath = getUserInfoUrlPath;
    }

    public String getGetUsersOrdersUrlPath() {
        return getUsersOrdersUrlPath;
    }

    public void setGetUsersOrdersUrlPath(String getUsersOrdersUrlPath) {
        this.getUsersOrdersUrlPath = getUsersOrdersUrlPath;
    }

    public String getGetVechiclesListUrlPath() {
        return getVechiclesListUrlPath;
    }

    public void setGetVechiclesListUrlPath(String getVechiclesListUrlPath) {
        this.getVechiclesListUrlPath = getVechiclesListUrlPath;
    }

    public String getGetVechiclesDetailUrlPath() {
        return getVechiclesDetailUrlPath;
    }

    public void setGetVechiclesDetailUrlPath(String getVechiclesDetailUrlPath) {
        this.getVechiclesDetailUrlPath = getVechiclesDetailUrlPath;
    }

    public String getAddVehicleUrlPath() {
        return addVehicleUrlPath;
    }

    public void setAddVehicleUrlPath(String addVehicleUrlPath) {
        this.addVehicleUrlPath = addVehicleUrlPath;
    }

    public String getModifyUserInfoUrlPath() {
        return modifyUserInfoUrlPath;
    }

    public void setModifyUserInfoUrlPath(String modifyUserInfoUrlPath) {
        this.modifyUserInfoUrlPath = modifyUserInfoUrlPath;
    }

    public String getVehicleOnlineUrlPath() {
        return vehicleOnlineUrlPath;
    }

    public void setVehicleOnlineUrlPath(String vehicleOnlineUrlPath) {
        this.vehicleOnlineUrlPath = vehicleOnlineUrlPath;
    }

    public String getUploadPicturesUrlPath() {
        return uploadPicturesUrlPath;
    }

    public void setUploadPicturesUrlPath(String uploadPicturesUrlPath) {
        this.uploadPicturesUrlPath = uploadPicturesUrlPath;
    }

    public String getDeletePicturesUrlPath() {
        return deletePicturesUrlPath;
    }

    public void setDeletePicturesUrlPath(String deletePicturesUrlPath) {
        this.deletePicturesUrlPath = deletePicturesUrlPath;
    }

    public String getSendSmsVerificationCodeUrlPath() {
        return sendSmsVerificationCodeUrlPath;
    }

    public void setSendSmsVerificationCodeUrlPath(String sendSmsVerificationCodeUrlPath) {
        this.sendSmsVerificationCodeUrlPath = sendSmsVerificationCodeUrlPath;
    }

    public String getVechiclesDetailUrlPath() {
        return vechiclesDetailUrlPath;
    }

    public void setVechiclesDetailUrlPath(String vechiclesDetailUrlPath) {
        this.vechiclesDetailUrlPath = vechiclesDetailUrlPath;
    }

    public String getReserveOrdersUrlPath() {
        return reserveOrdersUrlPath;
    }

    public void setReserveOrdersUrlPath(String reserveOrdersUrlPath) {
        this.reserveOrdersUrlPath = reserveOrdersUrlPath;
    }

    public String getGetOrdersListUrlPath() {
        return getOrdersListUrlPath;
    }

    public void setGetOrdersListUrlPath(String getOrdersListUrlPath) {
        this.getOrdersListUrlPath = getOrdersListUrlPath;
    }

    public String getGetOrderInfoUrlPath() {
        return getOrderInfoUrlPath;
    }

    public void setGetOrderInfoUrlPath(String getOrderInfoUrlPath) {
        this.getOrderInfoUrlPath = getOrderInfoUrlPath;
    }

    public String getModifOrderStatusUrlPath() {
        return modifOrderStatusUrlPath;
    }

    public void setModifOrderStatusUrlPath(String modifOrderStatusUrlPath) {
        this.modifOrderStatusUrlPath = modifOrderStatusUrlPath;
    }

    public String getCloseOrderUrlPath() {
        return closeOrderUrlPath;
    }

    public void setCloseOrderUrlPath(String closeOrderUrlPath) {
        this.closeOrderUrlPath = closeOrderUrlPath;
    }

    public String getConfirmOrCancelOrderUrlPath() {
        return confirmOrCancelOrderUrlPath;
    }

    public void setConfirmOrCancelOrderUrlPath(String confirmOrCancelOrderUrlPath) {
        this.confirmOrCancelOrderUrlPath = confirmOrCancelOrderUrlPath;
    }

    public String getGetOrderDetailsUrlPath() {
        return getOrderDetailsUrlPath;
    }

    public void setGetOrderDetailsUrlPath(String getOrderDetailsUrlPath) {
        this.getOrderDetailsUrlPath = getOrderDetailsUrlPath;
    }

    public String getVehicleAbnormitiesUrlPath() {
        return vehicleAbnormitiesUrlPath;
    }

    public void setVehicleAbnormitiesUrlPath(String vehicleAbnormitiesUrlPath) {
        this.vehicleAbnormitiesUrlPath = vehicleAbnormitiesUrlPath;
    }


    public String getPrepayOrderUrlPath() {
        return prepayOrderUrlPath;
    }

    public void setPrepayOrderUrlPath(String prepayOrderUrlPath) {
        this.prepayOrderUrlPath = prepayOrderUrlPath;
    }

    public String getVehicleConditionStatusUrlPath() {
        return vehicleConditionStatusUrlPath;
    }

    public void setVehicleConditionStatusUrlPath(String vehicleConditionStatusUrlPath) {
        this.vehicleConditionStatusUrlPath = vehicleConditionStatusUrlPath;
    }

    public String getSendMessagesUrlPath() {
        return sendMessagesUrlPath;
    }

    public void setSendMessagesUrlPath(String sendMessagesUrlPath) {
        this.sendMessagesUrlPath = sendMessagesUrlPath;
    }

    public String getModifySiteInfoUrlPath() {
        return modifySiteInfoUrlPath;
    }

    public void setModifySiteInfoUrlPath(String modifySiteInfoUrlPath) {
        this.modifySiteInfoUrlPath = modifySiteInfoUrlPath;
    }

    public String getGetCityAreasUrlPath() {
        return getCityAreasUrlPath;
    }

    public void setGetCityAreasUrlPath(String getCityAreasUrlPath) {
        this.getCityAreasUrlPath = getCityAreasUrlPath;
    }

    public String getSiteOfflineUrlPath() {
        return siteOfflineUrlPath;
    }

    public void setSiteOfflineUrlPath(String siteOfflineUrlPath) {
        this.siteOfflineUrlPath = siteOfflineUrlPath;
    }

    public String getSiteNotificationsUrlPath() {
        return siteNotificationsUrlPath;
    }

    public void setSiteNotificationsUrlPath(String siteNotificationsUrlPath) {
        this.siteNotificationsUrlPath = siteNotificationsUrlPath;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getGetCityUrlPath() {
        return getCityUrlPath;
    }

    public void setGetCityUrlPath(String getCityUrlPath) {
        this.getCityUrlPath = getCityUrlPath;
    }

    public String getGetHotCitiesUrlPath() {
        return getHotCitiesUrlPath;
    }

    public void setGetHotCitiesUrlPath(String getHotCitiesUrlPath) {
        this.getHotCitiesUrlPath = getHotCitiesUrlPath;
    }

    public String getGetAreasStreetsUrlPath() {
        return getAreasStreetsUrlPath;
    }

    public void setGetAreasStreetsUrlPath(String getAreasStreetsUrlPath) {
        this.getAreasStreetsUrlPath = getAreasStreetsUrlPath;
    }

    public String getGetOpenedCitiesUrlPath() {
        return getOpenedCitiesUrlPath;
    }

    public void setGetOpenedCitiesUrlPath(String getOpenedCitiesUrlPath) {
        this.getOpenedCitiesUrlPath = getOpenedCitiesUrlPath;
    }

    public String getSearchStreetsUrlPath() {
        return searchStreetsUrlPath;
    }

    public void setSearchStreetsUrlPath(String searchStreetsUrlPath) {
        this.searchStreetsUrlPath = searchStreetsUrlPath;
    }

}

