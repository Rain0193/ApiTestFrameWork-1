package com.test.framework.dao.mysql.dao;

import com.test.framework.dao.mysql.entity.Rule;

public interface RuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Rule record);

    int insertSelective(Rule record);

    Rule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Rule record);

    int updateByPrimaryKey(Rule record);
}