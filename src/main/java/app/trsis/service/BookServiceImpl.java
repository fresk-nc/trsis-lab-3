package app.trsis.service;

import app.trsis.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    private static final Map<String, Book> REPOSITORY = new HashMap<>();

    public void create(Book book) {
        REPOSITORY.put(book.getId(), book);
    }

    public List<Book> readAll() {
        return new ArrayList<>(REPOSITORY.values());
    }

    public Book read(String id) {
        return REPOSITORY.get(id);
    }

    public void update(Book book, String id) {
        REPOSITORY.put(id, book);
    }

    public void delete(String id) {
        REPOSITORY.remove(id);
    }
}


