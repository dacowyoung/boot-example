package com.young.ctrl;

import com.young.properties.PeopleProperties;
import org.springframework.beans.factory.annotation.Autowired;
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
