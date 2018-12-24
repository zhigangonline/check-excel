package com.use.junit5;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.*;

@Slf4j
public class StandardTests {
    @BeforeAll
    public static void all() {
        log.info("----------- before all ----------");
    }

    @BeforeEach
    public void init() {
        log.info("----------- before each init ----------");
    }

    @Test
    public void successInit() {
        log.info("----------- success init ----------");
    }

    @Test
    public void failingTest() {
        log.info("----------- failing init ----------");
    }

    @Test
    @Disabled("for demonstion purposes")
    public void skitTest() {
        log.info("----------- skip the test ----------");
    }

    @AfterEach
    public void tearDown() {
        log.info("----------- tear down ----------");
    }

    @AfterAll
    public void tearDownAll() {
        log.info("----------- tear down all ----------");
    }
}
