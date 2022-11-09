package zifuzhuanhuan;

import org.junit.Test;

import java.io.*;
import java.util.Locale;

public class zifuchuan {


    public static void main(String[] args) throws IOException {



        BufferedReader  zi=new BufferedReader(new InputStreamReader(System.in));//将字节流转换为字符流，并套一个缓冲流，因为缓冲流中
        //有readLine()方法，可以返回一行字符串。
        String date;
        while(true)
        {
            System.out.println("请输入数据");
            date=zi.readLine();
            if("e".equalsIgnoreCase(date)==true || "exit".equalsIgnoreCase(date))
            {
                System.out.println("程序结束");
                break;
            }
            else
            {
                System.out.println(date.toUpperCase());
            }

        }
        zi.close();






    }


    /**
     * 输出流重定向
     */
    @Test
    public void dayintest() {

        BufferedOutputStream yy= null;
        PrintStream ps= null;
        try {
            FileOutputStream fi=new FileOutputStream("hi.txt");
            yy = new BufferedOutputStream(fi);
            ps = null;
            ps=new PrintStream(yy,true);//创建打印输出流，设置为自动刷新模式（写入换行符或字节'\n'时都会刷新输出缓冲区。）
            if(ps!=null)//把标准输出流（控制台输出）改成文件输出。
            {
                System.setOut(ps);
            }


            for(int i=0;i<255;i++)
            {
                int  a=i;
                char v=(char) a;
                System.out.print(v);
                if(i%50==0)
                {
                    System.out.println();
                }
            }
            System.out.println("重定向成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ps!=null)
            ps.close();
            try {
                if(yy!=null)
                yy.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }


}
