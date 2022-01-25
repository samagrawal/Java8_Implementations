package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class ParallelStreamExample {

    //Streams are abstract in nature meaning it does not contain data like list and set
    //Non Mutating Pipeline
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

                TimeIt.code(() ->
                //System.out.println(numbers.stream()
                System.out.println(numbers.parallelStream()
                .filter(e-> e%2 ==0)
                .mapToInt(ParallelStreamExample::Compute)
                .sum()));
    }
    private static int Compute(int number) {
        //assume this is time intensive
        try { Thread.sleep(1000); } catch(Exception ex) {}
        return number * 2;
    }
}
