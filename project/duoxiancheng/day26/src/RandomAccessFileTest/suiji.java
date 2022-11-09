package RandomAccessFileTest;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class suiji {

    /**
     * RandomAccessFile的使用
     * 1：RandomAccessFile直接继承与java.lang.Object类,实现了DataInput和DataOutput接口，
     * 2：RandomAccessFile既可以作为一个输入流，也可以作为一个输出流。
     * 3：如果RandomAccessFile作为一个输出流时，写出到的文件如果不存在，则在执行过程中自动创建
     * 如果写出到的文件存在，则会对原文件内容从头进行覆盖
     */


    @Test

    public void ts() {
        RandomAccessFile t = null;
        RandomAccessFile tt = null;

        try {
            //读文件
            File w = new File("zhang.jpg");
            t = new RandomAccessFile(w, "r");
            tt = new RandomAccessFile("wocao.jpg", "rw");

            byte[] yy1 = new byte[1024];
            int len;
            while ((len = t.read(yy1)) != -1) {
                tt.write(yy1, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (t != null)
                    t.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (tt != null)
                    tt.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    @Test
    public void tts() throws IOException {

        //文件覆盖
        RandomAccessFile gg = new RandomAccessFile("ji.txt", "rw");
        gg.seek(2);//将新添加的文件从指定的位置覆盖。需要写在write上面。
        gg.write("fldsajfla".getBytes());//默认从头覆盖。


        gg.close();


    }

    @Test
    public void ttt() throws IOException {

        //将覆盖改为插入。
        File le=new File("ji.txt");
        RandomAccessFile rt=new RandomAccessFile(le,"rw");
        rt.seek(2);//将指针调到角标为2的位置。
        //保存指针为2的位置后的所有数据到StringBuilder中。
        StringBuilder  str=new StringBuilder((int)new File("ji.txt").length());
        byte[]  cc=new byte[1024];
        int len;
        while((len=rt.read(cc))!=-1)
        {
            str.append(new String(cc),0,len);

        }
        rt.seek(2);
        rt.write("你比".getBytes());
        String tt1=String.valueOf(str);
        rt.write(tt1.getBytes());
        rt.close();



    }


}
