package com.stream.api.flatmap;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class ExampleFlatMap {


    public int sumLists(List<List<Integer>> listOfLists) {

        // Our FlatMapper which is a Function to be passed as an argument in the flatMap()
        Function<List<Integer>, Stream<Integer>> flatMapper = l -> l.stream();

        /**
        return listOfLists.stream()  // Here we create our Stream.
                .flatMap(flatMapper) // Here we declare our flatMap() operation which takes in our Function we created.
                .reduce(0, (a, b) -> a + b); // We just use Reduction to add each element to the next.

        */

        /**
        ToIntFunction<Integer> a = Integer::new; // Here we create a ToIntFunction which takes an Integer into an int

        return listOfLists.stream()  // Here we create our Stream.
                .flatMapToInt(number -> number.stream() // Here we declare our flatMapToInt() operation.
                        .mapToInt(Integer::new) // Here we map our Integer values to int in order to sum them...
                )
                .sum(); // Here we just sum the int values and get our total as a result.

        */

        /**
        ToIntFunction<Integer> b = Integer::intValue; // Here we create a ToIntFunction which takes an Integer into an int.

        return listOfLists.stream() // Here we create our Stream.
                .flatMapToInt(list -> list.stream() // Here we declare our flatMapToInt().
                        .mapToInt(b)) // Here we pass out ToIntFunction.
                .sum(); // Here we just sum the int values and get our total as a result.
        */

        ToIntFunction<Integer> c = integer -> integer.intValue(); // Here we create a ToIntFunction which takes an Integer into an int

        return listOfLists.stream()  // Here we create our Stream.
                .flatMapToInt(list -> list.stream() // Here we declare our flatMapToInt().
                        .mapToInt(c))  // Here we pass out ToIntFunction.
                .sum(); // Here we just sum the int values and get our total as a result.
    }
}
