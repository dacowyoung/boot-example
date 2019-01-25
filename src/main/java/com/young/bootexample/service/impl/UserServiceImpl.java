package com.young.bootexample.service.impl;

import com.young.bootexample.dao.TestUserMapper;
import com.young.bootexample.model.TestUser;
import com.young.bootexample.model.TestUserExample;
import com.young.bootexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author: young
 * @create: 2019/1/24 15:32
 * @desc: 用户service实现
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TestUserMapper mapper;

    @Override
    public List<TestUser> list(TestUser user) {
        TestUserExample e = new TestUserExample();
        TestUserExample.Criteria c = e.createCriteria();
        if (null != user) {
            if (null != user.getId()) {
                c.andIdEqualTo(user.getId());
            }
            if (null != user.getName()) {
                c.andNameEqualTo(user.getName());
            }
            if (null != user.getAge()) {
                c.andAgeEqualTo(user.getAge());
            }
        }
        return mapper.selectByExample(e);
    }

    @Override
    public void add(TestUser user) {
        mapper.insert(user);
    }

    @Override
    public void edit(TestUser user) {
        mapper.updateByPrimaryKey(user);
    }

    @Override
    public TestUser findOne(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void del(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void addTwo() {
        TestUser user = new TestUser();
        user.setName("军军");
        user.setAge(20);
        mapper.insert(user);
        
        TestUser user1 = new TestUser();
        user1.setName("壮司机");
        mapper.insert(user1);
    }
}
