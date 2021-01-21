package com.yjy.springlearn.demo.controller;

import com.yjy.springlearn.demo.entity.Author;
import com.yjy.springlearn.demo.entity.Book;
import com.yjy.springlearn.demo.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    Userservice userservice;


    @RequestMapping("/index")
    public String hello(){
        return "index";
    }
    @RequestMapping("/getbook")
    public Book getBooks() {
        Book bl = new Book();
        bl.setAuthor("萨达");
        bl.setId(1);
        bl.setName("");
        return bl;
    }

    @RequestMapping("/welcome")
    public String welcome(String id) {
        userservice.getUserById(Integer.parseInt(id));
        return "hello";
    }

    @RequestMapping("/testFastJsonMap")
    public Map testFastJsonMap() {
        Map<String, String> map = new HashMap<>();
        map.put("1", null);
        map.put("2", null);
        map.put("3", null);
        map.put("4", null);
        return map;
    }

    @RequestMapping("/testinitbinder")
    public String initbinder(@ModelAttribute("b") Book book, @ModelAttribute("a")Author author){
        return book.toString()+"___"+author.toString();

    }
}
