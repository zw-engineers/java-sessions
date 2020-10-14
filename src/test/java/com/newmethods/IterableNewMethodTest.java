package com.newmethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IterableNewMethodTest {

    private IterableNewMethod iterableNewMethod;

    @BeforeEach
    public void setUp() {
        iterableNewMethod = new IterableNewMethod();
    }

    @Test
    @DisplayName("Should return names in upper case")
    public void shouldReturnNamesInUpperCase() {
        List<String> expectedList = Arrays.asList("ARTEMAS", "THOMAS", "BOB");
        assertEquals(expectedList, iterableNewMethod.names());
    }
}