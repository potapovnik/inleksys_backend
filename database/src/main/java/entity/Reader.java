package entity;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Reader {


    private Long id;
    private String login;
    private String password;

    public Reader(Long id,String login,String password){
        this.id=id;
        setPassword(password);
        this.login=login;
        this.password=password;
    }
    public Reader(){}
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=PASSWORD_ENCODER.encode(password);
    }
}
