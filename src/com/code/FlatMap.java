package com.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FlatMap {
    public static void main(String[] args) {
        List<Institute> instituteList = new ArrayList<>();

        instituteList.add(new Institute("IIM", Arrays.asList("Bangalore", "Ahmedabad", "Kozhikode", "Lucknow")));
        instituteList.add(new Institute("IIT", Arrays.asList("Delhi", "Mumbai", "Kharagpur")));
        instituteList.add(new Institute("NIFT", Arrays.asList("Hyderabad", "Mumbai", "Patna", "Bangalore")));

        writeMapQueries(instituteList);
    }

    private static void writeMapQueries(List<Institute> instituteList) {
        //extract name of each Institute
        instituteList.stream()
                .map(Institute::getName)
                .collect(Collectors.toList()).forEach(System.out::println);

        //extract unique locations of all institutes
        instituteList.stream().
                flatMap(institute -> institute.getLocations().stream())
                .collect(Collectors.toSet()).forEach(System.out::println);
    }
}
