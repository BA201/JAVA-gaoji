package fanxing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class fanxign {
    @Test

    public void copyOne()
    {
        Dao<String>  dd=new Dao<>();

          userdao<String> u=new userdao();


          List<String>  l=new ArrayList<>();
          List<Integer> s=new ArrayList<>();
          List<?> t=new ArrayList<>();
        l.add("xiaoming");
        t=l;
        System.out.println(t.get(0));


    }



    public  <T>  List<T> xo(T arr)
    {
        return null;
    }
}



class Dao<T>//数据表中有不同的表，需要不同的类来承装，但是这些类型不一样，如果不用泛型类的话，有几种类型就得造几个类，如果用了泛型类，就可以只造一个类，
    //在实例化的时候给他们指定不同类型的值就行，但为了更好的区分对象之间的不同，往往都会再去造一个类直接继承这个主类，直接在继承的父类中指定多个类型即可。
    //不然都用这一个类早对象容易弄混。
{
//添加
     public T add(T A)
     {
         return A;
     }

     //修改
    public void  set(int a,T t)
    {
        System.out.println("修改");
    }

}

class  userdao<T> extends Dao<user>
{

}