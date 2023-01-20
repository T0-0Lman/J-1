package user;

import book.BookList;
import operation.IOperation;

public abstract class User {
    protected String name;
    protected IOperation[] iOperations;
    protected User(String name){
        this.name = name;
    }

    public abstract int menu();

    public void doOperation(int choice,BookList bookList){
        this.iOperations[choice].work(bookList);
    }
}
