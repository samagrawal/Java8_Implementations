package com.code;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("David");
        names.add("Johnson");
        names.add("Samontika");
        names.add("Brijesh");
        names.add("John");
        //Normal Execution
        names.stream().filter(name -> name.length() > 5).skip(2).forEach(System.out::println);
        //Parallel Execution
        names.parallelStream().filter(name -> name.length() > 5).skip(2).forEach(System.out::println);

        Stream<String> testStream = names.stream();
        testStream.forEach(System.out::println);
        //testStream.forEach(System.out::println);
    }
}
