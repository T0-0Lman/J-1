class Node{
    private int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    private Node next;
    public Node(int val){
        this.val = val;
    }
}

public class MyQueue{
    private Node first;
    private Node last;

    /**
     * 入队
     * @param val
     */
    public void offer(int val){
        Node node = new Node(val);
        if(first == null){
            this.first = node;
            this.last = node;
        }else {
            this.last.setNext(node);//last.next = node;
            this.last = node;
        }
    }

    /**
     * 出队
     * @return
     */
    public int  poll(){
        if (isEmpty()){
            throw new UnsupportedOperationException("队列为空！");
        }
        int ret = this.first.getVal();
        this.first = this.first.getNext();
        return ret;
    }

    /**
     * 查询栈顶元素
     * @return
     */
    public int peek(){
        if (isEmpty()){
            throw new UnsupportedOperationException("队列为空！");
        }
        return this.first.getVal();
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.first == null;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());

        System.out.println(myQueue.isEmpty());

    }
}




