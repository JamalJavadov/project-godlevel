package com.example.bookstore.service;

import com.example.bookstore.web.dto.BookRequest;
import com.example.bookstore.web.dto.BookResponse;
import java.util.List;

public interface BookService {
    BookResponse create(BookRequest request);

    BookResponse getById(Long id);

    List<BookResponse> getAll();

    BookResponse update(Long id, BookRequest request);

    void delete(Long id);
}
