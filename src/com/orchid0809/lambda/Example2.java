package com.orchid0809.lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by orchid0809 on 2018/10/14.
 */
public class Example2 {

    public String put(){
        return "hello";
    }
    public static void main(String[] args) {
        Supplier<String> s1 = () -> new Example2().put();

        Supplier<String> s2  = new Example2()::put;
        System.out.println(s2.get());

        Consumer<String> c1 = str -> str.toLowerCase();


    }
}
