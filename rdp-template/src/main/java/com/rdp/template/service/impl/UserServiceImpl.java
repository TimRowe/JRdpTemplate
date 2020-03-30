package com.rdp.template.service.impl;
import com.rdp.template.domain.UserMaster;
import com.rdp.template.repository.UserMasterMapper;
import com.rdp.template.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMasterMapper userMasterMapper;

    @Override
    public int deleteByPrimaryKey(String userId) {
        return userMasterMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(UserMaster record) {
        return userMasterMapper.insert(record);
    }

    @Override
    public int insertSelective(UserMaster record) {
        return userMasterMapper.insertSelective(record);
    }

    @Override
    public UserMaster selectByPrimaryKey(String userId) {
        return userMasterMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(UserMaster record) {
        return userMasterMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserMaster record) {
        return userMasterMapper.updateByPrimaryKey(record);
    }
}