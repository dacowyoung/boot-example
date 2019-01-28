package com.young.service.impl;

import com.young.dao.TestUserMapper;
import com.young.enums.ResultEnum;
import com.young.exception.BusinessException;
import com.young.model.TestUser;
import com.young.model.TestUserExample;
import com.young.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public void getAge(String id) {
        TestUser user = mapper.selectByPrimaryKey(id);
        Integer age = user.getAge();
        if (age < 10) {
            throw new BusinessException(ResultEnum.LITTLE_BOY);
        } else if (age < 16) {
            throw new BusinessException(ResultEnum.YOUNG_MAN);
        }
    }
}
