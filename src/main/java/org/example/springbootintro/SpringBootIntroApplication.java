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

    private final BookService bookService;

    public SpringBootIntroApplication(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntroApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Book book = new Book();
            book.setTitle("The Fellowship of the Ring");
            book.setAuthor("John Ronald Reuel Tolkien");
            book.setIsbn("9780261103573");
            book.setPrice(BigDecimal.valueOf(470));
            book.setCoverImage("https://www.theonering.com/wp-content"
                    + "/uploads/2020/11/fellowship-of-the-ring-cover-art.jpg");
            book.setDescription("Set in Middle-earth, the story tells "
                    + "of the Dark Lord Sauron, who seeks the One Ring, "
                    + "which contains part of his might, to return to power. "
                    + "The Ring has found its way to the young hobbit "
                    + "Frodo Baggins. The fate of Middle-earth hangs in the "
                    + "balance as Frodo and eight companions (who form the "
                    + "Company of the Ring) begin their perilous journey to "
                    + "Mount Doom in the land of Mordor, the only place "
                    + "where the Ring can be destroyed.");

            bookService.save(book);
        };
    }
}
