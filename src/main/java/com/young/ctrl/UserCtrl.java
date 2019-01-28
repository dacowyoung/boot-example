package com.young.ctrl;

import com.young.data.Result;
import com.young.model.TestUser;
import com.young.service.UserService;
import com.young.utils.ResultUtil;
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
    public Result add(@RequestBody TestUser user) {
        userService.add(user);
        return ResultUtil.success();
    }

    @PutMapping("/user")
    public Result edit(@RequestBody TestUser user) {
        userService.edit(user);
        return ResultUtil.success();
    }

    @GetMapping("/user")
    public Result findOne(@RequestParam("id") String id) {
        return ResultUtil.success(userService.findOne(id));

    }

    @GetMapping("/user/list")
    public Result list(TestUser user) {
        return ResultUtil.success(userService.list(user));
    }

    @DeleteMapping("/user")
    public Result del(@RequestParam("id") String id) {
        userService.del(id);
        return ResultUtil.success();
    }

    @GetMapping("/user/addTwo")
    public void addTwo() {
        userService.addTwo();
    }
    
    @GetMapping("/user/getAge")
    public void getAge(@RequestParam("id") String id){
        userService.getAge(id);
    }

}
