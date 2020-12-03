package app.trsis.controller;

import app.trsis.model.Book;
import app.trsis.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "")
    public ResponseEntity<?> create(@RequestBody Book book) {
        bookService.create(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Book>> read() {
        final List<Book> books = bookService.readAll();

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> read(@PathVariable(name = "id") String id) {
        final Book book = bookService.read(id);

        return book != null
                ? new ResponseEntity<>(book, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") String id, @RequestBody Book book) {
        bookService.update(book, id);

        return new ResponseEntity<>(bookService.read(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String id) {
        bookService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
