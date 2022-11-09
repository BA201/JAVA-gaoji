package Lamdbatest;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式的使用。
 */

public class Lambde{



    @Test


    public void test()
    {
        Runnable  rr=new Runnable()
        {
            @Override
            public void run() {

                System.out.println("线程dd");

            }

        };

        rr.run();
        System.out.println("***********************");
        Runnable  r= () -> System.out.println("安适lambda");
        r.run();


    }


    @Test
    public void te()
    {


        Comparator<Integer> com=new Comparator<Integer>() {
            @Override
            public  int compare(Integer o1, Integer o2) {

              return   Integer.compare(o1,o2);

            }
        };
        System.out.println(com.compare(12, 33));

        System.out.println("****************");
        //Lambda函数
        Comparator<Integer> com1=(o1,o2) ->
        Integer.compare(o1,o2);


        System.out.println(com1.compare(55, 33));

        //方法引用
        Comparator<Integer> com2=Integer::compare;
        System.out.println(com2.compare(66, 88));


    }




}
