package mappers;

import entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book=new Book();
        book.setId(resultSet.getLong("id"));
        book.setAuthor(resultSet.getString("author"));
        book.setTitle(resultSet.getString("title"));
        book.setReader_id(resultSet.getLong("reader_id"));
        return book;

    }
}
