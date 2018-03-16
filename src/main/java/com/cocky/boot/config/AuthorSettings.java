package com.cocky.boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "author")  /* 通过@ConfigurationProperties加载配置文件，p
                                            * refix指定properties的配置前缀。通过value = "{classpath:config/author.properties}"指定配置文件的位置*/
public class AuthorSettings {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AuthorSettings{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
