package school21.spring.service.repositories;

import java.sql.SQLException;
import java.util.List;

public interface CrudRepository<T> {
    T findById(Long id);
    List<T> findAll();
    void save(T entity);
    void update(T entity);
    void delete(Long id);
}