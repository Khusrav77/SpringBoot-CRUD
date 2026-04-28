package com.shh.crud.service;

import org.apache.catalina.User;
import java.util.List;
import java.util.Optional;

public interface Service {
    Optional<Integer> create(User user);
    Optional<User> get(Long id);
    List<User> getAll();
    String update();
    String delete();
}
