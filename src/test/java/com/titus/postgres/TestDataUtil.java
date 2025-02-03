package com.titus.postgres;

import com.titus.postgres.domain.Author;
import com.titus.postgres.domain.Book;

public class TestDataUtil {
    private TestDataUtil() {

    }

    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("Abigael Rose")
                .age(80)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Titus Mumo")
                .age(70)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("Jimmy Mumo")
                .age(60)
                .build();
    }

    public static Author createTestAuthorD() {
        return Author.builder()
                .id(4L)
                .name("Jimmy k")
                .age(50)
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
