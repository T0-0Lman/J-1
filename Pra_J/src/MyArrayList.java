import java.util.Arrays;

public class MyArrayList {
    //实例成员变量：如果不初始化默认值就是对应的0值
    public int[] elem;//只是定义了一个引用
    public int usedSize;//有效的引用数据个数

    public MyArrayList(){
        this.elem = new int[5];
    }
    //显示函数(打印顺序表)
    public void display(){
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
    //判断数组是否满了
    public boolean isFull(){
        if(this.elem.length == this.usedSize){
            return true;
        }
        return false;
    }
    //在pos位置新增元素
    public void add(int pos,int data){
        //4.判断元素是否插满(插满扩容)
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        //1.判断pos位置是否合法
        if(pos<0 || pos>this.usedSize){//加this是个良好的编程习惯
            System.out.println("pos位置不合法！");
            return;
        }
        //2.
        for (int i = this.usedSize-1; i >=pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        //3.
        this.elem[pos] = data;
        this.usedSize++;
    }
    //判断是否包含某个元素
    public boolean contains(int toFind){
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind){
                return true;
            }
        }
       return false;
    }
    //查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
    //获取pos位置的元素
    public int getPos(int pos) throws UnsupportedOperationException{
        if(pos>0 || pos<this.usedSize){
             return this.elem[pos];
        }
        //手动抛出异常
       throw new UnsupportedOperationException("pos位置不合法！");
    }
    //给pos位置元素设置value
    public void setPos(int pos,int value){
        if(pos>0 || pos<this.usedSize){
            this.elem[pos] = value;
        }
    }
    //删除第一次出现的关键字key
    public void remove(int key){
            int index = this.search(key);
            if(index == -1){
                System.out.println("不存在该关键字");
                return;
            }
            for (int i = index; i < this.usedSize-1; i++) {
                    this.elem[i] = this.elem[i+1];
            }
        this.usedSize--;
    }
    //获取顺序表长度
    public int size(){
        return 0;
    }
    //清空顺序表
    public void clear(){
        this.usedSize = 0;
    }
}
