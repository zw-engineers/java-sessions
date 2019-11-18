package com.stream.api.reduction;

import com.stream.api.optional.MyException;

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

    public int getMaxValue(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer::max).orElse(0);
    }

    public int getMaxValueWithException(List<Integer> numbers) throws MyException {
        return numbers.stream()
                .reduce(Integer::max)
                .orElseThrow( () -> new MyException("The value is empty or null"));
    }
}
