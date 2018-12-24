package com.use.junit5;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FirstJunit5Test {

    @Test
    public void myFirst() {
        Assertions.assertEquals(2,2+1);
    }
}
