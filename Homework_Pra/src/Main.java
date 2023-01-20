//import java.util.Arrays;
//
//class MyArrayList{
//        public int[] elem;
//        public int usedSize;
//        public MyArrayList(){
//            this.elem = new int[5];
//        }
//
//        public boolean isFull(){
//            if(this.elem.length == this.usedSize){
//                return true;
//            }
//            return false;
//        }
//        public void add(int val,int pos){
//
//            if(isFull()){
//                this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
//            }
//            if(pos<0 || pos>this.usedSize){
//                System.out.println("pos位置不合法！");
//                return;
//            }
//
//            for (int i = this.usedSize-1;i>=pos;i--){
//                this.elem[i+1] = this.elem[i];
//            }
//            elem[pos] = val;
//            usedSize++;
//        }
//
//        public boolean contains(int toFind){
//            for(int i = 0;i<this.usedSize;i++){
//                if(toFind == this.elem[i]){
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        public int search(int toFind){
//            for(int i = 0;i<this.usedSize;i++){
//                if(toFind == this.elem[i]){
//                    return i;
//                }
//            }
//            return -1;
//        }
//
//        public int getPos(int pos){
//            if(pos>0 || pos<this.usedSize){
//                return this.elem[pos];
//            }
//            //手动抛出异常
//            throw new UnsupportedOperationException("pos位置不合法！");
//        }
//
//        public void setPos(int val,int pos){
//            if(pos>0 || pos<this.usedSize){
//                this.elem[pos] = val;
//            }
//        }
//
//        public void removeKey(int key){
//            int index = this.search(key);
//            if(index == -1){
//                System.out.println("关键字不存在");
//                return;
//            }
//            for(int i = index;i<this.usedSize-1;i++){
//                    this.elem[i] = this.elem[i+1];
//            }
//            usedSize--;
//        }
//
//        public int size(){
//            return this.elem.length;
//        }
//
//        public void clear(){
//            this.usedSize = 0;
//        }
//
//        public void display(){
//           for(int i = 0;i<this.usedSize;i++){
//               System.out.print(this.elem[i]+" ");
//           }
//            System.out.println();
//        }
//
//}
//public class Main {
//    public static void main(String[] args) {
//        MyArrayList arrayList = new MyArrayList();
//        arrayList.add(1,0);
//        arrayList.add(2,1);
//        arrayList.add(3,2);
//        arrayList.add(4,3);
//        arrayList.add(5,4);
//        arrayList.display();
//        arrayList.add(6,5);
//        arrayList.display();
//    }
//}p

class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int data){
        this.val = data;
    }
}

class LinkedList{
    public ListNode head;
    public void display(){
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void addFirst(int data){
        ListNode listNode = new ListNode(data);
        listNode.next = this.head;
        this.head = listNode;
    }

    public void addLast(int data){
        ListNode listNode = new ListNode(data);
        if(this.head == null){
            this.head = listNode;
        }else{
            ListNode cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
           cur.next = listNode;
        }
    }

    public ListNode searchPrev(int key){
        ListNode prev = this.head;
        if(this.head.val == key){
            prev = this.head.next;
        }
        while(prev.next != null){
            if(prev.next.val == key){
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    public ListNode removeKey(int key){
        ListNode prev = searchPrev(key);
        if(prev == null){
            System.out.println("删除节点不存在");
            return null;
        }
        ListNode del = prev.next;
        prev.next = del.next;
        return this.head;
    }

    public void removeAllKey(int key){
        ListNode prev = this.head;
        ListNode cur = this.head.next;

        while(this.head.val == key){
            this.head = this.head.next;
        }

        while(cur != null){
            if(cur.val == key){
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
    }

    public ListNode findIndexSubOne(int index){
        ListNode cur = this.head;
        int count = 0;
        while (count != index-1){
            cur = cur.next;
            count++;
        }
        return cur;
    }

    public void addIndex(int index,int data){
        if(index < 0 || index >size()){
            System.out.println("插入位置不合法");
            return;
        }

        if(index == size()){
            addLast(data);
            return;
        }

        if (index == 0){
            addFirst(data);
            return;
        }

        ListNode cur = findIndexSubOne(index);
        ListNode node = new ListNode(data);
        node.next = cur.next;
        cur.next = node;

    }

    public int size(){
        ListNode cur = this.head;
        int count = 0;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }

    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void clear(){
        ListNode cur = this.head;
        while(cur != null){
            ListNode curNext = cur.next;
            cur.next = null;
            cur = curNext;
        }
        this.head = null;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        System.out.println("头插尾插创建链表");
        linkedList.addFirst(2);
        linkedList.addFirst(5);
        linkedList.addLast(5);
        linkedList.addLast(4);
        linkedList.addLast(6);
        linkedList.display();
        System.out.println("删除重复关键字key");
        ListNode node =  linkedList.removeKey(5);
        linkedList.display();
        System.out.println("删除所有关键字key");
        linkedList.removeAllKey(5);
        linkedList.display();
        System.out.println("任意位置插入关键字key");
        linkedList.addIndex(2,5);
        linkedList.display();
        System.out.println("是否包含关键字key");
        System.out.println(linkedList.contains(5));
        System.out.println("清除链表");
        linkedList.clear();
        linkedList.display();
    }
}