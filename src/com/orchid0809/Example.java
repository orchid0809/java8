package com.orchid0809;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by orchid0809 on 2018/2/28.
 */
public class Example {

    public String put(){
        return "lvcha";
    }

    public String toUppper(String str){
        return str.toLowerCase();
    }

    public static void main(String[] args) {
        Supplier<String> su = () -> {
            return "lvcha";
        };
        Supplier<String> su2 = () -> new Example().put();
        Example ex = new Example();
        Supplier<String> su3 = () -> ex.put();
        Supplier<String> su4 = ex::put;

        Function<String, Integer> fun = (String str) -> {
            return str.length();
        };
        Function<String,String> fun2 = (String str) -> {
            return new Example().toUppper(str);
        };
        //Function<String,String> fun3 = this::toUppper;
    }

    public void test(){
        Function<String,String> fun = this::toUppper;
    }
}
