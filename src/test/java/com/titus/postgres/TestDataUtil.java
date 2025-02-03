package com.titus.postgres;

import com.titus.postgres.domain.Author;
import com.titus.postgres.domain.Book;

public class TestDataUtil {
    private TestDataUtil() {

    }

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Abigael Rose")
                .age(80)
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .isbn("43FSW44DEF")
                .title("Just a book")
                .authorId(1L)
                .build();
    }
}
