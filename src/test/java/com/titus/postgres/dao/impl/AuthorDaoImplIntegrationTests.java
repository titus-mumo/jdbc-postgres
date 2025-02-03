package com.titus.postgres.dao.impl;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.titus.postgres.TestDataUtil;
import com.titus.postgres.domain.Author;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorDaoImplIntegrationTests {

    private AuthorDaoImpl underTest;

    @Autowired
    public AuthorDaoImplIntegrationTests(AuthorDaoImpl underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        underTest.create(author);
        Optional<Author> result = underTest.findOne(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
        Author author1 = TestDataUtil.createTestAuthorA();
        Author author2 = TestDataUtil.createTestAuthorB();
        Author author3 = TestDataUtil.createTestAuthorC();
        Author author4 = TestDataUtil.createTestAuthorD();
        underTest.create(author1);
        underTest.create(author2);
        underTest.create(author3);
        List<Author> result = underTest.find();
        assertThat(result).hasSize(3).containsExactly(author1, author2, author3);
        // The test below fails meaning that author4 was not created
        // assertThat(result).contains(author4);
    }

    @Test
    public void testThatFindGeneratesCorrectSql() {

    }
}
