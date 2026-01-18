package com.example.bookstore.web.dto;

import java.time.LocalDate;

public record BookResponse(
        Long id,
        String name,
        String author,
        LocalDate writedTime
) {
}
