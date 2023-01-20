package user;

import operation.*;

import java.util.Scanner;

public class TypicalUser extends User{

    public TypicalUser(String name) {
        super(name);

        //把普通用户的操作，存储到这个数组当中
        this.iOperations =new IOperation[] {
                new Quit(),
                new Find(),
                new Borrow(),
                new Return()
        };

    }

    public int menu(){
        System.out.println("普通用户菜单！");
        System.out.println("********普通用户菜单********");
        System.out.println("hello" + " " + this.name + " " + "欢迎使用图书管理系统");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统！");
        System.out.println("*************************");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
