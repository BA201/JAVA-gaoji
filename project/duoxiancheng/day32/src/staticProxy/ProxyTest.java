package staticProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的举例
 */
public class ProxyTest {
    public static void main(String[] args) {


        superMan su=new superMan();
        //代理类的对象
        Hum proxy11 = (Hum) ProxyFactory.getProxyInstance(su);
        //当通过代理类对象调用方法时，会自动调用被代理类中同名的方法。
        String fan = proxy11.getBelief();
        System.out.println(fan);
        proxy11.eat("屎");

        System.out.println("********************");
        bei vb=new bei();
        gongchagn tt = (gongchagn) ProxyFactory.getProxyInstance(vb);
        tt.zao();



    }


}

interface  Hum
{

    String getBelief();
    void eat(String food);

}

//被代理类
class superMan implements Hum

{

    @Override
    public String getBelief() {
        return "我是超人，我会飞";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃鸡屎炒饭"+food);

    }
}

/**
 * 要实现动态代理所要解决的问题
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
 * 问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法。
 */

//创建一个生产代理类的类
class ProxyFactory
{
    //调用此方法，返回一个代理类的对象，解决问题一。
    public static Object getProxyInstance(Object obj)//obj就是被代理类的对象
    {
        myInvocationHandler mm=new myInvocationHandler(obj);//给被代理类对象赋值。
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),mm);

    }

}

class myInvocationHandler implements InvocationHandler
{
    private Object obj;//需要使用被代理类的对象进行实例化。

    //给被代理类赋值
    myInvocationHandler(Object obj)
    {
        this.obj=obj;
    }

    //当我们通过代理类的方法调用方法a时，就会调用如下的方法。invoke();
    @Override
    //将被代理类要执行的方法a生命在invoke方法中。
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //Method();即为代理类对象调用的方法，此方法也就作为了被代理类要调用的方法。
        //obj：被代理类的对象。
      Object returnvalue=  method.invoke(obj,args);
      //上述方法的返回值就所为当前类invoke()方法的返回值。
      return  returnvalue;
    }
}