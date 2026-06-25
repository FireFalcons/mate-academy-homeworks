package org.example.springbootintro.dto.mapper;

import org.example.springbootintro.config.MapperConfig;
import org.example.springbootintro.dto.BookDto;
import org.example.springbootintro.dto.CreateBookRequestDto;
import org.example.springbootintro.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    @Mapping(target = "id", ignore = true)
    Book toModel(CreateBookRequestDto requestDto);
}
