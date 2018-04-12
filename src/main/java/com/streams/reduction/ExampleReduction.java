package com.streams.reduction;

import java.util.List;

public class ExampleReduction {
    public int getTotalSum(List<Integer> numbersList) {
//        return numbersList.stream()
//                .reduce(0, Integer::sum);
        return numbersList.stream()
                .reduce(0, (number, nextNumber) -> number + nextNumber );
    }
}
