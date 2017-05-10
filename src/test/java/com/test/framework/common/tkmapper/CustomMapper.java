package com.test.framework.common.tkmapper;

import com.test.framework.common.tkmapper.providers.DeleteAllProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author hong.lin
 * @description
 * @date 2017/4/28.
 */
public interface CustomMapper<T> extends Mapper<T>{

    @DeleteProvider(type = DeleteAllProvider.class, method = "delAll")
    void delAll();
}
