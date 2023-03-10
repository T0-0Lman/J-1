import book.BookList;
import user.Administrators;
import user.TypicalUser;
import user.User;

import java.util.Scanner;

public class Main {

    public static User login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = scanner.nextLine();

        System.out.println("请输入你的身份：1.管理员 2.普通用户");
        int choice = scanner.nextInt();
        if(choice == 1){
            return new Administrators(name);
        }else{
            return  new TypicalUser(name);
        }
    }

    
    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();

        while(true){
            //根据菜单的选项 来调用合适的方法
            int choice = user.menu();
            user.doOperation(choice,bookList);
        }
    }
}