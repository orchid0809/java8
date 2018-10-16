package com.orchid0809.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by orchid0809 on 2018/10/14.
 */
public class Example {

    public static String put(){
        return "hello";
    }

    public static  void con(Integer size){
        System.out.println("size:"+size
        );
    }

    public static  String toUpperCase(String str){
        return str.toUpperCase();
    }

    public static Integer length(String str1,String str2){
        return str1.length() + str2.length();
    }

    public static void main(String[] args) {

        Supplier<String> s1 = () -> Example.put();
        System.out.println(s1.get());

        Supplier<String> s2 = Example::put;
        System.out.println(s2.get());


        Consumer<Integer> c1 = (size) -> Example.con(size);

        Consumer<Integer> c2 = Example::con;
        c2.accept(100);

        Function<String,String> f1 = (str) -> Example.toUpperCase(str);
        Function<String,String> f2 = Example::toUpperCase;
        System.out.println(f2.apply("lvcha"));

        BiFunction<String,String,Integer> b1 = (str1,str2) -> Example.length(str1,str2);
        BiFunction<String,String,Integer> b2 = Example::length;
        System.out.println(b2.apply("lvcha","hongcha"));


    }
}
