package 接口;

interface Flying{
    void fly();
}

interface Running {
    void run();
}

interface Swimming{
    void swim();
}

class Animal{
    public String name;

    public Animal(String name){
        this.name = name;
    }
}
//先继承一个类在来实现实现一个或多个接口
class Cat extends Animal implements Running{
    public Cat(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name + "在跑");
    }
}

class Bird extends Animal implements Running,Flying{
    public Bird(String name){
        super(name);
    }


    @Override
    public void fly() {
        System.out.println(this.name + "在飞");
    }

    @Override
    public void run() {
        System.out.println(this.name + "在跑");
    }
}

class Duck extends Animal implements Running,Flying,Swimming{
    public Duck(String name){
        super(name);
    }


    @Override
    public void fly() {
        System.out.println(this.name + "在飞");
    }

    @Override
    public void run() {
        System.out.println(this.name + "在跑");
    }

    @Override
    public void swim() {
        System.out.println(this.name + "在游泳");
    }
}


public class MoreInherit {
    public static void main1(String[] args) {
        Animal animal = new Cat("小花猫");
        Animal animal1 = new Bird("小鸟");
        Animal animal2 = new Duck("小鸭子");
    }

    public static void funcRun(Running running){
        running.run();
    }

    public static void funcSwim(Swimming swimming){
        swimming.swim();
    }

    public static void funcFly(Flying flying){
        flying.fly();
    }

    public static void main(String[] args) {
        funcFly(new Bird("小鸟"));
    }
}
