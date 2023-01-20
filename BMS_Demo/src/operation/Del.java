package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class Del implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除书籍的名字：");
        String name = scanner.nextLine();

        int index = -1;
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize ; i++) {
            Book book = bookList.getBooks(i);
            if (name.equals(book.getName())) {
                //找到了这本书
                index = i;
            }
        }
        if(index == -1){
            System.out.println("没有你要删除的书籍!");
            return;
        }

        for (int i = index; i < currentSize-1; i++) {
            Book book1 = bookList.getBooks(i+1);
            bookList.setBooks(i,book1);
        }
        //防止内存泄漏
        bookList.setBooks(currentSize-1,null);
        //控制usedSize
        bookList.setUsedSize(currentSize-1);
        System.out.println("删除成功！");
    }
}
