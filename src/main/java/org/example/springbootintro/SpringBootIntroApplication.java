package org.example.springbootintro;

import java.math.BigDecimal;
import org.example.springbootintro.model.Book;
import org.example.springbootintro.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootIntroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntroApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BookService bookService) {
        return (String... args) -> {
            Book harryPotter = new Book();
            harryPotter.setTitle("Harry Potter and the Philosopher's Stone");
            harryPotter.setAuthor("J.K. Rowling");
            harryPotter.setIsbn("978-0-7475-3269-9");
            harryPotter.setPrice(BigDecimal.valueOf(500));
            harryPotter.setDescription("A beautiful fantasy novel about wizards.");
            harryPotter.setCoverImage("https://images.prom.ua/7337295011_harry-potter-and.jpg");
            
            bookService.save(harryPotter);
            
            System.out.println("All books from DB: " + bookService.findAll());
        };
    }
}
