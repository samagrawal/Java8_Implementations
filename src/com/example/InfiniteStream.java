package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class InfiniteStream {
    public static void main(String[] args) {
        //System.out.println(Stream.iterate(100, e -> e+1)); // java.util.stream.ReferencePipeline$Head@6b71769e
        //Infinite Stream gives pipeline head

        //Start with 100, create a series

        //Another Example
        int k =21; int n =4;

        System.out.println(Stream.iterate(k,e -> e+1)//Unbounded And Lazy
                .filter(e -> e % 2==0) //Unbounded And Lazy
                .filter(e -> Math.sqrt(e)>20) //Unbounded And Lazy
                .mapToInt(e -> e*2) //Unbounded And Lazy
                .limit(n) //Sized And Lazy
                .sum()); 
    }
}
