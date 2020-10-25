package com.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TheArrayProblemTest {
    @Test
    @DisplayName("Should return a new array with a new element")
    void should_return_a_new_array_with_a_new_element() {
        Product door = new Product("Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Window", 10);

        Product[] products = {door, floorPanel};
        products = TheArrayProblem.add(window, products);
        assertThat(products.length).isEqualTo(3);
    }

}
