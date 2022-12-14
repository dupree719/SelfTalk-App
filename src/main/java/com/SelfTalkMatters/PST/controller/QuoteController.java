package com.SelfTalkMatters.PST.controller;

import com.SelfTalkMatters.PST.model.Quote;
import com.SelfTalkMatters.PST.repo.QuoteRepository;
import com.SelfTalkMatters.PST.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class QuoteController {
    @Autowired
    public QuoteController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    private QuoteService quoteService;
    private final QuoteRepository quoteRepository;

    @GetMapping("/quotes")
    public List<Quote> getAllQuotes(@RequestParam("search") Optional<String> searchParam){
        return searchParam.map(quoteRepository::getContainingQuote).orElse(quoteRepository.findAll());
    }
    @GetMapping("/quotes/random")
    public Quote getRandomQuote() {
        int index = (int) Math.floor(Math.random() * quoteRepository.findAll().size());
        return quoteRepository.findAll().get(index);
    }
    @GetMapping("/authors/{authorId}/quotes")
    public ResponseEntity<Iterable<Quote>> getAllQuotesByAuthorId(@PathVariable(value = "authorId") Long authorId) {
        return new ResponseEntity<>(quoteService.getAllQuotesByAuthorId(authorId), HttpStatus.OK);
    }



//    @PutMapping("/quotes/{quoteId}")
//    public void updateQuoteById(@RequestBody Quote quote, @PathVariable Long quoteId) {
//        quoteService.updateQuote(quoteId, quote);
//    }

//    @GetMapping("/quotes/{quoteId}" )
//    public ResponseEntity<String> getQuoteById(@PathVariable("quoteId") Long id) {
//        return ResponseEntity.of(quoteRepository.findById(id).map( Quote::getQuote ));
//    }

//    @PostMapping("/quotes")
//    public Quote addQuote(@RequestBody String quote) {
//        Quote q = new Quote();
//        q.setQuote(quote);
//        return quoteRepository.save(q);
//    }

    @DeleteMapping("/quotes/{quoteId}")
    public void deleteQuote(@PathVariable(value = "quoteId") Long id) {
        quoteService.deleteQuote(id);
    }
}