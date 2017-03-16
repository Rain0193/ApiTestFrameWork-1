package com.test.framework.api.responseVO;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @author hong.lin
 * @description
 * @date 2017/2/17.
 */
public class BaseResponse {

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
