package xvliehuafanxvliehua;

import org.junit.Test;

import java.io.*;

public class ObjectInputOutputStreamTest {


    /**
     * 对象序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去。
     */


    @Test
    public void test1()  {
        ObjectOutputStream o= null;

        try {
            //先将文件写出去
            o = new ObjectOutputStream(new FileOutputStream("xvlie.dat"));
            o.writeObject("宋红康学java第708天");
            o.flush();
            o.writeObject(new person("小明",18));
            o.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(o!=null) {
                try {
                    o.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }


    @Test
    public void test2()
    {

        /**
         * 反序列化
         */


        ObjectInputStream b= null;
        try {
            b = new ObjectInputStream(new FileInputStream("xvlie.dat"));

            Object f= b.readObject();
            Object ff=b.readObject();
            System.out.println(ff);


            System.out.println(f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        }

        try {
            if(b!=null)
                b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }





}


class person implements Serializable
{
  public  static final long serialVersionUID = 4223423423423423L;
    String name;
    int age;

    @Override
    public String toString() {
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

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public person() {
    }
}