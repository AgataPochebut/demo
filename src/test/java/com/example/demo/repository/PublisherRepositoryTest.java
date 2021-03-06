package com.example.demo.repository;

import com.example.demo.model.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * The type Publisher repository test.
 */
@DataJpaTest
@Sql(scripts = "/insert_publisher.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class PublisherRepositoryTest {

    @Autowired
    private PublisherRepository repository;

    /**
     * Find all.
     */
    @Test
    void findAll() {
        List<Publisher> list = repository.findAll();
        assertThat(list).isNotNull();
        assertThat(list).isNotEmpty();
    }

    /**
     * Find by id.
     */
    @Test
    void findById() {
        Publisher obj = repository.findById(1L).orElse(null);
        assertThat(obj).isNotNull();
    }

    /**
     * Save.
     *
     * @throws Exception the exception
     */
    @Test
    void save() throws Exception {
        Publisher obj = repository.findById(1L).orElse(null);
        repository.save(obj);

        Publisher obj1 = repository.findById(1L).orElse(null);
        assertThat(obj1).isNotNull();
    }

    /**
     * Delete by id.
     */
    @Test
    void deleteById() {
        repository.deleteById(1L);
        Publisher obj = repository.findById(1L).orElse(null);
        assertThat(obj).isNull();
    }

}