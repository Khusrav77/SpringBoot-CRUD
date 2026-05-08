package com.shh.crud.dto;

import org.antlr.v4.runtime.misc.NotNull;

public class UserRequestDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer age;

    public UserRequestDto() {}

    public String getName() {return name;}
    public Integer getAge() {return age;}
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setAge(Integer age) {this.age = age;}
}
