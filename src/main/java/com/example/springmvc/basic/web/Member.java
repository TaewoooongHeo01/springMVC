package com.example.springmvc.basic.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

    private String name;
    private int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Member() {
    }
}
