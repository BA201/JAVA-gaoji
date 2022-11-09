package StreamAPITest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class person {


    String name;
    int age;


    public  static  List<person> getpersons()
    {

        List list=new ArrayList<>();
        list.add(new person("小明啊",13));
        list.add(new person("小红",34));
        list.add(new person("小蓝",56));
        list.add(new person("小绿了",23));
        list.add(new person("小紫",45));
        list.add(new person("马化腾",12));
        list.add(new person("马强东",7));

        return list;



    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        person person = (person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public person() {
    }
}
