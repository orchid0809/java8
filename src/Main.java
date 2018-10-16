import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static String method(){

        return "lvcha";
    }

    public static void main(String[] args) {
        Runnable r = ()->{System.out.println("lvcha");};
        new Thread(r).start();

        Callable<String> call = ()->{return "lvcha";};

        Callable<String> call2 = ()->"hongcha";

        Function<Integer,Integer> fun = (Integer num) ->{
          int sum = 0;
          for(int i = 0 ;i <= num;i++){
                sum += i;
          }
          return sum;
        };

        System.out.println(fun.apply(10));

        BiFunction<String,String,Integer> bf = (String a,String b)->{
          return a.length() + b.length();
        };
        System.out.println(bf.apply("java","30000"));

        Supplier<String> su = ()->{return "lvcha";};

        Supplier<String> su2 = () -> {
          return Main.method();
        };

        Supplier<String> su3 = Main::method;

        Consumer<String> con = (str) -> {System.out.println("lvcha");};

        System.out.println(su3.get());
    }
}
