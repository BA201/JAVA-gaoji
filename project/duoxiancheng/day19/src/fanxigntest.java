import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ObjIntConsumer;

public class fanxigntest {


    @Test
    public void test1() {

        List<? extends A> l = null;
        List<? super A> s = null;
        List<A> b = new ArrayList<>();
        List<B> C = new ArrayList<>();
        List<Object> obj = new ArrayList<>();
        l = b;
        l = C;
        //编译不通过。obj不是A的子类。
//        l=obj;

        s = b;
        //编译不通过，C不是A的父类。
//        s=C;
        s = obj;
        Object oo = l.get(0);//可以接收
        A a = l.get(0);//可以接收
//        B v=l.get(0);//不可以接收。因为不知道l.get()到底是什么类型的，所以只能用最大的类型接收，如果l.get()是A类型的那用B接收就错了。
        Object o = s.get(0);//可以接收
//        B n=s.get(0);//不可以接收，因为子类不能接收父类，而s集合中存的最小的类就是A类，而B比A还小所以B不能接收s集合中的任何元素。
//        A m=s.get(0);//不能接收，因为A是s集合中最小的子类，其他的类都是他的父类，而子类是不能接收父类的，所以A不能接收。

//        l.add(new A());//添加失败，原因，因为A是最大的类了，而l集合可以存放的元素的区间是负无穷到A,所以不知道这个元素是不是A的父类，如果是
        //才可以添加成功，因为这是不确定的所以不能添加。
//        l.add(new B());//同理，B是A的子类，但是不知道B是不是这个元素是不是B的父类所以不能添加成功。
        s.add(new A());//可以添加成功。原因，s集合中可以存放的元素类型区间是，super 后面跟的类型到正无穷，所以A是此区间最小的类，在此集合中除了自己，
        //所有类都是他的父类，所以可以添加成功。
        s.add(new B());//可以添加成功，原因:同上，B是A的子类，比B还小，所以任何类都是他的父类，所以可以添加成功。


    }


}

class A {
    

}

class B extends A {

}
