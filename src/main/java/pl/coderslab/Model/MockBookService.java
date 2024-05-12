package pl.coderslab.Model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MockBookService implements BookService {
    private List<Book> list;
    private static Long nextId = 4L;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }


    @Override
    public List<Book> getBooks() {
        return getList();
    }

    @Override
    public Optional<Book> get(Long id) {
        Optional<Book> book = Optional.ofNullable((getList().stream().filter(a -> a.getId() == id).findFirst().get()));
        return book;
    }

    @Override
    public void add(Book book) {
        book.setId(nextId);
        nextId ++;
        list.add(book);
    }

    @Override
    public void update(Book book) {
        for (int i=0;i<list.size();i++) {

            if (book.getId() == list.get(i).getId()) {
                list.set(i,book) ;
            }
        }


    }

    @Override
    public void delete(Long id) {
        for (int i=0;i<list.size();i++) {
            if (list.get(i).getId()==id) {
                list.remove(i);
            }
        }
    }
}
