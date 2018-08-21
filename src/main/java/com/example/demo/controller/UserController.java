package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    final
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    @PostMapping("/add")
//    public String add(@RequestParam("name") String name, @RequestParam("surname") String surname) {
//        User user = User
//                .builder()
//                .name(name)
//                .surname(surname)
//                .build();
//        userRepository.save(user);
//        System.out.println("user: " + user);
//        return "redirect:/home";
//    }

    @PostMapping("/add")
    public String add(@ModelAttribute User user) {
        userRepository.save(user);
        System.out.println("user: " + user);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") int id) {
        userRepository.deleteById(id);
        return "redirect:/home";
    }
}
