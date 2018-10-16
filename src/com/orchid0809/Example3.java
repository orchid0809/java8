package com.orchid0809;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by orchid0809 on 2018/3/1.
 */
public class Example3 {

    public static void main(String[] args){
        Stream<Integer> stream = Arrays.asList(1,2,4,5,11,12).stream();

        //stream.filter(num -> num % 2 == 0).forEach(System.out::println);

        int max = stream.max((o1,o2)->{return o1-o2;}).get();
        System.out.println("max="+max);

        Arrays.asList(1,2,2,3,4,4,5).stream().distinct().forEach(System.out::println);

       List<Integer> list =  Arrays.asList(1,2,1,3,2,5).stream().collect(Collectors.toList());
        System.out.println(list);

        List<Integer> list2 = Stream.iterate(1,x -> x +1).limit(50).sorted((a,b)-> {return b-a;}).skip(10).collect(Collectors.toList());
        System.out.println(list2);


        String queryString = "id=10&name=lvcha&pwd=12345&token=123456";
        Map<String,String> map = Stream.of(queryString.split("&")).map(str -> str.split("=")).collect(Collectors.toMap(s->s[0], s->s[1]));
        System.out.println(map);

    }
}
