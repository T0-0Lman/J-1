//import java.util.Arrays;
//
//public class MyStack {
//
//    private int[] elem;
//    private int top;//下标（栈顶指针）
//    public MyStack(){
//        this.elem = new int[10];
//    }
//
//    /**
//     * 入栈操作
//     * @param item 入栈的元素
//     * @return 入栈的元素
//     */
//    public void push(int item){
//        //1.判断当前栈是否满了
//         if(isFull()){
//             this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
//         }
//        //2.elem[top] = item top++;
//         this.elem[top++] = item;
//    }
//
//    public boolean isFull(){
//        return this.elem.length == this.top;
//    }
//
//    /**
//     * 出栈操作
//     * @return 出栈的元素
//     */
//    public int pop(){
//        if(empty()){
//            throw new UnsupportedOperationException("栈为空！");
//        }
//
//        int ret = this.elem[this.top-1];
//        this.top--;//真正的改变了top的值
//        return ret;
//    }
//
//    /**
//     * 得到栈顶元素，但不删除
//     * @return
//     */
//    public int peek(){
//        if(empty()){
//            throw new UnsupportedOperationException("栈为空！");
//        }
//        return this.elem[this.top-1];
//    }
//
//    /**
//     * 判断栈是否为空
//     * @return
//     */
//    public boolean empty(){
//        return this.top == 0;
//    }
//
//    public static void main(String[] args) {
//        MyStack myStack = new MyStack();
//        myStack.push(1);
//        myStack.push(2);
//        myStack.push(3);
//
//
//        System.out.println(myStack.peek());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.empty());
//
//    }
//}
///**
// * 泛型类型实现栈
// */
//import java.util.Arrays;
//
//public class MyStack<T> {
//
//    private T[] elem;
//    private int top;//下标（栈顶指针）
//    public MyStack(){
//        this.elem =(T[])new Object[10];
//    }
//
//    /**
//     * 入栈操作
//     * @param item 入栈的元素
//     * @return 入栈的元素
//     */
//    public void push(T item){
//        //1.判断当前栈是否满了
//        if(isFull()){
//            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
//        }
//        //2.elem[top] = item top++;
//        this.elem[top++] = item;
//    }
//
//    public boolean isFull(){
//        return this.elem.length == this.top;
//    }
//
//    /**
//     * 出栈操作
//     * @return 出栈的元素
//     */
//    public T pop(){
//        if(empty()){
//            throw new UnsupportedOperationException("栈为空！");
//        }
//
//        T ret = this.elem[this.top-1];
//        this.top--;//真正的改变了top的值
//        return ret;
//    }
//
//    /**
//     * 得到栈顶元素，但不删除
//     * @return
//     */
//    public T peek(){
//        if(empty()){
//            throw new UnsupportedOperationException("栈为空！");
//        }
//        return this.elem[this.top-1];
//    }
//
//    /**
//     * 判断栈是否为空
//     * @return
//     */
//    public boolean empty(){
//        return this.top == 0;
//    }
//
//    public static void main(String[] args) {
//        MyStack<Integer> myStack1 = new MyStack<>();
//        myStack1.push(1);
//        myStack1.push(2);
//        myStack1.push(3);
//
//        System.out.println(myStack1.peek());
//        System.out.println(myStack1.pop());
//        System.out.println(myStack1.pop());
//        System.out.println(myStack1.pop());
//        System.out.println(myStack1.empty());
//        System.out.println("================");
//        MyStack<String> myStack2 = new MyStack<>();
//        myStack2.push("Nikita");
//        myStack2.push("Jill");
//        myStack2.push("Leon");
//
//        System.out.println(myStack2.peek());
//        System.out.println(myStack2.pop());
//        System.out.println(myStack2.pop());
//        System.out.println(myStack2.pop());
//        System.out.println(myStack2.empty());
//
//    }
//}
/**
 * 用链表来实现栈
 */
class  MtStack{
    public static void main(String[] args) {

    }
}