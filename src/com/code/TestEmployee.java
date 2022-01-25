package com.code;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestEmployee {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        writeQueries(employeeList);
    }

    private static void writeQueries(List<Employee> employeeList) {
        //Query 3.1 How many male and female employees are there in the organization?
        //Males Count
        //System.out.println(employeeList.stream().filter(employee -> employee.getGender().equals("Male")).count());
        //Total Count
        //System.out.println(employeeList.stream().map(Employee::getGender).count());
        //Expected Query would be
        Map<String, Long> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(collect);

        //3.2 Print the name of all departments in the organization?
        employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);

        //Query 3.3 : What is the average age of male and female employees?
        System.out.println(employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge))));

        //4. Get the details of highest paid employee in the organization?
        System.out.println(employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

        //Get the names of all employees who have joined after 2015?
        employeeList.stream().filter(employee -> employee.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);

        //Count the number of employees in each department?
        Map<String, Long> collect1 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(collect1);
        //What is the average salary of each department?
        Map<String, Double> collect2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect2);

        //Get the details of youngest male employee in the product development department?
        System.out.println(employeeList.stream()
                        .filter(employee -> employee.getGender().equals("Male") && employee.getDepartment().equals("Product Development"))
                        .min(Comparator.comparingInt(Employee::getAge)));
                         //.collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge))));
        //Who has the most working experience in the organization?
        Optional<Employee> collect3 = employeeList.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining)));
        System.out.println(collect3);

        System.out.println(employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)));
        System.out.println(employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst());

        //How many male and female employees are there in the sales and marketing team?
        Map<String, Long> sales_and_marketing = employeeList.stream()
                .filter(employee -> employee.getDepartment().equals("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(sales_and_marketing);

        //What is the average salary of male and female employees?
        Map<String, Double> collect4 = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect4);

        //List down the names of all employees in each department?
        //employeeList.stream().map(Employee::getName).collect(Collectors.groupingBy(Employee::getDepartment,Collectors.toList()));

        Map<String, List<Employee>> collect5 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(collect5);

        //What is the average salary and total salary of the whole organization?
        System.out.println(employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary)));

      //  System.out.println(employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));//.getSum()//.getAverage()//.getMax());
        //
        //Map<Boolean, List<Employee>> collect6 = employeeList.stream().collect(Collectors.partitioningBy(employee -> employee.getAge > 25));

        //Oldest Emplyee || Age || Deaprtment

        Optional<Employee> max = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
        System.out.println(max);
    }
}
