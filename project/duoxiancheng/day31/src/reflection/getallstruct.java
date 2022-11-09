package reflection;

import java.io.Serializable;
import java.util.Comparator;

public class getallstruct {




}


class Creature<T,E> implements Serializable
{

    private char gender;
    public double weight;

    private void breath()
    {
        System.out.println("生物会呼吸");
    }


    public  void eat1()
    {
        System.out.println("生物要吃饭");
    }


}