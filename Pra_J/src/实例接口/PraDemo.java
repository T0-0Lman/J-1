package 实例接口;

//import java.util.Arrays;
//
//class Person implements Comparable<Person>{
//
//    public String name;
//    public int age;
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//
//    @Override
//    public int compareTo(Person o) {
////        if(this.age > o.age){
////            return 1;
////        } else if (this.age == o.age) {
////            return 0;
////        }else{
////            return -1;
////        }
////        return this.age - o.age;
//        return this.name.compareTo(o.name);
//    }
//}
//
//public class PraDemo {
//    //如果自己定义的类型进行比较一定要重写接口
//    //重写Comparable接口的compareTo方法
//    public static void main1(String[] args) {
//        Person person1 = new Person("one",14);
//        Person person2 = new Person("two",15);
//
//        int ret = person1.compareTo(person2);
//        System.out.println(ret);;
//    }
//
//    public static void main(String[] args) {
//        Person[] people = new Person[3];
//        people[0] = new Person("one",12);
//        people[1] = new Person("two",13);
//        people[2] = new Person("three",14);
//
//        AgeComparator ageComparator = new AgeComparator();
//        Arrays.sort(people,ageComparator);
//
//        //NameComparator nameComparator = new NameComparator();
//        //Arrays.sort(people,nameComparator);
//
//
//        //Arrays.sort(people);
//        System.out.println(Arrays.toString(people));
//    }
//}

//class Person{
//
//    public String name;
//    public int age;
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//
//
//}
//
//public class PraDemo {
//    public static void main(String[] args) {
//
//        Person person1  = new Person("git",13);
//        Person person2   = new Person("bit",13);
//
//
//        AgeComparator ageComparator = new AgeComparator();
//        int ret = ageComparator.compare(person1,person2);
//        System.out.println("按年龄比较");
//        System.out.println(ret);
//
//        System.out.println("==================");
//        System.out.println("按姓名比较");
//        NameComparator nameComparator = new NameComparator();
//        System.out.println(nameComparator.compare(person1,person2));
//
////        Arrays.sort(people);
////        System.out.println(Arrays.toString(people));
//    }
//}

class Person implements Cloneable{
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
        return super.clone();
    }
}

public class PraDemo {
    //如果自己定义的类型进行比较一定要重写接口
    //重写Comparable接口的compareTo方法
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person("one",14);
        Person person2 = (Person) person1.clone();
        System.out.println(person2);

    }
}