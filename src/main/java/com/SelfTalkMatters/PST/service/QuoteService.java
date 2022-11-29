package com.SelfTalkMatters.PST.service;

import com.SelfTalkMatters.PST.model.Quote;
import com.SelfTalkMatters.PST.repo.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {
    @Autowired
    QuoteRepository quoteRepository;


    public Quote createQuote(Quote quote){
        return quoteRepository.save(quote);
    }
    public void deleteQuote(Long ID) {
        quoteRepository.deleteById(ID);
    }

    public Quote updateQuote(Long ID, Quote newQuote) {
        Quote quote = quoteRepository.findById(ID).get();
        quote.setQuote(newQuote.getQuote());
        return quoteRepository.save(newQuote);
    }
}
