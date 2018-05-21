package com.jjozwik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

//        CHALLENGE #1
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for(String part: parts){
                    System.out.println(part);
                }
            }
        };


        Runnable runnable1 = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for(String part: parts){
                System.out.println(part);
            }
        };

        //    CHALLENGE #2
//
//        public static String everySecondChar(String source) {
//            StringBuilder returnVal = new StringBuilder();
//            for(int i = 0; i < source.length(); i++){
//                if(i%2 == 1){
//                    returnVal.append(source.charAt(i));
//                }
//            }
//            return returnVal.toString();
//        }
//
//        s -> {
//            StringBuilder returnVal = new StringBuilder();
//            for(int i = 0; i < s.length(); i++){
//                if(i%2 == 1){
//                    returnVal.append(s.charAt(i));
//                }
//            }
//            return returnVal.toString();
//        };


//        CHALLENGE #3

        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                if(i%2 == 1){
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(lambdaFunction.apply("1234567890"));

        System.out.println(everySecondCharacter(lambdaFunction, "1234567890"));


//        CHALLENGE #6

        Supplier<String> iLoveJava = () -> "I love Java!";
//        Supplier<String> iLoveJava = () -> {return "I love Java!";};


//        CHALLENGE #7
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);


//        CHALLENGE #9

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );


        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(name ->
                firstUpperCaseList.add(name.substring(0,1).toUpperCase()+name.substring(1)));
        firstUpperCaseList.sort(String::compareTo);
//        firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
        firstUpperCaseList.forEach(System.out::println);
//        firstUpperCaseList.forEach(s -> System.out.println(s));

//        CHALLENGE #10

        System.out.println("_____________________");
        List<String> secondUpperCaseLsit = topNames2015
                .stream()
                .map((s -> s.substring(0,1).toUpperCase()+s.substring(1)))
                .sorted()
                .collect(Collectors.toList());

        secondUpperCaseLsit.forEach(System.out::println);


    }

    public static String everySecondCharacter(Function<String, String> function, String str) {
        return function.apply(str);
    }

}
