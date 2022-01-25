package com.example;

import java.util.Arrays;
import java.util.List;

public class StreamEfficiency {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        //find double of first even number greater than 3

        System.out.println(numbers.stream()//1 element | 2 Element and then 3rd
                .filter(e -> e>3)//Intermediate Function
                .filter(e -> e%2 ==0)//Intermediate Function
                .map(e -> e*2)//Intermediate Function
                .findFirst());//Termination Operation + Triggers Computation so its single use pipeline execution
        // Result is Optional[8]
        //Question is what about Performance
        //Streams are Lazy means efficient
    }
}
