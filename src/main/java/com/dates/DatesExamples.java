package com.dates;

import java.time.LocalDate;

public class DatesExamples {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getEra());

        System.out.println("===============");

        localDate = localDate.minusYears(2019);
        System.out.println(localDate);
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getEra());
    }

    private static int[] retrieveDates(){
        return new int[]{2015, 2, 5};
    }
}

