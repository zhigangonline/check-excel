package com.use.junit5;

import com.google.common.collect.Lists;
import com.use.vo.PersonVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.context.annotation.Lazy;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class AssertionsDemo {
    private PersonVo vo = null;
    private List<PersonVo> personVoList = Lists.newArrayList();

    @Test
    public void standardAssertions() {
        assertEquals(2,2);
        assertEquals(4,4, "The optional assertion message is now the last parameter.");
        assertTrue(2 ==  2 ,() ->  "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");
    }

    @Before
    public void init() {
        log.info("------------- before each --------------");
        vo = new PersonVo(1, "John", "Doe");
    }

    @Test
    @DisplayName("repeat 3 times just to do it ")
    @RepeatedTest(2)
    public void repeatedMultiplicationTest() {
        log.info("-- inside repeatMultiplication test --");
        assertEquals(30,5 * 6, " 6 * 5 will be 30");
    }

    @Test
    public void groupAssertiions() {
        // In a grouped assertion all assertions are executed, and any
        // failures will be reported together.
        assertAll("vo",
                ()-> assertEquals("John",this.vo.getFirstName()),
                ()-> assertEquals("Doe",this.vo.getLastName())
        );
    }

    @Test
    public void dependentAssertiions() {
        assertAll("perperties",
            () -> {
                String firstName = vo.getFirstName();
                assertNotNull(firstName);
                // Executed only if the previous assertion is valid.
                assertAll("first name",
                        ()-> assertTrue(firstName.startsWith("J")),
                        ()-> assertTrue(firstName.endsWith("n"))
                );
            },
            () -> {
                String lastName = vo.getLastName();
                assertNotNull(lastName);
                assertAll("last name",
                    () -> assertTrue(lastName.startsWith("D")),
                    () -> assertTrue(lastName.endsWith("e"))
                );
            }
        );
    }

    @Test
    public void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a message");
        });
        assertEquals("a message",exception.getMessage());
    }

    @Test
    public void timeoutNoExceute() {
        // The following assertion succeeds.
        assertTimeout(ofMinutes(1),()->{
            // Perform task that takes less than 2 minutes.
        });
    }

    @Test
    public void timeoutNotExecuteWithResult() {
        String actualResult = assertTimeout(ofMinutes(1),() -> {
            return "a result";
        });
        assertEquals("a result",actualResult);
    }

    @Test
    public void timeoutNotExecuteWithMethod(){
        // The following assertion invokes a method reference and returns an object.
        String actualGreeting = assertTimeout(ofMinutes(2), AssertionsDemo::greeting);
        assertEquals("hello world!",actualGreeting);
    }

    @Test
    public void timeoutExecute() {
        // The following assertion fails with an error message similar to:
        // execution exceeded timeout of 10 ms by 91 ms
        assertTimeout(ofMillis(10),()->{
            // Simulate task that takes more than 10 ms.
            Thread.sleep(100);
        });
    }

    public static String greeting() {
        return "hello world!";
    }

}
