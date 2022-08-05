package edu.school21.sockets.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Properties;

@Configuration
@ComponentScan("edu.school21.sockets")
public class SocketsApplicationConfig {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }

    @Bean
    public HikariDataSource getHikari() {
        HikariDataSource dataSource = new HikariDataSource();

        Properties properties = getProperties();

        dataSource.setJdbcUrl(properties.getProperty("db.url"));
        dataSource.setUsername(properties.getProperty("db.user"));
        dataSource.setPassword(properties.getProperty("db.password"));
        dataSource.setDriverClassName(properties.getProperty("db.driver.name"));

        return dataSource;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(SocketsApplicationConfig.class.getClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
