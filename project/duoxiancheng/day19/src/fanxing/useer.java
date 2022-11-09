package fanxing;

import java.util.Objects;

public class useer {


    String name;
    int age;
    int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        useer useer = (useer) o;
        return age == useer.age && id == useer.id && Objects.equals(name, useer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id);
    }

    @Override
    public String toString() {
        return "useer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public useer(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public useer() {
    }
}
