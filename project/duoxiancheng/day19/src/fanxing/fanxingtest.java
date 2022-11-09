package fanxing;

import org.junit.Test;

import java.util.*;

public class fanxingtest {


     @Test
    public void fanxingtest()
     {

          List<String> i=new ArrayList<String>();
          i.add("xiaoming");
          i.add("zahgn");
          for (String s:i)
          {
               System.out.println(s);

          }
         System.out.println("------------------");

          Map<String,Integer> m=new HashMap();
          m.put("zhang",32);
          m.put("li",33);
         Set<Map.Entry<String,Integer>>  t=m.entrySet();
        Iterator<Map.Entry<String,Integer>> y= t.iterator();
        while(y.hasNext())
        {
            System.out.println(y.next());
        }


     }



     @Test
    public void rtest()
     {
     user<String,Integer> us=new user<String,Integer>("小明",333,"wocao",33 );
     us.setAge(33);
     us.setWang("woxao");

     ne<String> n=new ne<>();
     n.setNam("wang");
     nee d=new nee();
     d.setWang("wang");


     }

}


class user <T1,T2>
{

    String name;

    public T2 getYyj() {
        return yyj;
    }

    public void setYyj(T2 yyj) {
        this.yyj = yyj;
    }

    T2 yyj;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public T1 getWang() {
        return wang;
    }

    public void setWang(T1 wang) {
        this.wang = wang;
    }

    int age;
    T1 wang;

    public user() {
    }

    public user(String name, int age, T1 wang ,T2 yyj) {
        this.name = name;
        this.age = age;
        this.wang = wang;
        this.yyj=yyj;
    }

    public  T1 in()
    {
        return null;
    }


}
class ne <T> extends  user//ne任然是泛型类
{
    T nam;

    public T getNam() {
        return nam;
    }

    public void setNam(T nam) {
        this.nam = nam;
    }
}

class nee  extends  user<String,Integer>//因为user是泛型类了，所以nee就不再是泛型类了。
{

}
