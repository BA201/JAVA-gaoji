package classInstance;

import org.junit.Test;

public class d1 {
    @Test
            public void t() throws InstantiationException, IllegalAccessException {


        //创建运行时类的对象

        Class c1=person1.class;
        Object s1 = c1.newInstance();

        /*
         newInstance()调用此方法，创建对应的运行时类的对象，内部调用了运行时类的空参的构造器。
         要想此方法创建类的运行时对象要求
         1:运行时类必须提供空参的构造器，
         2:空参的构造器访问权限锝够，通常设置为public
         在javaben中要求提供一个空参构造器，原因：
         1：便于通过反射创建运行时类的对象。
         2：便于子类继承此运行时类时，默认调用super(),保证父类有此构造器。
         */
        person1 s11 = (person1) s1;
        System.out.println(s11);

    }






}


 class person1
 {

   private   String name;
    public    int  age;


     public person1(String name, int age) {
         this.name = name;
         this.age = age;
     }

     public person1() {
     }

     @Override
     public String  toString() {
         return "person{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 '}';
     }

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
 }