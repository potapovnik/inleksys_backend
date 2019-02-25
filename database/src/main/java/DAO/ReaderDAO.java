package DAO;

import entity.Reader;
import mappers.ReaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.print.DocFlavor;
import javax.sql.DataSource;
import javax.validation.constraints.Max;
import java.util.List;

@Component
public class ReaderDAO {
    JdbcTemplate jdbcTemplate;
    private final String SQL_FIND_READER_BY_ID = "select * from reader where id = ?";
    private final String SQL_FIND_READER_BY_LOGIN = "select * from reader where login = ?";
    private final String SQL_FIND_ALL_READER="select * from reader";
    private final String SQL_INSERT_READER = "insert into reader(login, password) values(?,?)";
    private final String SQL_UPDATE_READER = "update reader set login = ?, password  = ? where id = ?";
    private final String SQL_DELETE_READER = "delete from reader where id = ?";
    @Autowired
    public ReaderDAO(DataSource dataSource){
        jdbcTemplate=new JdbcTemplate(dataSource);
    }

    public Reader getById(Long id){
        return jdbcTemplate.queryForObject(SQL_FIND_READER_BY_ID,new Object[] {id},new ReaderMapper());
    }
    public Reader getBylogin(String login){
        return jdbcTemplate.queryForObject(SQL_FIND_READER_BY_LOGIN,new Object[] {login},new ReaderMapper());
    }
    public List<Reader> getAll(){
        return jdbcTemplate.query(SQL_FIND_ALL_READER,new ReaderMapper());
    }
    public int createReader(Reader reader){
        return jdbcTemplate.update(SQL_INSERT_READER,reader.getLogin(),reader.getPassword());
    }
    public int UpdateById(Reader reader){
        return jdbcTemplate.update(SQL_UPDATE_READER,reader.getLogin(),reader.getPassword(),reader.getId());
    }
    public int DeleteById(Long id){
        return jdbcTemplate.update(SQL_DELETE_READER,id);

    }


}
