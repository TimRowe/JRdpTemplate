package com.rdp.template.repository;

import com.rdp.template.domain.Site;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SiteMapperTest {

    @Autowired
    private SiteMapper siteMapper;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void selectTest() {
        List<Site> siteList = siteMapper.selectList(null);
        siteList.forEach(System.out::println);
    }


}