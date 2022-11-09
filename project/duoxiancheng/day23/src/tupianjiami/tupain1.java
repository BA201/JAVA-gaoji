package tupianjiami;

import org.junit.Test;

import java.io.*;

public class tupain1 {
    /**
     * 图片加密。
     */


    @Test
    public void tutest(){
        BufferedInputStream tu= null;
        BufferedOutputStream pian= null;


        try {
            //创建File文件和流
            tu = new BufferedInputStream(new FileInputStream("E:\\加密.mp4"));
            pian = new BufferedOutputStream(new FileOutputStream("E:\\桌面\\解密.mp4"));


            byte[] it=new byte[1024];
            int len;
            while((len=tu.read(it))!=-1)
            {
                for(int i=0;i<len;i++)
                {
                     it[i]= (byte) (it[i]^5);
                }
                pian.write(it,0,len);

            }
            System.out.println("加密成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if(tu!=null)
                tu.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(pian!=null)
                pian.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





    }




}
