package org.example.springbootintro.service;

import java.util.List;
import org.example.springbootintro.dto.BookDto;
import org.example.springbootintro.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    BookDto findById(Long id);

    List<BookDto> findAll();
}
