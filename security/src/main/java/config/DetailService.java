package config;

import DAO.ReaderDAO;
import entity.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DetailService implements UserDetailsService {

    @Autowired
    ReaderDAO readerDAO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Reader user = readerDAO.getBylogin(username);
        if (user == null){
            throw new UsernameNotFoundException(username + " was not found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList()
        );
    }
    public Reader getCurrentUser()  throws Exception{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (null == auth) {
            throw new Exception("not found user");
        }

        Object obj = auth.getPrincipal();
        String  username = ((UserDetails) obj).getUsername();
        Reader reader = readerDAO.getBylogin(username);
        return reader;
    }
}