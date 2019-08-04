package com.dubai.demonew.domain;

import com.dubai.demonew.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainsOrderByTitleAsc(String title);

    List<Book> findByTitleContains(String title, Sort sort);

    List<Book> findFirst5ByTitleOrderByTitleAsc(String title);

    Page<Book> findAll(Pageable pageable);

}
