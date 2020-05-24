package com.rdp.template.service.impl;

import com.rdp.template.repository.RequestLogMapper;
import com.rdp.template.repository.UserMasterMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestLogServiceImplTest {

    @Autowired
    private UserMasterMapper userMasterMapper;

    @Test
    public void deleteByPrimaryKey() {
        Assert.assertEquals(100, 90);
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        var name = userMasterMapper.selectByPrimaryKey("10030753").getUserName();
        name = "";
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void batchInsert() {
    }



}