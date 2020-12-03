package app.trsis.service;

import app.trsis.model.Book;

import java.util.List;

public interface BookService {
    void create(Book book);

    void update(Book book, String id);

    void delete(String id);

    List<Book> readAll();

    Book read(String id);
}
