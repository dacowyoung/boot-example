package com.young.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: young
 * @create: 2019/1/23 16:01
 * @desc: xiaoming 配置属性
 */
@Component
@ConfigurationProperties(prefix = "people")
public class PeopleProperties {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public PeopleProperties setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public PeopleProperties setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
