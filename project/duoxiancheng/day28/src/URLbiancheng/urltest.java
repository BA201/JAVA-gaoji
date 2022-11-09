package URLbiancheng;

import org.junit.Test;


import javax.net.ssl.HttpsURLConnection;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.URL;




public class urltest {
    public static void main(String[] args) {

        HttpsURLConnection rr = null;
        InputStream dd= null;
        FileOutputStream wen= null;
        try {
            URL  r=new URL("https://www.bilibili.com/video/BV1Kb411W75N");


//        System.out.println(r.getAuthority());
//        System.out.println(r.getPort());//获取url的端口号
//        System.out.println(r.getProtocol());//获取协议
//        System.out.println(r.getHost());
//        System.out.println(r.getPath());
//        System.out.println(r.getQuery());

            rr = (HttpsURLConnection) r.openConnection();
            rr.connect();
            dd = rr.getInputStream();
            wen = new FileOutputStream("day28//BV1Kb411W75N.mp4");
            byte[] bb=new byte[1024];
            int len;
            while((len=dd.read(bb))!=-1)
            {

                wen.write(bb,0,len);
            }
            System.out.println("下载成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(dd!=null)
                    dd.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(wen!=null)
                    wen.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(rr!=null)
                rr.disconnect();
        }


    }

    @Test
    public void urltt() {





    }


}
