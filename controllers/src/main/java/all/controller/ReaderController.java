package all.controller;

import config.DetailService;
import entity.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.serviceImpl.ReaderServiceImpl;

import java.util.List;

@RestController
@RequestMapping("reader")
public class ReaderController {
    private ReaderServiceImpl readerService;
    private DetailService detailService;

    @Autowired
    public ReaderController(ReaderServiceImpl readerService,DetailService detailService) {
        this.readerService = readerService;
        this.detailService=detailService;
    }

    @GetMapping("")
    public Reader getReader(@RequestParam("id") Long id) {
        Reader reader = readerService.getById(id);
        if (reader==null){
            throw new IllegalArgumentException();
        }
        return reader;
    }
    @GetMapping("curUser")
    public Reader getCurrentReader() {
        Reader reader = null;
        try {
            reader = detailService.getCurrentUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reader;
    }
    @GetMapping("/all")
    public List<Reader> getAllReader() {
         List<Reader> readerList = readerService.getAll();
         if (readerList.size()<=0||readerList==null){
             throw new IllegalArgumentException();
         }
        return readerList;
    }
    @PostMapping
    public void createReader(@RequestBody Reader reader){
        int createCount=readerService.create(reader);
        if (createCount!=1)throw new IllegalArgumentException();
    }
    @PutMapping
    public void updateReader(@RequestBody Reader reader){
      int updateCount=readerService.update(reader);
      if (updateCount<=0){
          throw new IllegalArgumentException();
      }
    }
    @DeleteMapping
    public void deleteReader(@RequestParam("id") Long id){
       int deleteCount=readerService.deleteById(id);
       if (deleteCount<=0){
           throw new IllegalArgumentException();
       }
    }

}
