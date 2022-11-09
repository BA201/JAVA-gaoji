package iotest;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class iotest1 {

    @Test
    public void test4() throws IOException {
        File tt=new File("E:\\java");
        File yy=new File("hi1.txt");
        System.out.println(tt.isDirectory());
        System.out.println(yy.isFile());
        System.out.println(yy.exists());
        System.out.println(tt.canWrite());
        System.out.println(tt.canRead());
        System.out.println(tt.isHidden());

        File i=new File("uu.html");
        File ii=new File("iii");
        ii.mkdir();
        File  o=new File(ii,"hu");
        o.mkdirs();
        i.createNewFile();

//        i.delete();
    }


    @Test
    public void test1()
    {

        File  f=new File("hi.txt");
        File i=new File("E:\\software");

        System.out.println(f.getAbsoluteFile());
        System.out.println(f.getPath());
        System.out.println(f.getName());
        System.out.println(f.getParent());
        System.out.println(f.length());
        System.out.println(new Date(f.lastModified()));
        System.out.println("----------------");
        System.out.println(i.getAbsolutePath());
        System.out.println(i.getPath());
        System.out.println(i.getName());
        System.out.println(i.getParent());
        System.out.println(i.length());
        System.out.println(new Date(i.lastModified()));
        SimpleDateFormat ff=new SimpleDateFormat("yy-MM-dd-hh:mm:ss");
        System.out.println(ff.format(new Date(i.lastModified())));

      String[] g= i.list();
      for(String h:g)
      {
          System.out.println(h);
      }



    }



    @Test
    public void test2()
    {

        File t=new File("hi.txt");
        File file=new File("E:\\java\\wocao.txt");
        file.renameTo(t);

//        String[] ll = file.list();

//        for(String j:ll)
//        {
//            System.out.println(j);
//        }
//        File[] lll=file.listFiles();
//        for(File jj:lll)
//        {
//            System.out.println(jj);
//        }

//        System.out.println(t.renameTo(file));


    }






}
