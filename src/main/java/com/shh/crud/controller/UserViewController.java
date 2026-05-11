package com.shh.crud.controller;

import com.shh.crud.dto.UserRequestDto;
import com.shh.crud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/users")
public class UserViewController {

    private final UserService service;

    public UserViewController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", service.getAll());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", service.get(id));
        return "user-details";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new UserRequestDto());
        model.addAttribute("isEdit", false);
        return "user-form";
    }

    @PostMapping
    public String createUser(@ModelAttribute UserRequestDto requestDto) {
        service.create(requestDto);
        return "redirect:/web/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", service.get(id));
        model.addAttribute("isEdit", true);
        return "user-form";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id,
                             @ModelAttribute UserRequestDto requestDto) {

        service.update(id, requestDto);
        return "redirect:/web/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/web/users";
    }
}