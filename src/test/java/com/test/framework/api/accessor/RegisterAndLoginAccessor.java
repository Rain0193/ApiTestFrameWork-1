package com.test.framework.api.accessor;

import com.test.framework.api.datasource.DataSource;
import com.test.framework.api.requestVO.RegisterAndLoginRequest;
import com.test.framework.api.responseVO.RegisterAndLoginResponse;

/**
 * @author hong.lin
 * @description
 * @date 2017/2/16.
 */
public class RegisterAndLoginAccessor extends BaseHTTPAccessor {
    @Override
    public String getUrl() {
        return DataSource.getTestBed().getApiBaseUrl()+DataSource.getApiSet().getResigerAndLoginUrlPath();
    }

    public RegisterAndLoginResponse resigerAndLogin(RegisterAndLoginRequest registerAndLoginRequest){
        RegisterAndLoginResponse registerAndLoginResponse = postJson(registerAndLoginRequest,RegisterAndLoginResponse.class,200);
        return registerAndLoginResponse;
    }
}
