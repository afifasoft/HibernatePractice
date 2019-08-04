package com.dubai.demonew.serviceImpl;

import com.dubai.demonew.domain.BookRepository;
import com.dubai.demonew.model.Book;
import com.dubai.demonew.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    BookRepository bookRepository;

    @Override
    public void findAllPaginated() {

        log.info("....findAllPaginated......");

        Pageable pageable = PageRequest.of(0, 10);
        Page<Book> books = bookRepository.findAll(pageable);


        log.info("findAllPaginated result elements: " + books.getNumber());
    }

}
