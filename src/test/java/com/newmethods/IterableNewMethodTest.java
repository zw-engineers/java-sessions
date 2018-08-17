package com.newmethods;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class IterableNewMethodTest {

    private IterableNewMethod iterableNewMethod;

    @Before
    public void setUp() {
        iterableNewMethod = new IterableNewMethod();
    }

    @Test
    public void shouldReturnNamesInUpperCase() {
        List<String> expectedList = Arrays.asList("ARTEMAS", "THOMAS", "BOB");
        assertEquals(expectedList, iterableNewMethod.names());
    }
}