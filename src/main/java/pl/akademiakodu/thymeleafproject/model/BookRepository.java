package pl.akademiakodu.thymeleafproject.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BookRepository {

    List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }



    public void addBook(Book book) {
        books.add(book);
    }

    public Book findOne(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        throw new IllegalArgumentException("not found book");
    }

    public List<Book> findAll() {
        return books;
    }

    public Book save(Book book) {
        books.add(book);
        return book;
    }
}
