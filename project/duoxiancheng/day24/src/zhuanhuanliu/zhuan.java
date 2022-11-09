package zhuanhuanliu;

import org.junit.Test;

import java.io.*;

public class zhuan {


    /**
     * 使用转换流。
     */

    @Test
    public void zhuantest() throws IOException {

        File wen=new File("hi.txt");
        File jian=new File("jian.txt");

        FileInputStream in=new FileInputStream(wen);
        FileOutputStream ou=new FileOutputStream(jian);
        //创建转换流。

        InputStreamReader zhuan=new InputStreamReader(in,"utf-8");//设置字符编码集。
        OutputStreamWriter huan=new OutputStreamWriter(ou,"utf-8");

        char[] ch=new char[1024];
        int len;
        while((len=zhuan.read(ch))!=-1)
        {

//            for(int i=0;i<len;i++)
//            {
//                System.out.print(ch[i]);
//            }
           huan.write(ch,0,len);

        }


        zhuan.close();
        huan.close();


    }



}
