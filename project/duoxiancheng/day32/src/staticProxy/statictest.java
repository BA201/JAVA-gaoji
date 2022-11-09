package staticProxy;

/**
 * 静态代理举例：
 * 特点：代理类和被代理类在编译期间就被确定下来了
 */
public class statictest {

    public static void main(String[] args) {
        bei b=new bei();

        proxy1 p1=new proxy1(b);
        p1.zao();
    }







}

  interface  gongchagn  //代理类和被代理类所要实现的接口。
{


  void zao();//造衣服。



}


//代理类

class proxy1 implements gongchagn
{

    //定义一个接口类型的变量：用于被代理类的实例化，可以将被代理类看成这个接口传进代理类构造器的参数中。
    gongchagn bei;

    proxy1(gongchagn f)
    {
        this.bei=f;
    }

    @Override
    public void zao() {
        System.out.println("代理前的一些准备工作");

        bei.zao();//两个类都要实现统一接口的原因，需要调用接口中的方法。如果被代理类没有实现接口，那么就不能调用zao()方法。因为zao()方法是
        //接口中的方法，只有实现接口才能调用。

        System.out.println("代理后的收尾工作。");

    }


}

//被代理类

class bei implements gongchagn
{

    @Override
    public void zao() {
        System.out.println("我是代理类");
    }
}