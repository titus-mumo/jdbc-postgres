package com.titus.postgres.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.titus.postgres.TestDataUtil;
import com.titus.postgres.domain.Author;
import com.titus.postgres.domain.Book;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookDaoImplIntegrationTests {

    @Autowired
    private BookDaoImpl underTest;

    @Autowired
    private AuthorDaoImpl authorDao;

    @Autowired
    public BookDaoImplIntegrationTests(BookDaoImpl underTest) {
        this.underTest = underTest;
    };

    @Test
    public void testThaFindOneBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        authorDao.create(author);
        Book book = TestDataUtil.createTestBookA();
        book.setAuthorId(author.getId());
        underTest.create(book);
        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatFindMultipleBooksCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        authorDao.create(author);

        Book book1 = TestDataUtil.createTestBookA();
        book1.setAuthorId(author.getId());
        underTest.create(book1);

        Book book2 = TestDataUtil.createTestBookB();
        book2.setAuthorId(author.getId());
        underTest.create(book2);

        Book book3 = TestDataUtil.createTestBookC();
        book3.setAuthorId(author.getId());
        underTest.create(book3);

        List<Book> result = underTest.find();
        assertThat(result)
                .hasSize(3)
                .containsExactly(book1, book2, book3);

    }
}
