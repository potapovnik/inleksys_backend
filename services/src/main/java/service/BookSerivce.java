package service;

import entity.Book;

import javax.print.DocFlavor;
import java.util.List;

public interface BookSerivce {
    public Book getById(Long id);
    public List<Book> getAll();
    public List<Book> getAllWithName();
    public int deleteById(Long id);
    public int create(Book book);
    public int update(Book book);
}
