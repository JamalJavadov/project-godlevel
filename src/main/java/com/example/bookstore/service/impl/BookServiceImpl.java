package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.BookNotFoundException;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.BookService;
import com.example.bookstore.web.dto.BookRequest;
import com.example.bookstore.web.dto.BookResponse;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public BookResponse create(BookRequest request) {
        Book book = new Book(request.name(), request.author(), request.writedTime());
        Book saved = bookRepository.save(book);
        return toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponse getById(Long id) {
        Book book = findBook(id);
        return toResponse(book);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookResponse> getAll() {
        return bookRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public BookResponse update(Long id, BookRequest request) {
        Book book = findBook(id);
        book.setName(request.name());
        book.setAuthor(request.author());
        book.setWritedTime(request.writedTime());
        return toResponse(book);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Book book = findBook(id);
        bookRepository.delete(book);
    }

    private Book findBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    private BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getWritedTime()
        );
    }
}
