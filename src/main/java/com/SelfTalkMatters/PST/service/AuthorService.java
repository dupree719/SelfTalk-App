package com.SelfTalkMatters.PST.service;

import com.SelfTalkMatters.PST.model.Author;
import com.SelfTalkMatters.PST.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepo;
    public Iterable<Author> getAllAuthors(String name) {
        Iterable<Author> allAuthors = authorRepo.findByNameContaining(name);
        authorRepo.findByNameContaining(name);
        return allAuthors;
    }
}
