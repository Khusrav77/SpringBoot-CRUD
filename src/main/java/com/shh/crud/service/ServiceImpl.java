package com.shh.crud.service;

import org.apache.catalina.User;

import java.util.List;
import java.util.Optional;

public class ServiceImpl implements Service {
    @Override
    public Optional<Integer> create(User user) {
        return Optional.empty();
    }

    @Override
    public Optional<User> get(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public String update() {
        return "";
    }

    @Override
    public String delete() {
        return "";
    }
}
