package operation;
import book.Book;
import book.BookList;

import java.util.Scanner;

public class Add implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("新增书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书的名字：");
        String name = scanner.nextLine();
        System.out.println("请输入作者的名字：");
        String author = scanner.nextLine();
        System.out.println("请输入图书的类型：");
        String type = scanner.nextLine();
        System.out.println("请输入图书的售价：");
        int price = scanner.nextInt();


        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBooks(i);
            if (name.equals(book.getName())) {
                System.out.println("该书书目已存在，不能重复添加！");
                return;
            }
        }
        Book book = new Book(name,author,price,type);
        bookList.setBooks(currentSize,book);
        bookList.setUsedSize(currentSize+1);
        System.out.println("新增成功！");

    }
}
