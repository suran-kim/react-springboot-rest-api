package com.example.gccoffee.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    @DisplayName("올바르지 않은 이메일 형식 입력")
    public void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            var email = new Email("accccc");
        });
    }

    @Test
    @DisplayName("올바른 이메일 형식 입력")
    public void testValidEmail() {
        var email = new Email("hello@gmail.com");
        assertEquals("hello@gmail.com", email.getAddress());
    }

    @Test
    @DisplayName("Equal검증")
    public void testEqEmail() {
        var email = new Email("hello@gmail.com");
        var email2 = new Email("hello@gmail.com");
        assertEquals(email, email2);
    }
}