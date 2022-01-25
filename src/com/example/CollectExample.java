package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

        System.out.println(numbers.stream().
                filter(e -> e%2 ==0)
                .map( e-> e*2)
                .collect(Collectors.toSet()));

    }
}
