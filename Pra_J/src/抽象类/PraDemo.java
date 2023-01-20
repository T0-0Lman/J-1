package 抽象类;

abstract class Shape{
    //如果一个方法没有被具体实现，就可以使用abstract来修饰
    public abstract void draw();
}

class Rect extends Shape{
    @Override
    public void draw() {
        System.out.println("♦");
    }

    public void func() {

    }
}

class Cycle extends Shape{
    @Override
    public void draw() {
        System.out.println("⚪");
    }
}

class Flower extends Rect{
    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void func() {

    }
}

public class PraDemo {

    public static void drawShpe(Shape shape){
        shape.draw();
    }

    public static void main(String[] args) {
        Rect rect = new Rect();
        Cycle cycle = new Cycle();
        drawShpe(rect);
        drawShpe(cycle);
    }

}
