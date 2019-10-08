package com.xgl.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.netflix.appinfo.DataCenterInfo;

/*
 *User
 *
 *@author 87990
 *@email
 *@date 2019/9/27
 */
@JsonDeserialize
public class User {
    private Long id;
    private String name;

    /**
     * 如果不定义@JsonCreator,com.fasterxml.jackson.将会使用默认的构造方法
     * 如果没有默认的构造方法就会报错
     *
     * @param id
     * @param name
     */
    @JsonCreator
    public User(@JsonProperty("id") Long id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

//    public User() {
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String json() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":'" + name + '\'' +
                '}';
    }
}
