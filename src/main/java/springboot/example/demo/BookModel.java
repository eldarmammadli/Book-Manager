package springboot.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookModel {

    private final List<Book> books = new ArrayList<>();

    public BookModel() {
        books.add(new Book(1, "Book1", 7));
        books.add(new Book(2, "Book2", 10));
        books.add(new Book(3, "Book3", 15));
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    public void create(Book book) {
        books.add(book);
    }

    public void edit(int id, Book b) {
        Book book = books.stream().filter(bk -> bk.getId() == id).findFirst().orElse(null);
        if(book != null) {
            book.setId(b.getId());
            book.setName(b.getName());
            book.setPrice(b.getPrice());
        }
    }

    public void delete(int id) {
        books.removeIf(student-> student.getId() == id);
    }
}
