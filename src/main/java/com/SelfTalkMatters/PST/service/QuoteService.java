package com.SelfTalkMatters.PST.service;

import com.SelfTalkMatters.PST.model.Quote;
import com.SelfTalkMatters.PST.repo.AuthorRepository;
import com.SelfTalkMatters.PST.repo.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {
    @Autowired
    QuoteRepository quoteRepository;
    @Autowired
    AuthorRepository authorRepo;
    public Iterable<Quote> getAllQuotesByAuthorId(Long authorId){
        return quoteRepository.findByAuthorId(authorId);
    }

//    public Quote createQuote(Quote quoteString){
//        return quoteRepository.save(quoteString);
//    }
//    public List<Quote> getQuotes() {
//        return quoteRepository.findAll();
//    }
    public void deleteQuote(Long Id) {
        quoteRepository.deleteById(Id);
    }

//    public Quote updateQuote(Long ID, Quote newQuote) {
//        Quote quote = quoteRepository.findById(ID).get();
//        quote.setQuote(newQuote.getQuote());
//        return quoteRepository.save(newQuote);
//    }
}
