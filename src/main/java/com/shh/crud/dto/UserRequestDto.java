package com.shh.crud.dto;

import org.antlr.v4.runtime.misc.NotNull;

public class UserRequestDto {
    @NotNull
    private String name;
    @NotNull
    private Integer age;

    public String getName() {return name;}
    public Integer getAge() {return age;}
    public void setName(String name) {this.name = name;}
    public void setAge(Integer age) {this.age = age;}
}
