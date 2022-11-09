package Reflection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class fanshe {

    @Test
    public void ggg() throws IOException {
        //加载配置文件
        //方式一
        Properties pos=new Properties();
//        FileInputStream is=new FileInputStream("jdbc.properties");
//        pos.load(is);
//        String user=pos.getProperty("name");
//        System.out.println(user);
        //方式二
        ClassLoader xi = fanshe.class.getClassLoader();
        InputStream ii=xi.getResourceAsStream("jdbc.properties");//默认情况下是在src下的。
        pos.load(ii);
        String name=pos.getProperty("name");
        System.out.println(name);


    }

    @Test
    public  void gg()
    {
        /**
         * 类的加载器调用。
         */
        //对于自定义类使用系统加载器进行加载
        ClassLoader system = fanshe.class.getClassLoader();//获取系统类加载器。
        System.out.println(system);
        //调用系统类加载器的getParent()方法获取扩展类加载器。
        ClassLoader kuozhan = system.getParent();
        System.out.println(kuozhan);
        //调用扩展类加载器的getParent()方法，无法获取引导类加载器。
        //引导类加载器主要负责加载java核心类库，无法加载自定义类的。、
        ClassLoader yindao = kuozhan.getParent();
        System.out.println(yindao);//null

    }


    @Test
    public void ttt() throws ClassNotFoundException {
        //获取Class类的实例，前三种需要掌握。
        //方式一：调用运行时类的属性。

        Class  class1=fanshe.class;
        System.out.println(class1);

        //方式二：通过运行时类的对象，调用getClass();
        fanshe fan=new fanshe();
       Class class2= fan.getClass();
        System.out.println(class2);
        //方式三：调用Class的静态方法，forName(String class.Path);类的路径
        Class class3=Class.forName("Reflection.fanshe");
//        class3=Class.forName("java.lang.String");
        System.out.println(class3);
        //方式四：使用类的加载器ClassLoader
        ClassLoader class4 = fanshe.class.getClassLoader();
        Class class5 = class4.loadClass("java.lang.String");


        System.out.println(class5);

        Class<?> class6 = Class.forName("java.lang.Runnable");//运行时的接口也算是一个Class的实例。
        System.out.println(class6);


    }

@Test
    /**
     * 使用反射创建Person对象
     */
    public void test() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//通过反射创建Person对象。
    Class cls=Person.class;
    Constructor go = cls.getConstructor(String.class,int.class);
    Object shi = go.newInstance("小明", 33);
    Person sh=(Person) shi;
    System.out.println(shi.toString());
    sh.setAge(45);
    System.out.println(sh.toString());
    //通过反射调用对象指定的方法属性。
    //调用属性
    Field a = cls.getDeclaredField("age");
    a.set(shi,88);
    System.out.println(shi);
    //调用方法
    Method sho = cls.getDeclaredMethod("show");
      sho.invoke(shi);

      //通过反射是可以调用类的私有的构造器、私有的方法、私有的属性。
    Constructor siyou = cls.getDeclaredConstructor(String.class);
    siyou.setAccessible(true);
    Object ji = siyou.newInstance("jerry");
    Person jii=(Person) ji;
    System.out.println(ji.toString());
    //调用私有属性。
    Field nn = cls.getDeclaredField("name");
    nn.setAccessible(true);
    nn.set(shi,"傻狗");
    nn.set(jii,"牛逼");
    System.out.println(shi);
    System.out.println(jii);
    //调用私有方法。
    Method s1 = cls.getDeclaredMethod("show1",String.class);
    s1.setAccessible(true);
   String  sss= (String) s1.invoke(jii,"中国");//有返回值，返回值默认是Object类型的，
    // 若show1有返回值的话默认返回值是这个方法本身的返回值，没有的话默认为null。
    System.out.println(sss);


}









}
class Person
{

    public void show()
    {
        System.out.println("我是一个人");
    }
    private  String show1(String nn)
    {
        System.out.println("我是私有方法");
        return nn;
    }
    private String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
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