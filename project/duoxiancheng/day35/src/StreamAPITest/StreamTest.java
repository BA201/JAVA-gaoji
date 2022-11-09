package StreamAPITest;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream API测试
 * Stream关注的是对数据的运算，与cpu打交道，
 * 集合关注的是数据的存储，与内存打交道。
 */

public class StreamTest {



    @Test
    public void streamt1()
    {
        //   创建Stream方式一：通过集合
//
// java8中的Collection接口被扩展，提供了两个获取流的方法。
        List<String> ll= Arrays.asList("小明","校长","牛逼");
        //  default Stream<E> stream(); //返回一个顺序流。
        Stream<String> t = ll.stream();
        //  defaule Stream<E> parallelStream();//返回一个并行流。
        ll.parallelStream();


    }

    @Test
    public void shuzu()
    {
//         java8中的Arrays的静态方法stream()可以获取数组流。
//         static <T>  Stream<T> stream(T [] array): 返回一个流。

        String a="牛逼";
        String b="666";
        String[]  str=new String[]{a,b};
        Stream<String> st = Arrays.stream(str);


    }

    @Test
    public void entry()
    {
//       创建Stream方式三：通过Stream的of();
//          什么都没有的方式
//       可以调用Stream类静态方法of(),通过显示值来创建一个流。他可以接收任意数量的参数。
//        public static <T>  Stream<T>  of(T…… values)；返回一个流。

     Stream<String>  stt=Stream.of("niubi","666");



    }

    @Test
    public void wuxian()
    {
//        ##### 创建Stream方式四：创建无限流
//



//   public static <T> Stream<T>  iterate(final T seed,final UnaryOperator<T> f )

        //遍历前十个偶数。
        Stream.iterate(0,t -> t+2).limit(10).forEach(System.out::println);

//   public static<T> Stream<T>  generate(Supplier<T> s );
        //生成十个随机数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);



    }





}
