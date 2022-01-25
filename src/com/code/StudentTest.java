package com.code;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentTest {
    public static void main(String[] args) {
        List<Student> listOfStudents = new ArrayList<Student>();
        listOfStudents.add(new Student(111, "John", 81.0, "Mathematics"));
        listOfStudents.add(new Student(222, "Harsha", 79.5, "History"));
        listOfStudents.add(new Student(333, "Ruth", 87.2, "Computers"));
        listOfStudents.add(new Student(444, "Aroma", 63.2, "Mathematics"));
        listOfStudents.add(new Student(555, "Zade", 83.5, "Computers"));
        listOfStudents.add(new Student(666, "Xing", 58.5, "Geography"));
        listOfStudents.add(new Student(777, "Richards", 72.6, "Banking"));
        listOfStudents.add(new Student(888, "Sunil", 86.7, "History"));
        listOfStudents.add(new Student(999, "Jordan", 58.6, "Finance"));
        listOfStudents.add(new Student(101010, "Chris", 89.8, "Computers"));

        System.out.println(listOfStudents.stream().filter(student -> student.getName().startsWith("S")).count());
        List<Student> mathematics = listOfStudents.stream()
                .filter(student -> student.getSpecialization().equals("Mathematics"))
                .collect(Collectors.toList());
                //.forEach(System.out::println);
       // System.out.println(mathematics);
        listOfStudents.stream().limit(4);
                //.forEach(System.out::println);
       listOfStudents.stream().skip(4);
               //.forEach(System.out::println);

      listOfStudents.stream()
              .map(student -> student.getPercentage());
              //.forEach(System.out::println);

      listOfStudents.stream()
              .sorted((s1, s2) -> s1.getName().length() - s2.getName().length());
             // .forEach(System.out::println);

      System.out.println(Arrays.stream(new int[] {7, 5, 9, 2, 8, 1}).reduce((a, b) -> a+b));

        System.out.println(listOfStudents.stream().findFirst());

        System.out.println(listOfStudents.stream()
                .anyMatch(student -> student.getSpecialization().equals("Geography")));

        Optional<String> anyElement = Stream.of("First", "Second", "Third", "Fourth").findAny();
        System.out.println(anyElement);

        //Peek is for Debug purpose
        listOfStudents.stream()
                .filter(student -> student.getName().length() >5)
                .peek(student -> System.out.println("Mapped Name: " + student.getName())).toArray();

        //Collecting top 3 performing students into List
       List<Student> studentList = listOfStudents.stream()
                .sorted(Comparator.comparingDouble(Student::getPercentage).reversed())
                .limit(3)
                .collect(Collectors.toList());
       System.out.println(studentList);
        // List unique subject names
       listOfStudents.stream()
               .map(Student::getSpecialization)
               .collect(Collectors.toSet()).forEach(System.out::println);

        Map<Integer, String> collectMap = listOfStudents.stream().collect(Collectors.toMap(Student::getId, Student::getName));
        System.out.println(collectMap);


        String collect = listOfStudents.stream().map(Student::getName).collect(Collectors.joining(","));
        System.out.println(collect);

        System.out.println(listOfStudents.stream().map(Student::getPercentage).collect(Collectors.maxBy(Comparator.naturalOrder())));

        //Grouping BY
        Map<String, List<Student>> collect1 = listOfStudents.stream().collect(Collectors.groupingBy(Student::getSpecialization));
        System.out.println(collect1);

        //PartitionBY
        Map<Boolean, List<Student>> collect2 = listOfStudents.stream().collect(Collectors.partitioningBy(student -> student.getPercentage() > 80));
        System.out.println(collect2);

        List<Student> collect3 = listOfStudents
                                .stream()
                                .limit(3)
                                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        System.out.println(collect3);
    }
}
