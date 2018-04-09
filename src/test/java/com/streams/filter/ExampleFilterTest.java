package com.streams.filter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleFilterTest {

    private ExampleFilter exampleFilter;

    @Before
    public void setup() {
        exampleFilter = new ExampleFilter();
    }

    @Test
    public void return_list_of_people_over_20_years_old() {
        assertEquals(2, exampleFilter.peopleOver20().size());
    }
}
