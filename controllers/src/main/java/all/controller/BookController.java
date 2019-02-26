package all.controller;

import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.serviceImpl.BookServiceImpl;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    private final BookServiceImpl bookService;

    @Autowired
    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public Book getBook(@RequestParam("id") Long id) {
        Book book = bookService.getById(id);
        if (book == null) {
            throw new IllegalArgumentException();
        }
        return book;
    }

    @GetMapping(value = "all")
    public List<Book> getAllBook() {
        List<Book> bookList = bookService.getAll();
        if (bookList.size() == 0 || bookList == null) {
            throw new IllegalArgumentException();
        }
        return bookList;
    }

    @GetMapping(value = "allwithname")
    public List<Book> getAllBookWithName() {
        List<Book> bookList = bookService.getAllWithName();
        if (bookList.size() == 0 || bookList == null) {
            throw new IllegalArgumentException();
        }
        return bookList;
    }
    @PostMapping
    public void createBook(@Valid @RequestBody Book book){
        int createCount=bookService.create(book);
        if (createCount<=0){
            throw new IllegalArgumentException();
        }
    }
    @PutMapping("")
    public void updateBook(@Valid @RequestBody Book book){
        if (book.getReader_id()!=null)
            if (book.getReader_id()==0){
                book.setReader_id(null);
            }
        int bookCount=bookService.update(book);
        if (bookCount<=0){
            throw new IllegalArgumentException();
        }
    }
    @DeleteMapping()
    public void deleteBook(@RequestParam("id") Long id){
        int deleteCount=bookService.deleteById(id);
        if (deleteCount<=0){
            throw new IllegalArgumentException();
        }
    }

}
