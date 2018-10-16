package com.orchid0809.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;

/**
 * Created by orchid0809 on 2018/7/29.
 */
public class LambdaTest {

    public static void main(String[] args){
        Comparator<Apple> comparator = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        Comparator<Apple> comparator2 = (o1,o2)->{return o1.getColor().compareTo(o2.getColor());};

        List<Apple> apples = Collections.emptyList();

        apples.sort(comparator2);


        Runnable r1 = () -> {};
        Runnable r2 = () -> {
            System.out.println("lvcha");
        };
        Runnable r3 = () -> System.out.println("hhs");

        Callable<String> c1 = () -> "lvcha";
        Callable<Integer> c2 = () -> {return new Integer(10);};
        Callable<String> c3 = () -> {return "hh";};


        Function<Integer,String> f1 = a -> String.valueOf(a);
        Function<Integer,String> f2 = (Integer a) -> String.valueOf(a);
        Function<Integer,String> f3 = (Integer a) -> {return String.valueOf(a);};

        Function<Integer,Integer> f4 = a -> {
            int sum = 0 ;
            for(int i = 0 ;i < a;i++){
                sum += i;
            }
            return sum;
        };

        System.out.println(f3.apply(100));
        System.out.println(f4.apply(100));
    }
}
