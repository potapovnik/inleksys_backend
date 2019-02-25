package service.serviceImpl;


import DAO.ReaderDAO;
import entity.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ReaderService;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {
    private  ReaderDAO readerDAO;
    @Autowired
    public ReaderServiceImpl(ReaderDAO readerDAO) {
        this.readerDAO =readerDAO;
    }

    public Reader getById(Long id) {
        Reader reader=readerDAO.getById(id);
        return reader;
    }


    public List<Reader> getAll() {
        List<Reader> readerList=readerDAO.getAll();
        return readerList;
    }


    public int deleteById(Long id) {
        return readerDAO.DeleteById(id);
    }


    public int create(Reader reader) {
        return readerDAO.createReader(reader);
    }


    public int update(Reader reader) {
        return readerDAO.UpdateById(reader);
    }
}
