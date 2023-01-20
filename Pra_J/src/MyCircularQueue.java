public class MyCircularQueue {
    private int[] elem;//数组
    private int front;//头
    private int rear;//尾巴下标 表示当前可以存放元素的下标

    public MyCircularQueue(int k){
        this.elem = new int[k+1];//因为需要额外使用一个空间所以需要+1
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 入队操作
     * @param value
     * @return
     */
    public boolean enQueue(int value){
        if(isFull()) return false;
        this.elem[this.rear] = value;
        this.rear = (this.rear+1)%this.elem.length;//当是最后一个元素。rear+1不满足下标为0，所以需要采用模数组长度的方式
        return true;
    }

    /**
     * 出队操作
     * @return
     */
    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        this.front = (this.front+1)%elem.length;
        return true;
    }

    /**
     * 得到队头元素
     * @return
     */
    public int Front(){
        if(isEmpty()){
            return -1;
        }
        return this.elem[this.front];
    }

    /**
     * 得到队尾元素
     * @return
     */
    public int Rear(){
        if(isEmpty()){
            return  -1;
        }
        //注意rear == 0下标的时候
        int index = (this.rear == 0)? this.elem.length-1 : this.rear-1;
        return this.elem[index];
    }

    public boolean isEmpty(){
        //只要rear和front相遇，则表明队列为空
        if(this.front == this.rear){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if((this.rear+1)%this.elem.length == this.front){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isFull());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
    }
}
