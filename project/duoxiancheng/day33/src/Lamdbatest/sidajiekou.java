package Lamdbatest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class sidajiekou {

    /**
     * java内置四大核心函数式接口
     * consumer<T>:消费性接口
     * supplier<T>:供给型接口
     * Function<T,R>:函数式接口
     * Predicate<T>：断定型接口
     *
     *
     *
     */


    @Test
    public void t1()
    {

        //正常写法
        happyTime(33, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("今天去买瓶"+aDouble+"元的水");
            }
        });
//lambda写法
        happyTime(88,aDouble -> System.out.println("今天去买瓶"+aDouble+"元的水"));



    }

    public void happyTime(double a, Consumer<Double> b)
    {

        b.accept(a);

    }


    //根据给定的规则，过滤集合中的字符串，

    public void  guolv(List<String>  list, Predicate<String> bb)
    {
        ArrayList<String>  ll=new ArrayList<>();

        for(String v:list)
        {
            if(bb.test(v))
            {
                ll.add(v);
            }
        }
        System.out.println(ll.toString());


    }

    @Test
    public void guo()
    {
        List tt= Arrays.asList("南京","背景","北京","东京","普京");

        guolv(tt, new Predicate<String>() {
            @Override
            public boolean test(String strings) {
              return   strings.contains("京");

            }
        });

        //使用lambda
        guolv(tt,strings->strings.contains("京"));






    }


}
