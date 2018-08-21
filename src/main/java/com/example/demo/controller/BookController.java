package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    final
    private BookRepository bookRepository;
    final
    private AuthorRepository authorRepository;

    @Autowired
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute Book book) {
        System.out.println("book before: " + book);
        int id = book.getAuthor().getId();
        authorRepository.findById(id);
        System.out.println("book after: " + book);
        bookRepository.save(book);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteBookById(@PathVariable("id") int id) {
        bookRepository.deleteById(id);
        return "redirect:/home";
    }
}
