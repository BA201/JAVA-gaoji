package rflection2;
import org.junit.Test;
import reflection.person;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Fieldtest {

    /**
     * 获取当前运行时类的属性结构。
     */
    @Test
    public void field1() throws NoSuchFieldException {
        Class c1= person.class;
        //获取属性结构
        //getFields(),获取当前运行时类及其父类中声明为public访问权限的属性。
        Field[] f1 = c1.getFields();
        for(Field t:f1)
        {
            System.out.println(t);
        }
        System.out.println();
        //getDeclaredFields()，获取当前运行是类中声明的所有属性，（不包含父类中声明的属性。）
        Field[] f2 = c1.getDeclaredFields();
        for(Field t:f2)
        {
            System.out.println(t);
        }




    }

    @Test
    public void field2()
    {

        //权限修饰符，数据类型，变量名
        Class c2=person.class;
        Field[] cc2 = c2.getDeclaredFields();
//权限修饰符
        for(Field t:cc2)
        {
            System.out.println(Modifier.toString(t.getModifiers()));
        }
//数据类型
        for(Field t:cc2)
        {
            System.out.println(t.getType().getName());
        }
        //变量名
        for(Field t:cc2)
        {
            System.out.println(t.getName());
        }





    }





}
