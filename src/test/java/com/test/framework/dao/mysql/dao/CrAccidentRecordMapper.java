package com.test.framework.dao.mysql.dao;

import com.test.framework.dao.mysql.entity.CrAccidentRecord;

public interface CrAccidentRecordMapper {
    int deleteByPrimaryKey(Long id);
    int deleteAll();
    int insert(CrAccidentRecord record);

    int insertSelective(CrAccidentRecord record);

    CrAccidentRecord selectByPrimaryKey(Long id);
    CrAccidentRecord selectByOrderId(Long orderId);
    int updateByPrimaryKeySelective(CrAccidentRecord record);

    int updateByPrimaryKeyWithBLOBs(CrAccidentRecord record);

    int updateByPrimaryKey(CrAccidentRecord record);
}