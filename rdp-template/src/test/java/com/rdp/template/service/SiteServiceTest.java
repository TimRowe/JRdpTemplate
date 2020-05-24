package com.rdp.template.service;

import com.rdp.template.domain.Site;
import com.rdp.template.repository.SiteMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SiteServiceTest {

    @Autowired
    private SiteService siteService;

    @Test
    public void selectTest() {
        //List<Site> siteList = siteMapper.selectList(null);
        //siteList.forEach(System.out::println);
    }

    @Test
    public void getByIdTest(){
        var site = siteService.getById(1);
        assert(site.getSiteDesc().equals("10.201.248.17"));
    }
}