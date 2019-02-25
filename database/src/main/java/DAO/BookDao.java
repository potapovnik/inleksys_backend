package DAO;


import entity.Book;
import entity.Reader;
import mappers.BookMapper;
import mappers.BookMapperWitnName;
import mappers.ReaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class BookDao {
    JdbcTemplate jdbcTemplate;
    private final String SQL_FIND_Book = "select * from book where id = ?";
    private final String SQL_FIND_ALL_BOOk = "select * from book";
    private final String SQL_INSERT_BOOK = "insert into book(id, author, title,reader_id) values(?,?,?,?)";
        private final String SQL_UPDATE_BOOK = "update book set id = ?,author=? ,title=? ,reader_id=? where id = ?";
    private final String SQL_DELETE_BOOK = "delete from book where id = ?";
    private final String SQL_FIND_BOOK_WITH_Login = "select b.id,b.author,b.title,b.reader_id,login\n" +
            "from reader join book b on reader.id = b.reader_id";
    private final String SQL_FIND_BOOK_WITH_Login_Null = "select * from book where reader_id isnull";
    @Autowired
    public BookDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Book getById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_Book, new Object[]{id}, new BookMapper());
    }

    public List<Book> getAll() {
        return jdbcTemplate.query(SQL_FIND_ALL_BOOk, new BookMapper());
    }

    public int createReader(Book book) {
        return jdbcTemplate.update(SQL_INSERT_BOOK, book.getId(), book.getAuthor(), book.getTitle(), book.getReader_id());
    }

    public int UpdateById(Book book) {
        return jdbcTemplate.update(SQL_UPDATE_BOOK, book.getId(), book.getAuthor(), book.getTitle(), book.getReader_id(),book.getId());
    }

    public int DeleteById(Long id) {
        return jdbcTemplate.update(SQL_DELETE_BOOK, id);

    }

    public List<Book> getAllWithName() {
        return jdbcTemplate.query(SQL_FIND_BOOK_WITH_Login, new BookMapperWitnName()    );
    }

    public List<Book> getAllWithNullName() {
        return jdbcTemplate.query(SQL_FIND_BOOK_WITH_Login_Null, new BookMapper());
    }

}
