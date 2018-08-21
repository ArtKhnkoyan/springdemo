package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.User;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    final
    private UserRepository userRepository;
    final
    private AuthorRepository authorRepository;
    final
    private BookRepository bookRepository;

    @Autowired
    public MainController(UserRepository userRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    //    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String main() {
        System.out.println("kuku");
        return "index";
    }

    @GetMapping("/home")
    public String home(ModelMap modelMap) {
        List<User> userList = userRepository.findAll();
        List<Author> authorList = authorRepository.findAll();
        List<Book> bookList = bookRepository.findAll();
        modelMap.addAttribute("user", new User());
        modelMap.addAttribute("users", userList);
        modelMap.addAttribute("authors", authorList);
        modelMap.addAttribute("book", new Book());
        modelMap.addAttribute("books", bookList);
        return "home";
    }

}
