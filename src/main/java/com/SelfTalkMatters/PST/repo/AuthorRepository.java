package com.SelfTalkMatters.PST.repo;

import com.SelfTalkMatters.PST.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Iterable<Author> findByNameContaining(String name);
}

