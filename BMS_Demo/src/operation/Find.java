package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class Find implements IOperation{
    @Override
    public void work(BookList bookList){
        System.out.println("查找书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你需要查找的书名：");
        String name = scanner.nextLine();

        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBooks(i);
            if(name.equals(book.getName())){
                System.out.println("找到此书如下");
                System.out.println(book);
                return;
            }
        }
        System.out.println("没有这本书！");
    }
}
