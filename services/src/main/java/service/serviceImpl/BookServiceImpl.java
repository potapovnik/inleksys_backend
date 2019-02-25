package service.serviceImpl;

import DAO.BookDao;
import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BookSerivce;

import java.util.List;

@Service
public class BookServiceImpl implements BookSerivce {
    private BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public Book getById(Long id) {
        Book book = bookDao.getById(id);
        return book;
    }

    public List<Book> getAll() {
        List<Book> bookList = bookDao.getAll();
        return bookList;
    }

    public List<Book> getAllWithName() {
        List<Book> bookList = bookDao.getAllWithName();
        List<Book> bookListAdd=bookDao.getAllWithNullName();
        bookList.addAll(bookListAdd);
        return bookList;
    }


    public int deleteById(Long id) {
        return bookDao.DeleteById(id);
    }


    public int create(Book book) {
        return bookDao.createReader(book);
    }


    public int update(Book book) {
        return bookDao.UpdateById(book);
    }
}
