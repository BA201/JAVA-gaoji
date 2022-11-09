package rflection2;

import org.junit.Test;
import reflection.person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflectionTest {

    /**
     * 调用运行时类中的指定结构。属性、方法、构造器。
     */


    @Test
    public void reflectiontest() throws InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class cz= person.class;
        //创建运行时类的对象
        person d = (person) cz.newInstance();

        //获取指定的属性
        Field id1 = cz.getDeclaredField("id");
        //设置当前值的属性
        /*
        set();参数一：知名设置那个对象的属性，参数二：将此属性值设置为多少。
         */
        id1.set(d,43);
        System.out.println(d);


        System.out.println(id1.get(d));



        //获取运行时类中指定变量名的属性
        Field dd = cz.getDeclaredField("age");
        //私有的属性需要调用setAccessible(true)方法，保证当前属性是可以访问的。
        dd.setAccessible(true);
        dd.set(d,77);
        System.out.println(dd.get(d));

    }


    @Test
    public void hg() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Class czz=person.class;
        //创建运行时类的对象
        person d = (person) czz.newInstance();
        //获取指定的某个方法。getDeclaredMethod();参数一：知名获取的方法名称，参数二：指明获取的方法形参列表。
        Method m1 = czz.getDeclaredMethod("show", String.class, int.class);
        //私有的属性需要调用setAccessible(true)方法，保证当前属性是可以访问的。
        m1.setAccessible(true);
        //invoke();参数一：方法的调用者；参数二：给方法 形参赋值的实参。
        //invoke()方法的返回值，即为对应类中调用的方法的返回值。
        m1.invoke(d,"哈密瓜",99);





    }


    /**
     * 静态方法的调用；
     */
    @Test
    public void st() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Class cca=person.class;

        Method jing = cca.getDeclaredMethod("flowerdance");
        jing.setAccessible(true);
        //如果调用的运行时类中的方法没有返回值，则此invoke()返回null。
        jing.invoke(null);
    }


    /**
     * 调用运行时类中的构造器。
     */

    @Test
    public void dd() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class cv=person.class;
        //获取指定构造器
        Constructor g = cv.getDeclaredConstructor(String.class);
        //保证当前属性可以访问
        g.setAccessible(true);
        //实例化，并给构造器参数赋值。
        Object rr = g.newInstance("笑傲应");
        System.out.println(rr);

    }



}
