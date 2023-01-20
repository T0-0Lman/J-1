class DoublyLinkedList{
    public int val;
    public DoublyLinkedList prev;
    public DoublyLinkedList next;

    public DoublyLinkedList(int val){
        this.val = val;
    }
}

public class MyDoublyLinkedList {
    public DoublyLinkedList head;
    public DoublyLinkedList last;

    //打印函数
    public void display(){
        DoublyLinkedList cur = this.head;
        while(cur != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //头插法
    public void addFirst(int data){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(data);
        if(head == null){
            this.head = doublyLinkedList;
            this.last = doublyLinkedList;
        }else{
            doublyLinkedList.next = this.head;
            this.head.prev = doublyLinkedList;
            this.head = doublyLinkedList;
        }
    }
    //尾插法
    public void addLast(int data){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(data);
        if(this.head == null){
            this.head = doublyLinkedList;
            this.last = doublyLinkedList;
        }else{
            last.next = doublyLinkedList;
            doublyLinkedList.prev = last;
            last = doublyLinkedList;
        }
    }

    //步数计数器
    public DoublyLinkedList searchIndex(int index){
        DoublyLinkedList cur = this.head;
        while(index != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //从任意位置插入，第一个数据节点的下标为0号下标
    public void addIndex(int index,int data){
        if(index<0 || index > size()){
            System.out.println("插入位置不合法！");
            return;
        }

        if(index == 0){
            addFirst(data);
            return;
        }

        if(index == size()){
            addLast(data);
            return;
        }

        DoublyLinkedList cur = searchIndex(index);
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(data);
        doublyLinkedList.next = cur;
        cur.prev.next = doublyLinkedList;
        doublyLinkedList.prev = cur.prev;
        cur.prev = doublyLinkedList;

    }

    //求链表长度函数
    public int size(){
        DoublyLinkedList cur = this.head;
        int count = 0;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }

    //是否包含元素
    public boolean contins(int key){
        DoublyLinkedList cur = this.head;
        while (cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字key的节点
    public void remove(int key){
        DoublyLinkedList cur = this.head;
        while (cur != null){
            if(cur.val == key){
                //说明cur所在的节点 就是删除节点
                if(cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else{
                    //要么是中间位置 要么是尾巴节点
                    cur.prev.next = cur.next;
                    if(cur.next != null){
                        cur.next.prev = cur.prev;
                    }else{
                        last = cur.prev;
                    }
                }
                return;
            }else{
                cur = cur.next;
            }
        }
    }

    //删除所有节点
    public void removeAllKey(int key){
        DoublyLinkedList cur = this.head;
        while(cur != null){
            if(cur.val == key){
                if(cur == this.head){
                    this.head = this.head.next;
                    //假设全部是要删除的数字 要防止空指针异常
                    if(this.head != null){
                        this.head.prev = null;
                    }else{
                        last = null;
                    }
                }else{
                    //删除尾节点
                    cur.prev.next =  cur.next;
                    if(cur.next != null){
                        cur.next.prev = cur.prev;
                    }else{
                        last = cur.prev;
                    }
                }
                cur = cur.next;
            }else{
                cur = cur.next;
            }
        }
    }

    //删除所有节点
    //JPS jmap -live:histo 进程号 >文件
    public void removeAll(){
        DoublyLinkedList cur = this.head;


        while(cur != null){
            DoublyLinkedList curNext = cur.next;
            cur.next = null;
            cur = curNext;
        }
        head = null;
        last = null;
    }

}
