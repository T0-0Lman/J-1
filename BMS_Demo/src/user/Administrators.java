package user;

import operation.*;

import java.util.Scanner;

public class Administrators extends User{

    public Administrators(String name) {
        super(name);
        this.iOperations =new IOperation[] {
                new Quit(),
                new Find(),
                new Add(),
                new Del(),
                new Display()
        };
    }

    public int menu(){
        System.out.println("********管理员菜单********");
        System.out.println("hello" + " " + this.name + " " + "欢迎使用图书管理系统");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统！");
        System.out.println("***********************");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
