package com.collections;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TheArrayProblemTest {

    private TheArrayProblem theArrayProblem;

    @Before
    public void init() {
        theArrayProblem = new TheArrayProblem();
    }

    @Test
    public void should_return_a_new_array_with_a_new_element() {
        Product door = new Product("Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Window", 10);

        Product[] products = {door, floorPanel};
        products = theArrayProblem.add(window, products);
        assertThat(products.length).isEqualTo(3);
    }

}
