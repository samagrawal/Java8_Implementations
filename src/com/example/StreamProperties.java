package com.example;

import java.util.Arrays;
import java.util.List;

public class StreamProperties {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,2,3,4,3,4,5,1,2,3,4,5);
                /* numbers.stream()
                .filter(e -> e%2 ==0)
                .forEach(System.out::println);*/
                 //sized //ordered // Indistinct // non sorted

                numbers.stream()
                .filter(e -> e%2 ==0).distinct().sorted()
                .forEach(System.out::println);
                //sized //ordered // distinct // sorted
    }
}
