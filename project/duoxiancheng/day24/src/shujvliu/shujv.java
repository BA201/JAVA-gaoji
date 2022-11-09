package shujvliu;

import com.sun.xml.internal.txw2.output.DataWriter;
import org.junit.Test;

import java.io.*;
import java.util.Date;

public class shujv {


    /**
     * 数据流的使用
     */



    @Test
    public void tstt() {
        DataOutputStream data= null;
        try {
            File tt=new File("shujvliu");
            FileOutputStream ff=new FileOutputStream(tt);
            data = new DataOutputStream(ff);
            data.writeDouble(44.8);
            data.flush();
            data.writeUTF("你是个大傻逼");
            data.flush();
            data.writeInt(3232323);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(data!=null)
                data.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void tess() {
        DataInputStream er= null;
        try {
            er = new DataInputStream(new FileInputStream("shujvliu"));
            Double f=er.readDouble();
            String ff=er.readUTF();
            int fff=er.readInt();
            System.out.println(f);
            System.out.println(ff);
            System.out.println(fff);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(er!=null)
                er.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }






}
