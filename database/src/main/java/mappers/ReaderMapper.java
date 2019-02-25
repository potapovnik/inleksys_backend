package mappers;

import entity.Reader;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ReaderMapper implements RowMapper<Reader> {
    public Reader mapRow(ResultSet resultSet, int i) throws SQLException {
        Reader reader=new Reader();
        reader.setId(resultSet.getLong("id"));
        reader.setLogin(resultSet.getString("login"));
        reader.setPassword(resultSet.getString("password"));
        return reader;
    }
}
