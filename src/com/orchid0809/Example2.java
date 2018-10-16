package com.orchid0809;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by orchid0809 on 2018/2/28.
 */
public class Example2 {

    public static void main(String[] args) {
        Function<Too,String> fun = (too) -> too.too();

        Function<Too,String> fun2 = Too::too;

        BiFunction<Too,String,Integer> fun3 = (too,str) -> too.too2(str);

        BiFunction<Too,String,Integer> fun4 = Too::too2;

       Supplier<Too> su  = () -> new Too();

       Supplier<Too> su2 = Too::new;


        System.out.println(fun4.apply(new Too(),"lvcha"));

        Supplier<Account> su3 = Account::new;

        Consumer<Integer> con = (age) -> new Account(age);

        Consumer<Integer>con2  = Account::new;
    }
}
class  Account{
    public Account(){

    }
    public Account(Integer age){

    }
}
class  Too{
    public String too(){
        return "lvcha";
    }

    public Integer too2(String str){
        return str.length();
    }
}
