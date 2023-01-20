import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MyHeap {
    public int[] elem;
    public int usedSize;

    public MyHeap(){
        this.elem = new int[10];
    }

    /**
     * 建大根堆
     * @param array
     */
    public void createHeap(int[] array){
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        //parent代表每棵树的根节点
        for(int parent = (array.length-1-1)/2;parent>=0;parent--){
            //第二个参数 每次调整结束的位置因该是this.usedSize。
            adjustDown(parent,this.usedSize);
        }
    }

    public void adjustDown(int root,int len){
         int parent = root;
         int child = 2*parent+1;
         //找到左右孩子的最大值
         //1.前提是有右孩子
         while(child<len){
             if(child+1<len && this.elem[child] < this.elem[child+1]){
                 child++;
             }
             //保证child下标的数据，一定是左右孩子的最大值
             if(this.elem[child] > this.elem[parent]){
                 int tmp = this.elem[child];
                 this.elem[child] = this.elem[parent];
                 this.elem[parent] = tmp;
                 parent = child;
                 child = parent*2 + 1;
             }else{
                 break;
             }
         }
    }

    public void adjustUp(int child){
        int parent = (child-1)/2;
        while(child > 0){
            if(this.elem[child] > this.elem[parent]){
                int tmp = this.elem[child];
                this.elem[parent] = this.elem[child];
                this.elem[child] = tmp;
                child = parent;
                parent = (child - 1)/2;
            }else{
                break;
            }
        }
    }

    public void push(int val){
        //满了则扩容
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        this.elem[this.usedSize++] = val;
        adjustUp(this.usedSize-1);//下标
    }

    public boolean isFull(){
        return this.usedSize == this.elem.length;
    }

    public void pop(){
        if(isEmpty()){
            return;
        }
        int tmp = this.elem[usedSize-1];
        this.elem[usedSize-1] = this.elem[0];
        this.elem[0] = tmp;
        this.usedSize--;//删除
        adjustDown(0,this.usedSize);
    }

    public boolean isEmpty(){
        return this.usedSize == 0;
    }

    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }

        return this.elem[0];
    }

    /**
     * 一定是创建大堆
     * 调整每棵树
     * 开始堆排序
     * 先交换后调整直到走到0下标结束
     */
    public void heapSort(){
        int end = this.usedSize-1;
        while(end > 0){
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            adjustDown(0,end);
            end--;
        }
    }
    //topK问题(最小)
    public void topK(int[] array,int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;//o1-o2
            }
        });
        //大堆
        for (int i = 0; i < array.length; i++) {
            if(maxHeap.size()<k){
                maxHeap.offer(array[i]);
            }else{
                int top = maxHeap.peek();
                if(top > array[i]){// < 就是求最大
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }
        System.out.println(maxHeap);
    }


    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        MyHeap myHeap = new MyHeap();
        myHeap.createHeap(array);
        //myHeap.pop();
        //myHeap.heapSort();
        myHeap.topK(array,3);
        System.out.println("");
    }
}
