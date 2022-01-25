package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExternalToInternal {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //External Iterator => You control of the same iterator : Not good practice
        // Calling collection on function
       for(Integer a : numbers){
           System.out.println(a);
       }

       //Internal Iterator => Calling function on collection
        // Polymorphism : Autopilot Mode
       /* numbers.forEach(new Consumer<Integer>() {
            public void accept(Integer value) {
                System.out.println(value);
            }
        }*/
       //numbers.forEach((Integer value) -> System.out.println(value));
        //Java has type inference only for lambada expressions
       // numbers.forEach(value -> System.out.println(value));
        // remove value also
        numbers.forEach(System.out::println);
        //Lambada should be extremely short => It would be hard to understand || And Test
    }
}
