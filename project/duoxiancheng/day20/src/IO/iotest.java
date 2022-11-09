package IO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class iotest {
    int x;



    /**
     *
     * File的使用
     */


    @Test
    public void test1() throws FileNotFoundException {
    x--;
        System.out.println(x);
       int y=x++ + ++x;
        System.out.println(y);


        File file=new File("wo.txt");
    }


}
