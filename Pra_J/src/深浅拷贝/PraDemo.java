package 深浅拷贝;

class  Money implements Cloneable{
    public int money = 9;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public  Money m = new Money();

    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();
        Person person = (Person) super.clone();
        person.m = (Money) this.m.clone();
        return person;
    }
}

public class PraDemo {
    //如果自己定义的类型进行比较一定要重写接口
    //重写Comparable接口的compareTo方法
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person("one",14);
        Person person2 = (Person) person1.clone();

        //System.out.println(person2);

        System.out.println("修改前");
        System.out.println(person1.m.money);
        System.out.println(person1.m.money);

        System.out.println("===============");

        System.out.println("修改后");
        person2.m.money = 999;
        System.out.println(person1.m.money);
        System.out.println(person2.m.money);
    }
}