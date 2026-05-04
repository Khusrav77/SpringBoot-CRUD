package com.shh.crud.controller;

import com.shh.crud.dto.UserRequestDto;
import com.shh.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/users")
public class UserViewController {

    private final UserService service;

    @Autowired
    UserViewController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public String creatUser(@ModelAttribute UserRequestDto requestDto) {
        service.create(requestDto);
        return "redirect:/web/users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        model.addAttribute("users", service.get(id));
        return "users";
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", service.getAll());
        return "users";
    }

    @PostMapping
    public String updateUser(@PathVariable Long id, @ModelAttribute UserRequestDto requestDto) {
        service.update(id, requestDto);
        return "redirect:/web/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/web/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", service.get(id));
        return "edit-user";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new UserRequestDto());
        return "create-user";
    }

}
