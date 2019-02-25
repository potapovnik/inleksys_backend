package service;

import entity.Book;
import entity.Reader;

import java.util.List;

public interface ReaderService {
    public Reader getById(Long id);
    public List<Reader> getAll();
    public int deleteById(Long id);
    public int create(Reader reader);
    public int update(Reader reader);
}
