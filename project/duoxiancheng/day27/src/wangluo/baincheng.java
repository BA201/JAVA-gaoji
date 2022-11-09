package wangluo;

import org.junit.Test;

import java.io.*;
import java.net.*;

public class baincheng {


    /**
     * 网络编程
     */

    @Test
    public void test() throws UnknownHostException {

        InetAddress r= InetAddress.getByName("www.baidu.com");
        System.out.println(r);
        System.out.println(InetAddress.getLocalHost());//获取本机ip地址。
        System.out.println(r.getHostAddress());//获取域名的ip
        System.out.println(r.getHostName());//获取域名名字。


    }




    //实现TCP的网络编程
    //例子1：客户端发送信息给服务端，服务端将信息显示在控制台上。

    @Test
    public void client() {
        Socket sk= null;
        OutputStream os= null;
        try {
            //创建一个Socket对象，指明服务器端的ip和端口号。
            InetAddress  ip=InetAddress.getByName("192.168.85.1");
            sk = new Socket(ip,8989);
            //造一个输出流。
            os = sk.getOutputStream();
            os.write("我是客户端牛逼".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭输出流
            try {
                if(os!=null)
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(sk!=null)
                sk.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }

    @Test
    public void server(){
        Socket sock= null;
        InputStream in= null;
        try {
            //创建一个ServerSocket对象，指明自己的端口号。
            ServerSocket ss=new ServerSocket(8989);
            //调用accept()表示接收来自客户端的Socket。
            sock = ss.accept();
            //造输入流。
            in = sock.getInputStream();
            byte[] cc=new byte[10];
            int len;
            //读取输入流中的数据。  // ByteArrayOutputStream 内部是数组调用write方法会将字节输出到此数组中。
            ByteArrayOutputStream os=new ByteArrayOutputStream();
            while((len=in.read(cc))!=-1)
            {

        os.write(cc,0,len);

            }
            System.out.println(os.toString());
            System.out.println(sock.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if(sock!=null)
                sock.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(in!=null)
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





    }

    //客户端发送一个消息，服务端接收后保存到本地。
    @Test
    public void client2()  {
        Socket so= null;
        OutputStream li= null;
        try {
            InetAddress ip1=InetAddress.getByName("192.168.85.1");

            so = new Socket(ip1,4567);
            li = so.getOutputStream();
            li.write("我是客户端，你接受信息后保存到本地。".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(so!=null)
                so.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(li!=null)
                li.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    @Test
    public void server2()  {

        Socket sk1= null;
        InputStream in1= null;
        FileOutputStream fi= null;
        try {
            ServerSocket so1=new ServerSocket(4567);
            sk1 = so1.accept();
            File wenjian=new File("bendi.txt");

            in1 = sk1.getInputStream();
            fi = new FileOutputStream(wenjian);

            byte[] bb=new byte[1024];
            int len;
            while((len=in1.read(bb))!=-1)
            {
                fi.write(bb,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fi!=null)
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(in1!=null)
                in1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(sk1!=null)
                sk1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





    }

    //练习三：有客户端发送信息给服务端，服务端接收到后保存到本地，并发送信息给客户端说收到了。
    @Test
    public void client3() throws IOException {
        InetAddress ip3=InetAddress.getByName("192.168.85.1");
        Socket sk3=new Socket(ip3,6899);
        OutputStream chu=sk3.getOutputStream();
        chu.write("我是客户端，给你发消息，你收到后给我回复一下。".getBytes());
        sk3.shutdownOutput();//服务端的read()方法是一个阻塞方法，如果不告诉他没有数据传输的话他是会一致循环的，所以要执行一下shutdownOutput方法，
        //来告诉他没有数据发送了。
        //接收来自服务器端的回复。
     InputStream ff= sk3.getInputStream();
        byte[] gh=new byte[1024];
        int len;
        while((len=ff.read(gh))!=-1)
        {
            System.out.print(new String(gh,0,len));
        }
        sk3.close();
        chu.close();
        ff.close();



    }

    @Test
    public void server3() throws IOException {
        ServerSocket s3=new ServerSocket(6899);
        Socket os3=s3.accept();
        FileOutputStream fi3=new FileOutputStream("shou.txt");
        InputStream in3=os3.getInputStream();
        byte[] b3=new byte[1024];
        int len;
        while((len=in3.read(b3))!=-1)
        {
            fi3.write(b3,0,len);

        }
        System.out.println("接收成功");
        //给客户端一个反馈
        OutputStream fa=os3.getOutputStream();
        fa.write("我收到了。".getBytes());

os3.close();
s3.close();
in3.close();
os3.close();
fa.close();

    }

    //UDP协议的网络编程

    @Test
    public void sender() throws IOException//发送者
    {

        DatagramSocket ds=new DatagramSocket();
        String str="我是发送端";
        byte[] data=str.getBytes();
        InetAddress ip=InetAddress.getLocalHost();
        DatagramPacket dp=new DatagramPacket(data,0,data.length,ip,3345);
        ds.send(dp);
        ds.close();


    }


    @Test
    public void receiver() throws IOException {


        DatagramSocket ds2=new DatagramSocket(3345);
        byte[] nn=new byte[1000];

        DatagramPacket dp2=new DatagramPacket(nn,0,nn.length);

        ds2.receive(dp2);
        System.out.println(new String(dp2.getData(),0,dp2.getLength()));

        ds2.close();

    }




}
