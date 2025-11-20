package springboot.example.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookModelTest {

    @Test
    void testGetBooks() {
        BookModel model = new BookModel();
        List<Book> books = model.getBooks();
        assertEquals(3, books.size());
    }

    @Test
    void testGetById() {
        BookModel model = new BookModel();
        Book book = model.getById(2);
        assertNotNull(book);
        assertEquals("Book2", book.getName());
    }

    @Test
    void testCreateEditDelete() {
        BookModel model = new BookModel();
        Book newBook = new Book(4, "Book4", 20);

        model.create(newBook);
        assertEquals(4, model.getBooks().size());

        newBook.setPrice(25);
        model.edit(4, newBook);
        assertEquals(25, model.getById(4).getPrice());

        model.delete(4);
        assertNull(model.getById(4));
    }
}
