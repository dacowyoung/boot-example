package com.young.service;

import com.young.model.TestUser;

import java.util.List;

/**
 * @author: young
 * @create: 2019/1/24 15:30
 * @desc: 用户service
 */
public interface UserService {

    List<TestUser> list(TestUser user);

    void add(TestUser user);

    void edit(TestUser user);

    TestUser findOne(String id);

    void del(String id);

    void addTwo();

    void getAge(String id);
}
