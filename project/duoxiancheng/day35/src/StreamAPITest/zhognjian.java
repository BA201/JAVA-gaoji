package StreamAPITest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class zhognjian {


    @Test
    public void zz()
    {

        //filter(predicate p):接收lambda从中排除某些元素。

        List<person> lis= person.getpersons();
        Stream<person> rr = lis.stream();
        //查询集合中年龄大于30岁的。
        rr.filter(t -> t.getAge()>30 ).forEach(System.out::println);
        System.out.println("****************");
        //limit():截断流，使其元素不超过指定数量
        lis.stream().limit(4).forEach(System.out::println);
        System.out.println("***********************");
        //skip():跳过元素，返回了一个扔掉前n个元素的流。
        lis.stream().skip(3).forEach(System.out::println);
        System.out.println("*****************");

        //distinct():筛选。通过流生成的hashcode()和equals()去除重复元素。所以需要重写这两个方法。
        lis.add(new person("张某人",666));
        lis.add(new person("张某人",666));
        lis.add(new person("张某人",666));
        lis.add(new person("张某人",666));
        lis.stream().distinct().forEach(System.out::println);



    }


    @Test
    public void maptest()
    {

        //map(Function f):映射
        //将集合中的每个元素都变成大写
        List<String>  ll= Arrays.asList("aa","bb","cc","dd");
        ll.stream().map(t -> t.toUpperCase() ).forEach(System.out::println);
        //练习：获取集合中名字长度大于2的名字。
        List<person> listt=person.getpersons();
        listt.stream().filter(t -> t.getName().length()>2 ).map(t -> t.getName()).forEach(System.out::println);



    }

    @Test
    public void flatmap()
    {
        //flatMap(Function f):接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        //写一个方法，将字符串转成一个Character类型的流
        List<String>  ll= Arrays.asList("aa","bb","cc","dd");
        Stream<Stream<Character>> shuang = ll.stream().map(t -> forStream1(t));//将字符串数组转换为char数组类型的Stream。相当于数组里面套数组。
        shuang.forEach( t -> { t.forEach( System.out::println );} );//此处是stream里套stream所以需要forEach()两次。list.add();

//        如果调用flatMap(Function f) 那就很简单了。
        Stream<Character> tr = ll.stream().flatMap(t -> zhognjian.forStream1(t));//list.Alladd();
        tr.forEach(System.out::println);







    }

    //将字符串中多个字符构成的集合转换为对应的Stream实例。目的是让Stream里套Stream。
    public static Stream<Character>  forStream1(String str)
    {
        List<Character> list= new ArrayList();
        for(char ss:str.toCharArray())
        {
            list.add(ss);
        }
       return list.stream();


    }

    //排序操作
    @Test
    public void paixv()
    {
        //自然排序
        List<Integer>  list= Arrays.asList(3,6,1,8,32,12,355,31);
        list.stream().sorted().forEach(System.out::println);
        System.out.println("******************");


        //定制排序
        list.stream().sorted((t,y)-> -Integer.compare(t,y) ).forEach(System.out::println);

        List<person> p=person.getpersons();

        p.stream().sorted((w,e)-> {  int a= w.getAge()-e.getAge();  if(a!=0){return a; }  return w.getName().compareTo(e.getName());  } ).forEach(System.out::println);



    }


    @Test
    public void pi()
    {
        //allMatch:检查是否所有员工年龄都大于13.
        List<person> list=person.getpersons();
        boolean tt = list.stream().allMatch(e -> e.getAge() > 13);
        System.out.println(tt);
        //anyMatch:检查是否至少匹配一个元素。
        boolean tt1 = list.stream().anyMatch(e -> e.getAge() > 40);
        System.out.println(tt1);
        //noMatch:检查是否没有匹配的元素
        //练习：是否有员工姓马；
        boolean m = list.stream().map(w -> w.getName()).noneMatch(t -> t.startsWith("马"));
        System.out.println(m);
        //findFirst:返回第一个元素。
        Optional<person> f1 = list.stream().findFirst();
        System.out.println(f1);
        //findAny-返回当前流中的任意元素： 知识点：stream是顺序流，要想随机需要用并行流parallelStream();
        Optional<person> f2 = list.parallelStream().findAny();
        System.out.println(f2);
        //count:返回流中的总个数。
        long r1 = list.stream().count();
        System.out.println(r1);
        //max();返回流中最大值
        //练习：找到年龄最大的
        Optional<Integer> r2 = list.stream().map(e -> e.getAge()).max(Integer::compare);
        System.out.println(r2);
        //min():返回流中最小值
        //练习：返回员工中年龄最小的员工。
        Optional<person> min = list.stream().min((t1, t2) -> Integer.compare(t1.getAge(), t2.getAge()));
        System.out.println(min);
        //forEach():内部迭代
        list.stream().forEach(System.out::println);


    }


    @Test
    public void tr()
    {
        //归约
        //reduce(T identity BinaryOperator b) 可以将流中元素反复结合起来，得到一个值 返回T
        //练习：计算10个自然数的和。
        List<Integer> list= Arrays.asList(12,34,12,55,33,13,12,45,32,56);
        Integer s = list.stream().reduce(0, Integer::sum);//0是初始值，是自动加上的。
        System.out.println(s);
        //reduce(BinaryOperator b):可以将流中元素反复结合起来返回一个值 返回Optional
        Optional<Integer> rr = list.stream().reduce( ( a1,a2) -> a1+a2  );
        Optional<Integer> rs = list.stream().reduce(  Integer::sum);
        System.out.println(rr);
        System.out.println(rs);


    }

    @Test
    public void shou()
    {
        //收集：collect(Collector c)将流转换为其他形式，接收一个Collector接口的实现，用于给Stream中的元素做汇总的方法。
        //练习1：查找员工年龄大于13的员工，结果返回一个list或者set
        List<person> list= person.getpersons();
        List<person> ls = list.stream().filter(e -> e.getAge() > 13).collect(Collectors.toList());
        ls.forEach(System.out::println);


    }






}
