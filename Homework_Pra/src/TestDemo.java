//class B {
//    public int Func() {
//        System.out.print("B");
//        return 0;
//    }
//}
//class D extends B {
//    @Override
//    public int Func() {
//        System.out.print("D");
//        return 0;
//    }
//}
//
//public class TestDemo {
//    public static void main(String[] args) {
//        B a = new B();
//        B b = new D();
//        a.Func();
//        b.Func();
//    }
//}

//public class TestDemo {
//
//    private static void testMethod(){
//
//        System.out.println("testMethod");
//
//    }
//
//    public static void main(String[] args) {
//
//        ((TestDemo)null).testMethod();
//
//    }
//
//}

import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int password = 123456;
        int n = 3;
        do{
            System.out.println("请输入密码：");
            int userScan = scan.nextInt();
            if(userScan != password){
                System.out.println("密码错误!还有"+n+"次机会！");
                n--;
                if(n == -1){
                    System.out.println("联系客服！");
                    break;
                }
            }
            else{
                System.out.println("密码正确！");
                break;
            }
        }while(true);
    }
}