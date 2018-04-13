package com.streams.reduction;

import java.util.Comparator;
import java.util.List;

public class ExampleReduction {
    public int getTotalSum(List<Integer> numbersList) {
//        return numbersList.stream()
//                .reduce(0, Integer::sum);
        return numbersList.stream()
                .reduce(0, (number, nextNumber) -> number + nextNumber );
    }

    public int getMaxValueWithIdentity(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::max);
    }
}
