package generic;


class MyArrayList<T>{
    private T[] elem;
    private int usedSize;

    public MyArrayList(){
        this.elem =(T[]) new Object[10];
    }

    public void add(T val){
        this.elem[this.usedSize++] = val;
    }

    public T getPos(int pos){
        return this.elem[pos];
    }
}

class Person{

}
public class TestDemo {
    public static void main1(String[] args) {
        MyArrayList<Integer> arrayList1 = new MyArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);

        int ret = arrayList1.getPos(0);
        System.out.println(ret);

        MyArrayList<String> arrayList2 = new MyArrayList<>();
        arrayList2.add("nikita");
        arrayList2.add("jill");

    }

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);

        MyArrayList<Integer> arrayList3 = new MyArrayList<>();
        System.out.println(arrayList3);
        MyArrayList<String> arrayList4 = new MyArrayList<>();
        System.out.println(arrayList4);
    }
}
