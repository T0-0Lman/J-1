package 接口;
interface A{
    void funA();
}

interface B{
    void funB();
}

interface C{
    void funB();
}

interface H extends A,B{
    void funH();

}

class L implements H{

    @Override
    public void funA() {

    }

    @Override
    public void funB() {

    }

    @Override
    public void funH() {

    }

}

class D implements B,C{
    @Override
    public void funB() {
        System.out.println("hello");
    }
}


class E implements A,B{

    @Override
    public void funA() {

    }

    @Override
    public void funB() {

    }
}

public class TestInterface {
    public static void main(String[] args) {
        B b = new D();
        b.funB();
    }
}
