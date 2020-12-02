package com.iw2f.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iw2f.annotation.Master;
import com.iw2f.mapper.TestPOMapper;
import com.iw2f.po.TestPO;

@Service
public class TestService{

    @Autowired
    private TestPOMapper testPOMapper;

    public int insert(TestPO aaa) {
        return testPOMapper.insert(aaa);
    }

    @Master
    public int save(TestPO aaa) {
        return testPOMapper.insert(aaa);
    }

    public TestPO selectByPrimaryKey(Long id) {
        return testPOMapper.selectByPrimaryKey(id);
    }

    @Master
    public TestPO getById(Long id) {
        //  有些读操作必须读主数据库
        //  比如，获取微信access_token，因为高峰时期主从同步可能延迟
        //  这种情况下就必须强制从主数据读
        return testPOMapper.selectByPrimaryKey(id);
    }
}
