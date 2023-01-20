package operation;

import book.Book;
import book.BookList;

public class Display implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("显示书籍");
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
                Book book = bookList.getBooks(i);
                System.out.println(book);
        }
    }
}

