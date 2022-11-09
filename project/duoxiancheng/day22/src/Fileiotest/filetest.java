package Fileiotest;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.junit.Test;

import java.io.*;

public class filetest {


  /**
   * 创建一个hi.txt文件并写入程序，打印到控制台。
   */

  @Test

  public void fileiotest()  {
    FileReader fr= null;
    try {
      //第一步实例化File类的对象，指明要操作的文件。
      File t=new File("E:\\java\\jsp\\JSP软件\\apache-tomcat-9.0.40\\RUNNING.txt");
      //第二步：提供具体的流。
      fr = new FileReader(t);
      //第三步：数据的读入。
      //read();返回读入的一个字符，如果到达文件末尾返回-1。char型字符是以int型的数字存的，需要强转一下。
      int s= fr.read();
      while(s!=-1)
      {
        System.out.print((char) s);
       s= fr.read();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {

      try {
        if(fr!=null)//如果没有实例化fr，那么直接调用fr.close()方法是会报错的。
        fr.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }





  }


  @Test
  public void fileiotest2()  {

//实例化文件

    FileReader u= null;
    try {
      File r=new File("hi.txt");
      //造一个流    //将数据写入流
      u = new FileReader(r);

      char[]  g=new char[7];

      int len= u.read(g);
      while(len!=-1)
      {
        //正确写法
//        for(int i=0;i<len;i++)
//        {
//          System.out.print(g[i]);
//        }

        //改进：
        String  ii=new String(g,0,len);
        System.out.print(ii);
        len=u.read(g );

      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(u!=null) {
        try {
          u.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }





    //关闭流

  }



  @Test
  public void writertest() {

    /**
     * 将文件输出到文件硬盘中。
     */FileWriter ll= null;
    try {
      //实例化File对象。
      File y=new File("java.txt");
      //提供FileWriter用于数据的写出。
      ll = new FileWriter(y,true);

      //写入数据
      ll.write("我曹牛逼777\n");
      ll.write("真是太帅了");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {

      if(ll!=null)
      {
        //关闭数据流
        try {
          ll.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }





  }


  @Test
  public void fileiotest3() {
     //复制操作。
    FileReader v= null;
    FileWriter vv= null;
    try {
      //实例化File文件。
      File e=new File("java.txt");
      File ee=new File("fuzhi.txt");



      //提供输入流、输出流。
      v = new FileReader(e);
      vv = new FileWriter(ee);


      //将文件加载到流中。
      char[]  b=new char[7];
      int len;

      while( (len=v.read(b))!=-1)
      {
        vv.write(b,0,len);
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
    }


    //关闭流
    try {
      if(v!=null)
      v.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      if(vv!=null)
      vv.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Test
  public void tupiantest()  {
    FileInputStream h= null;
    FileOutputStream hh= null;
    try {
      File f=new File("zhang.jpg");
      File  ff=new File("zyh.jpg");

      h = new FileInputStream(f);
      hh = new FileOutputStream(ff);


      byte[] bbb=new byte[7];
      int len=h.read(bbb);
      while(len!=-1)
      {
        hh.write(bbb,0,len);
        len=h.read(bbb);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {


      try {
        if(h!=null)
        h.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if(hh!=null)
        hh.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }







  }



  public void shipinfuzhi(String path1,String path2)
  {
    FileInputStream h= null;
    FileOutputStream hh= null;
    try {
      File f=new File(path1);
      File  ff=new File(path2);

      h = new FileInputStream(f);
      hh = new FileOutputStream(ff);


      byte[] bbb=new byte[1024];
      int len=h.read(bbb);
      while(len!=-1)
      {
        hh.write(bbb,0,len);
        len=h.read(bbb);

      }
      System.out.println("上传成功");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {


      try {
        if(h!=null)
          h.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if(hh!=null)
          hh.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }


  @Test
  public void testfile()
  {

//    String a="E:\\桌面\\hua.mp4";
//    String b="E:\\java\\花.mp4";
    String a="java.txt";
    String b="wen.txt";
    shipinfuzhi(a,b);
  }


  @Test
  public void test7() {
    /**
     * 实现非文本的复制，使用缓冲流。
     */

    //造文件
    BufferedInputStream file3= null;
    BufferedOutputStream file4= null;
    try {
      File hv=new File("E:\\桌面\\星尘.mp4");
      File hb=new File("E:\\software\\王权.mp4");
      //造流
      FileInputStream file1=new FileInputStream(hv);
      FileOutputStream file2=new FileOutputStream(hb);

      file3 = new BufferedInputStream(file1);
      file4 = new BufferedOutputStream(file2);

      byte[] ttt=new byte[1024];
      int len;
      while((len=file3.read(ttt))!=-1)
      {
        file4.write(ttt,0,len);
      }
      System.out.println("复制成功");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //资源关闭：要求先关外层的流，再关内层的流。关闭外层流的同时，内层也会关闭，所以file1和file2就不用再手动的去关了。

      try {
        if(file3!=null)
        file3.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if(file4!=null)
        file4.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

    }




  }




}
