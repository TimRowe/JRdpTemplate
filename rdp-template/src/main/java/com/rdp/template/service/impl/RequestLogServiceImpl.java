package com.rdp.template.service.impl;
import com.rdp.template.domain.RequestLog;
import com.rdp.template.repository.RequestLogMapper;
import com.rdp.template.service.RequestLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestLogServiceImpl implements RequestLogService {

    @Autowired
    private RequestLogMapper requestLogMapper;

    @Override
    public int deleteByPrimaryKey(String seq) {
        return requestLogMapper.deleteByPrimaryKey(seq);
    }

    @Override
    public int insert(RequestLog record) {
        return requestLogMapper.insert(record);
    }

    @Override
    public int insertSelective(RequestLog record) {
        return requestLogMapper.insertSelective(record);
    }

    @Override
    public RequestLog selectByPrimaryKey(String seq) {
        return requestLogMapper.selectByPrimaryKey(seq);
    }

    @Override
    public int updateByPrimaryKeySelective(RequestLog record) {
        return requestLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RequestLog record) {
        return requestLogMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<RequestLog> recordList) {
        return requestLogMapper.batchInsert(recordList);
    }
}