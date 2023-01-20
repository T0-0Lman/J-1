package 接口;

interface IShape{
    void draw();
}

class Cycle implements IShape{
    @Override
    public void draw() {
        System.out.println("⚪");
    }
}

class Rect implements IShape{
    @Override
    public void draw() {
        System.out.println("♦");
    }
}

public class PraDemo {
    public static void drawShape(IShape iShape){
        iShape.draw();
    }

    public static void main(String[] args) {
        IShape iShape = new Cycle();
        IShape iShape1 = new Rect();

        drawShape(iShape);
        drawShape(iShape1);
    }
}
