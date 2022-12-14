package com.SelfTalkMatters.PST.controller;

import com.SelfTalkMatters.PST.model.Author;
import com.SelfTalkMatters.PST.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
@Autowired
AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<Iterable<Author>> getAllAuthors(@RequestParam(required = false) String name){
        return new ResponseEntity<>(authorService.getAllAuthors(name), HttpStatus.OK);
    }
}
