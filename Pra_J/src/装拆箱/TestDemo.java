package 装拆箱;

public class TestDemo {
    public static void main1(String[] args) {
        Integer a = 10;
        int i = a;

        int i2 = a.intValue();
        double d = a.doubleValue();
        byte b = a.byteValue();
    }

    public static void main(String[] args) {
        int i = 10;
        Integer a = i;
        Integer a2 = Integer.valueOf(i);
        System.out.println(a2);
    }
}

