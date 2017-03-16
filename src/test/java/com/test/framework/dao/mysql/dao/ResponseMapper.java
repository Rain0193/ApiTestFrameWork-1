package com.test.framework.dao.mysql.dao;

import com.test.framework.dao.mysql.entity.Response;

public interface ResponseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Response record);

    int insertSelective(Response record);

    Response selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Response record);

    int updateByPrimaryKeyWithBLOBs(Response record);

    int updateByPrimaryKey(Response record);
}