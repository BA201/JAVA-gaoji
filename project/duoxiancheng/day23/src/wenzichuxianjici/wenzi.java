package wenzichuxianjici;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class wenzi {


    /**
     * 判断文本文件中各个字符出现的次数。
     */

    @Test
    public void rr(){

        FileReader rle= null;
        BufferedWriter llkan= null;
        try {
            Map<Character, Integer> m = new HashMap();
            File le = new File("E:\\微信垃圾\\代码.txt");
            File kan = new File("看.txt");
            rle = new FileReader(le);
//            BufferedReader rle=new BufferedReader(rlee);
            FileWriter lkan = new FileWriter(kan);
            llkan = new BufferedWriter(lkan);

            int v;
            while ((v = rle.read()) != -1) {
                char c = (char) v;
                if (m.get(c) == null) {
                    m.put(c, 1);
                } else {
                    m.put(c, m.get(c) + 1);
                }

            }
            Set<Map.Entry<Character, Integer>> ma = m.entrySet();

            for (Map.Entry<Character, Integer> d : ma) {
                switch (d.getKey()) {

                    case ' ':
                        llkan.write("空格="+d.getValue());
                        break;
                    case'\t':
                        llkan.write("Tab="+d.getValue());
                        break;
                    case'\r':
                        llkan.write("回车键="+d.getValue());
                        break;
                    case'\n':
                        llkan.write("换行符="+d.getValue());
                        break;
                    default:llkan.write(d.getKey()+"="+d.getValue());
                        break;



                }
                llkan.newLine();//换行
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rle!=null)
                rle.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(llkan!=null)
                llkan.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

   ;


    }


}
