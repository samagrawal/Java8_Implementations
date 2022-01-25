package com.example;

import java.util.Arrays;
import java.util.List;

public class MethodReference {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //if you want to do something with parameter then this is not the right option
        //Instance Method call
        numbers.forEach(System.out::println);

        //Static Method reference
        //numbers.stream().map(String :: valueOf).forEach(System.out::println);
        // numbers.stream()
        //        .map(e -> String.valueOf(e))
        //        // .map(e -> e.toString())
        //        .map(String::toString)
        //        .forEach(System.out::println);
        //




    }
}
