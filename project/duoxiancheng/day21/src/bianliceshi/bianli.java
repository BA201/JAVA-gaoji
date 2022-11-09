package bianliceshi;

import org.junit.Test;
import java.io.File;

public class bianli {
    static long leng;
    public void bianlil(File[] b)
    {

        for(File g:b)
        {
         if (g.isDirectory())
         {
             File[] h = g.listFiles();
             bianlil(h);
         }
           else
         {
            leng+= g.length();
             String r = String.valueOf(g);
             if(r.endsWith(".jpg"))
             System.out.println(g.getAbsolutePath());

         }

        }

    }


@Test
public    void test2()
{

File file=new File("E:\\java" );

//    System.out.println(file.getParent());

//    System.out.println(file.getAbsolutePath());

    File[] tt = file.listFiles();

        bianli hh=new bianli();
        hh.bianlil(tt);
    System.out.println("总字节文件为"+leng);


}


}
