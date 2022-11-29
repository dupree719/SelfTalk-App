package com.SelfTalkMatters.PST.model;

import javax.persistence.*;

@Entity
@Table (name = "quotes")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quoteID")
    private Long id;

    public String getQuote() {
        return quote;
    }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }


    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Column(name = "quote_string")
    private String quote;

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                '}';
    }
}