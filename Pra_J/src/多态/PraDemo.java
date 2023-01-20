package 多态;

//class Animal{
//    public String name;
//    public Animal(String name){
//        this.name = name;
//        //eat();
//        this.func();
//    }
//
//    public void func(){
//        System.out.println("anmial::func()");
//    }
//
//    public void eat(){
//        System.out.println(this.name + "用餐！Animal");
//    }
//}
//
//class Cat extends Animal{
//    public int age;
//    public Cat(String name){
//        super(name);
//    }
//    @Override//一旦这个注释修饰了这个方法，只要该方法的方法名，返回值，参数列表有一个不满足重写要求就会报错
//    public void eat(){
//        System.out.println(this.name + "用餐！Cat");
//    }
//}
//
//class Bird extends Animal {
//    protected String name = "青鸟";
//    public Bird(String name){
//        super(name);
//    }
//
//    public void fly(){
//        System.out.println(this.name + "飞");
//    }
//}
//
//public class PraDemo {
//    public static void main1(String[] args) {
//        Cat cat = new Cat("小花猫");
//        //animal这个引用 引用了 cat这个引用 引用的对象
//        //Animal animal = cat;
//        //向上转型 父类引用 引用了子类对象
//        Animal animal1 = new Cat("小花猫");
//        Cat cat1  = new Cat("小花猫2");
//        func1(cat1);
//        func2();
//    }
//    public static void func1(Animal animal){
//
//    }
//
//    public static Animal func2(){
//        Cat cat3  = new Cat("小花猫3");
//        return cat3;
//    }
//
//    public static void main2(String[] args) {
//        Animal animal = new Bird("青鸟");
//        Bird bird = (Bird) animal;
//        bird.fly();
//        //这里需要使用向下转型后的子类来调用，通过父类来调用是错误的
//        //animal.fly();
//    }
//
//    public static void main3(String[] args) {
//        Animal animal = new Cat("小花猫");
//        if(animal instanceof Bird){
//            Bird bird = (Bird) animal;
//            bird.fly();
//        }
//    }
//
//    public static void main(String[] args) {
//        Animal animal = new Cat("小花猫");
//        //animal.eat();
//    }
//
//}

class Shape{
    public void draw(){

    }
}

class Rect extends Shape{
    public void draw(){
        System.out.println("♦");
    }
}

class Cycle extends Shape{
    public void draw(){
        System.out.println("⚪");
    }
}

class Flower extends Shape{
    public void draw(){
        System.out.println("🌼");
    }
}

public class PraDemo {
    public static void drawMap(Shape shape){
        shape.draw();
    }


    public static void drawShapes1(){
        Rect rect = new Rect();
        Cycle cycle = new Cycle();
        Flower flower = new Flower();

        String[] shapes = {"cycle","rect","cycle","rect","flower"};
        for(String shape : shapes){
            if (shape.equals("cycle")){
                cycle.draw();
            } else if (shape.equals("rect")) {
                rect.draw();
            } else if (shape.equals("flower")) {
                flower.draw();
            }
        }
    }


    public static void drawShapes2(){
        Rect rect = new Rect();
        Cycle cycle = new Cycle();
        Flower flower = new Flower();
        //向上转型
        Shape[] shapes = {cycle,rect,new Cycle(),new Cycle(),flower};
        for (Shape shape: shapes) {
            shape.draw();
        }

    }

    public static void main(String[] args) {
//        Shape shape1 = new Rect();
//        shape1.draw();
//
//        Shape shape2 = new Cycle();
//        shape2.draw();
//
//        Rect rect = new Rect();
//        Cycle cycle = new Cycle();
//        drawMap(rect);
//        drawMap(cycle);
//
//        Rect rect = new Rect();
//        Cycle cycle = new Cycle();
//        Flower flower = new Flower();

        drawShapes1();
        System.out.println("--------------");
        drawShapes2();

    }
}