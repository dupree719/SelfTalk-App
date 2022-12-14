package com.SelfTalkMatters.PST.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table (name = "quotes")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quoteID")
    private Long id;

    public Quote(){

    }
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "authorID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

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