package com.example.bookstore.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record BookRequest(
        @NotBlank String name,
        @NotBlank String author,
        @NotNull LocalDate writedTime
) {
}
