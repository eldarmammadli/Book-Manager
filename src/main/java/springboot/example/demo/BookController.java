package springboot.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    private BookModel bookModel;

    public BookController(BookModel bookModel) {
        this.bookModel = bookModel;
    }

    @GetMapping
    public List<Book> get() {
        return bookModel.getBooks();
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable int id) {
        return bookModel.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBooks(@RequestBody Book book) {
        bookModel.create(book);
    }

    @PutMapping("{id}")
    public void editBooks(@PathVariable int id, @RequestBody Book book) {
        bookModel.edit(id, book);
    }

    @DeleteMapping("{id}")
    public void deleteBooks(@PathVariable int id) {
        bookModel.delete(id);
    }
}
