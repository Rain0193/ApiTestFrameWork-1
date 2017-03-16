package com.test.framework.api.requestVO;

import com.test.framework.common.constansts.type.DeviceOSType;
import com.test.framework.common.constansts.type.LoginMode;

/**
 * @author hong.lin
 * @description
 * @date 2017/2/16.
 */
public class RegisterAndLoginRequest extends BaseRequest{
    private String phoneNumber;

    private String verificationCode;

    private LoginMode loginMode;

    private String ipAddress;

    private String deviceId;

    private DeviceOSType deviceOSType;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public LoginMode getLoginMode() {
        return loginMode;
    }

    public void setLoginMode(LoginMode loginMode) {
        this.loginMode = loginMode;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public DeviceOSType getDeviceOSType() {
        return deviceOSType;
    }

    public void setDeviceOSType(DeviceOSType deviceOSType) {
        this.deviceOSType = deviceOSType;
    }

}
