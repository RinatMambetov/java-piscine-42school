package edu.school21.sockets.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.sockets.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("jdbcTemplate")
public class UsersRepositoryImpl implements UsersRepository {
    public JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersRepositoryImpl(HikariDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM spring.users WHERE id = ?", (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2), rs.getString(3)) , new Object[]{id})
                .stream().findAny().orElse(null);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from spring.users", (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2), rs.getString(3)));
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update("insert into spring.users (username, password) values (?, ?)",
                entity.getUsername(), entity.getPassword());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE spring.users SET username = ? WHERE id=?", entity.getUsername(), entity.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM spring.users WHERE id=?", id);
    }

    @Override
    public Optional<User> findByUsername(String email) {
        User user = jdbcTemplate.query("SELECT * FROM spring.users WHERE username = ?", (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2), rs.getString(3)),  new Object[]{email})
                .stream().findAny().orElse(null);
        return Optional.of(user);
    }
}
