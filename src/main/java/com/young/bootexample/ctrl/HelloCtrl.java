package com.young.bootexample.ctrl;

import com.young.bootexample.properties.PeopleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: young
 * @create: 2019/1/23 15:41
 * @desc: hello, springBoot!
 */
@RestController
public class HelloCtrl {

    @Autowired
    private PeopleProperties people;

    @GetMapping(value = {"/hello", "/hi"})
    public String say() {
        return "hello,springBoot!";
    }

    @GetMapping("/people")
    public String people() {
        return people.toString();
    }
}
