package com.collections;

import java.util.Arrays;

public class TheArrayProblem {

    public static void main(String[] args) {
        Product door = new Product("Wooden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Window", 10);

        // Create
        Product[] products = {door, floorPanel};

        // Print
        /**
         * returns -> [Lcom.collections.Product;@6f94fa3e
         * which is not readable and not really helpful.
         */
        System.out.println(products); // returns -> [Lcom.collections.Product;@{SOME-HASH-CODE-HERE}

        /**
         * If we wanted to print an array we can use the
         * Arrays.toString() method to return a string
         * version of the Array.
         */
        System.out.println(Arrays.toString(products)); // returns => [Product{name='Wooden Door', weight=35}, Product{name='Floor Panel', weight=25}]

        // Add
        products = add(window, products);
        System.out.println(Arrays.toString(products));
    }


    /**
     * Returns a new Array given the new Product element
     * to be added to the array.
     * @param product - element to be added to the array.
     * @param array - the old Array to be modified to have the new element.
     * @return - a new Array given the new Product element
     */
    public static Product[] add(Product product, Product[] array) {
        int length = array.length;
        Product[] newArray = Arrays.copyOf(array, length + 1);
        newArray[length] = product;
        return newArray;
    }
}
