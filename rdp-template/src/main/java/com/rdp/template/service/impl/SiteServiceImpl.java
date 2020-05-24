package com.rdp.template.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rdp.template.domain.Site;
import com.rdp.template.repository.SiteMapper;
import com.rdp.template.service.SiteService;
import org.springframework.stereotype.Service;

@Service
public class SiteServiceImpl extends ServiceImpl<SiteMapper, Site> implements SiteService {
    
}
