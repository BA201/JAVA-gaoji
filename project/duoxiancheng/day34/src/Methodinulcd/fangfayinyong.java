package Methodinulcd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *1:使用情景：当要传递给Lambda实体的操作已经有了实现的方法了也就是说传递给Lambda的方法是方法里面套方法，
 * 并且已经实现而且参数类型和返回值类型必须相同时才能用。
 * 比如
 *      public void tt(T t)
 *      {
 *          System.out.println(T t);   System.out.println就是一个方法，且和tt都没有返回值，形参列表也一样即可使用。
 *      }
 *
 */

public class fangfayinyong {




    @Test

    public void  t()
    {
        //使用Lambda形式
        Consumer<String> ss= s -> System.out.println(s);
        //因为Consumer接口中的抽象方法accept(String s)是有一个参数的，而println(Stirng s)使用了泛型所有形参类型都一样，且是一个参数，
        // 所以可以使用方法引用，如果是println("牛逼"+s);那就不行了，因为形参列表不一样了。
        ss.accept("666");
        System.out.println("****************");
        //使用方法引用

        Consumer<String> bb= System.out::println;
        bb.accept("太6了");
        System.out.println("***************");
        //含有return的

        Employee em=new Employee("小张",66);//getName()
        Supplier<String> su=() -> em.getName();
        System.out.println(su.get());
        //方法引用
        Supplier<String> vv=em::getName;
        System.out.println(vv.get());


    }


    @Test
    public void t2()
    {
        //情况二:静态方法 Comparator中 int compare(T a , T b)
        Comparator<Integer> cc=(x,y) -> Integer.compare(x,y);
        System.out.println(cc.compare(12, 77));

        Comparator<Integer> dd=Integer::compare;
        System.out.println(dd.compare(55, 23));

    }

    @Test
    public void t3()
    {
        //情况三 类::实例方法（有难度）
        //Comparator中的 int compare(T a T b)
        //String 中的 a.compareTo(b)

        Comparator<String> cd=(a,b)-> a.compareTo(b);
        System.out.println(cd.compare("ddd", "cnm"));
        //方法引用
        Comparator<String> cdd=String::compareTo;
        System.out.println(cdd.compare("ggg", "yyy"));


        //BiPredicate 中的 boolean test(T t1,T t2);
        //String中的 boolean t1.equals(t2);
        BiPredicate<String,String> bi=(t1,t2) -> t1.equals(t2);
        System.out.println(bi.test("王", "权"));
        //方法引用
        BiPredicate<String,String> dv= String ::equals;
        System.out.println(dv.test("权", "权"));

       // Function中的R  apply(T t);
        //Employee中的String  getName()
        Employee er=new Employee("张某",88);

        Function<Employee,String> ff= employee -> employee.getName();
        System.out.println(ff.apply(er));
        //方法引用
        Function<Employee,String> fe=Employee::getName;
        System.out.println(fe.apply(er));


        List a= Arrays.asList("dd","dds");
        a.forEach((t)-> System.out.println(t+"牛逼"));
        a.forEach(System.out::println);



    }

    @Test
    public void ConstructTest()
    {
//        构造器引用

        Employee ee=new Employee();

        Consumer<String> cs=(a) -> new Employee(a);
       cs.accept("牛逼777");
        System.out.println("**********");
        Consumer<String> cb=Employee::new;
        cb.accept("你更牛逼");


        Supplier<Employee> ss=() -> new Employee();
        ss.get();

        Supplier<Employee> se=Employee::new;
        se.get();

        Function<String,Employee> rr=(r) -> new Employee(r);
        rr.apply("我是Lambda");

        Function<String,Employee> fe=Employee::new;
        fe.apply("我是引用");


    }

    @Test
    public void shuzu()
    {
        //数组引用

        //Function中 R apply(T t);

        Function<Integer,String[]> str=len -> new String[len];
       String[] ss=str.apply(5);
        System.out.println(Arrays.toString(ss));

        Function<Integer,String[]>  srt=String[]::new;
       String[] bb= srt.apply(9);
        System.out.println(Arrays.toString(bb));


    }


}
