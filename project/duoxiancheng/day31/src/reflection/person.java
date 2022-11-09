package reflection;

@myannotation
public class person<T> extends Creature<String,Integer> implements Comparable<String>, myinterface {

    private String name;
    int age;
    public int id;

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                "} ";
    }

    public person() {
    }

    private person(String name) {
        this.name = name;
    }

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @myannotation
    private String show(String nation ,int age) throws NullPointerException,ClassCastException {
        System.out.println("我的国籍是" + nation);
        return nation;
    }

    private static  void flowerdance()
    {
        System.out.println("按时静态方法");
    }

    @Override
    public int compareTo(String o ) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");

    }
}
