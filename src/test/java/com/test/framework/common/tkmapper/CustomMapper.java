package com.test.framework.common.tkmapper;

import com.test.framework.common.tkmapper.providers.MyProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import tk.mybatis.mapper.common.*;
import tk.mybatis.mapper.common.special.InsertListMapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

/**
 * @author hong.lin
 * @description
 * @date 2017/4/28.
 */
public interface CustomMapper<T> extends BaseMapper<T>,ConditionMapper<T>,IdsMapper<T>,MySqlMapper<T>,RowBoundsMapper<T>,InsertListMapper<T>,InsertUseGeneratedKeysMapper<T>,Marker {
    @DeleteProvider(type = MyProvider.class, method = "dynamicSQL")
    void delAll();
}
