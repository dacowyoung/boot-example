package com.young.ctrl;

import com.young.model.TestUser;
import com.young.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: young
 * @create: 2019/1/24 15:29
 * @desc: 用户控制器
 */
@RestController
public class UserCtrl {

    private final static Logger log = LoggerFactory.getLogger(UserCtrl.class);

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public void add(@RequestBody TestUser user) {
        userService.add(user);
    }

    @PutMapping("/user")
    public void edit(@RequestBody TestUser user) {
        userService.edit(user);
    }

    @GetMapping("/user")
    public TestUser findOne(@RequestParam("id") String id) {
        return userService.findOne(id);
    }

    @GetMapping("/user/list")
    public List<TestUser> list(TestUser user) {
        return userService.list(user);
    }

    @DeleteMapping("/user")
    public void del(@RequestParam("id") String id) {
        userService.del(id);
    }

    @GetMapping("/user/addTwo")
    public void addTwo() {
        userService.addTwo();
    }

}
