package all;

import DAO.BookDao;
import DAO.ReaderDAO;
import all.controller.ReaderController;
import config.DetailService;
import config.MyBasicAuthenticationEntryPoint;
import config.WebSecutiyConfiguration;
import configRepo.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import service.serviceImpl.BookServiceImpl;
import service.serviceImpl.ReaderServiceImpl;

@SpringBootApplication
@ComponentScan(basePackageClasses = {BookServiceImpl.class, BookDao.class, ReaderDAO.class, ReaderServiceImpl.class,
        ReaderController.class, AppConfig.class, DetailService.class, WebSecutiyConfiguration.class})
public class AppInit {
    public static void main(String[] args) {
        SpringApplication.run(AppInit.class,args);
    }
}