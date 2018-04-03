package com.streams;

import java.util.stream.IntStream;

public class SumArrays {

  public static int arrayPlusArray(int[] arr1, int[] arr2) {
      // LESS PERFECT
//      int a = Arrays.stream(arr1).sum();
//      int b = Arrays.stream(arr2).sum();
//      return a + b;

      return IntStream.of(arr1).sum() + IntStream.of(arr2).sum();
  }

}