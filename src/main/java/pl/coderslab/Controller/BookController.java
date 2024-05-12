package pl.coderslab.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Model.Book;
import pl.coderslab.Model.BookService;

import java.util.List;

@RestController // jak responsbody , bezpośredni zwraca tekst
@Controller
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseBody
    @GetMapping("/list")
    public List<Book> getList() {
        return bookService.getBooks();
    }

    @GetMapping("/getBook/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.get(id).get();
    }
    @PostMapping(value = "/addBook", produces = "application/json")
    public void addBook (@RequestBody Book book) {
        bookService.add(book);
    }
    @PutMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public void editBook (@RequestBody Book book) {
        bookService.update(book);
    }

    @DeleteMapping("/del/{id}")
    public void deleteBook (@PathVariable Long id) {
        bookService.delete(id);
    }





    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }
}

