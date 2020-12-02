package com.iw2f.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.iw2f.po.TestPO;

@Mapper
public interface TestPOMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(TestPO record);

    int insertSelective(TestPO record);

    TestPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestPO record);

    int updateByPrimaryKey(TestPO record);
}