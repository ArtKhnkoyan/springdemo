package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author")
public class AuthorController {

    final
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Author author) {
        authorRepository.save(author);
        System.out.println("author: " + author);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthorById(@PathVariable("id") int id) {
        authorRepository.deleteById(id);
        return "redirect:/home";
    }
}
