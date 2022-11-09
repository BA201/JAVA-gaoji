package rflection2;

import org.junit.Test;
import reflection.person;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Methodtest {


    /**
     * 获取运行时类的方法结构。
     */

     @Test
    public void m1()
     {


         Class c3= person.class;
//getMethods()获取当前运行是类及其父类中声明为public权限的方法。
         Method[] m2 = c3.getMethods();

         for(Method t:m2)
         {
             System.out.println(t);
         }

         System.out.println();

         //getDeclaredMethods()获取当前运行时类中所有方法（不包含父类中的方法）

         Method[] m4 = c3.getDeclaredMethods();
         for(Method t:m4)
         {
             System.out.println(t);

         }


     }
     @Test
    public void mm2() {
         /**
          * @Xxxx
          * 权限修饰符     返回值类型      方法名（参数类型1 形参名1 ,。。。。）throws Exception{}
          */


         Class c4 = person.class;
         Method[] z1 = c4.getDeclaredMethods();//这个好像也可以获取到父类中声明为public的方法。

         for (Method t : z1)
         {
             //获取方法声明的注解
             Annotation[] f = t.getAnnotations();
             for(Annotation d:f)
             {
                 System.out.println(d);
             }

             //获取方法权限修饰符
             System.out.print(Modifier.toString(t.getModifiers())+"\t");
             //获取返回值类型
             System.out.print("返回值"+t.getReturnType()+"\t");
             //获取方法名,
             System.out.print("方法名"+t.getName());


             System.out.print("(");
             //获取参数列表
             Class<?>[] ff = t.getParameterTypes();
             if(!(ff==null||ff.length==0))
             {
                for(int i=0;i<ff.length;i++)
                {
                    if(i==ff.length-1)
                    {
                        System.out.print(ff[i].getName()+"  args_"+i);
                        break;
                    }
                        System.out.print(ff[i].getName()+"  args_"+i+",");

                }
                 System.out.print(")");




             }  System.out.println(")");


             //获取抛出的异常
             Class<?>[] d = t.getExceptionTypes();
             if(d.length>0)
             {
                 System.out.print("throw");

                 for(int i=0;i<d.length;i++)
                 {
                     if(i==d.length)
                     {
                         System.out.println(d[i].getName());
                         break;
                     }
                     System.out.print(d[i].getName()+",");
                 }
             }
         }


     }

     @Test
    public void gg()
     {

         /**
          * 获取运行是类的构造器结构
          *
          */

         Class ccc=person.class;
         //获取运行是类中声明为public类型的构造器，这里获取不到父类的构造器，因为没什么用。
         Constructor[] e = ccc.getConstructors();
         for(Constructor d:e)
         {
             System.out.println(d);
         }
         //获取此运行是类中所有类型的构造器，这里获取不到父类的构造器，因为没什么用。
         Constructor[] ee = ccc.getDeclaredConstructors();
         for(Constructor d:ee)
         {
             System.out.println(d);
         }

     }

     @Test
    public void tg()
     {
         /**
          * 获取运行时类的带泛型的父类的泛型。
          *
          */

         Class x=person.class;
         Type x1 = x.getGenericSuperclass();
         ParameterizedType  xx=(ParameterizedType) x1;//获取带泛型的父类和其泛型
         System.out.println(xx);
         //获取泛型类型
         Type[] fan = xx.getActualTypeArguments();//只获取泛型类型
//         System.out.println(fan[0].getTypeName());
         System.out.println(((Class)fan[0]).getName());//只有类才能调用getName()方法，所以需要强转一下。

     }

     @Test
    public void bg()
     {
         /**
          * 获取运行时类的父类实现的接口
          */

         Class xc=person.class;
         Class[] xz = xc.getInterfaces();
         for(Class z:xz)
         {
             System.out.println(z);
         }
         Class cv = xc.getSuperclass();
         Class[] ee = cv.getInterfaces();
         for(Class t:ee)
         {
             System.out.println(t);
         }

     }

     @Test
    public void bao()
     {
         /**
          * 获取运行时类所在的包和注解
          */

         Class gg=person.class;
         Package hh = gg.getPackage();
         System.out.println(hh);
         Package fg = gg.getSuperclass().getPackage();
         System.out.println(fg);
         Annotation[] bb = gg.getAnnotations();
         for(Annotation tt:bb)
         {
             System.out.println(tt);
         }


     }

}
