package fanxing;

import org.junit.Test;

import java.util.*;

public class exer1 {


    @Test
    public void test()
    {
         DAOO<useer>  d=new DAOO<useer>();
        d.save("用户1",new useer("小明",23,1));
        d.save("用户2",new useer("小红",33,2));
        d.save("用户3",new useer("小张",244,3));
        d.save("用户4",new useer("小来",22,4));
        d.update("用户1",new useer("小李子",33,88  ));
        d.delete("用户3");
       List g= d.list();
//    for(Object n:g)
//    {
//        System.out.println(n);
//    }
        g.forEach(System.out::println);//java8新特性

    }


}



class DAOO<T>
{
    public DAOO(Map<String, T> m) {
        this.m = m;
    }

    public DAOO() {
        m=new HashMap<>();
    }

    Map<String,T> m;

    public void save(String id,T value)
    {
        m.put(id,value);

    }

    public T get(String id)
    {

        return  m.get(id);
    }

    public void update(String id,T value)
    {
      if(m.containsKey(id))
      {
          m.put(id,value);
      }
      else{
      throw new RuntimeException("没有找到该key");}


    }

    public void delete(String id)
    {

        m.remove(id);
    }
    //返回map中所有T对象。
    public List<T>  list()
    {
        Collection<T> value=m.values();
//        return  (List<T>) value;//错误写法，原因：m.values()返回的是Collection类型的，两边类型一样，不能直接父类转子类。、
        List<T> ll=new ArrayList<>();//正确写法。
        for(T a:value)
        {
            ll.add(a);
        }
        return ll;
    }

}