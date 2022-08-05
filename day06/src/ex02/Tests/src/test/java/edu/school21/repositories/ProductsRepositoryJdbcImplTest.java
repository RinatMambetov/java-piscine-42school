package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ProductsRepositoryJdbcImplTest {
    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(0, "product1", 1.1F),
            new Product(1, "product2", 2.2F),
            new Product(2, "product3", 3.3F),
            new Product(3, "product4", 4.4F),
            new Product(4, "product5", 5.5F),
            new Product(5, "product6", 6.6F),
            new Product(6, "product7", 7.7F)
    );
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(1, "product2", 2.2F);
    final Product EXPECTED_SAVED_PRODUCT = new Product(7, "newProduct", 100.0F);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(0, "updatedProduct", 10.0F);

    EmbeddedDatabase ds;
    ProductRepository repository;

    @BeforeEach
    void init() {
        ds = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        repository = new ProductRepositoryJdbcImpl(ds);
    }

    @Test
    void findAllCheck() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, repository.findAll());
    }

    @Test
    void findByIdCheck() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, repository.findById(1).get());
    }

    @Test
    void saveCheck() throws SQLException {
        repository.save(EXPECTED_SAVED_PRODUCT);
        Assertions.assertEquals(EXPECTED_SAVED_PRODUCT, repository.findById(7).get());
    }

    @Test
    void updateCheck() throws SQLException {
        repository.update(EXPECTED_UPDATED_PRODUCT);
        Assertions.assertEquals(EXPECTED_UPDATED_PRODUCT, repository.findById(EXPECTED_UPDATED_PRODUCT.getId()).get());
    }

    @Test
    void deleteCheck() throws SQLException {
        repository.delete(1);
        Assertions.assertThrowsExactly(RuntimeException.class, () -> repository.findById(1));
    }

    @AfterEach
    void close() {
        ds.shutdown();
    }
}
