package com.dubai.demonew.domain;

import com.dubai.demonew.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByFirstName(String firstName);

    List<Author> findByFirstNameAndLastName(String firstName, String lastName);

    List<Author> findByLastName(String lastName);

    List<Author> findByFirstNameContainingIgnoreCase(String firstName);
}
