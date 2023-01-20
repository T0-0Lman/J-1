//Java集合当中LinkedList底层是一个双向链表 这里先暂时用下这个名字

import org.w3c.dom.ls.LSException;

import java.lang.module.FindException;

class ListNode{
    public int val;//值
    public ListNode next;//存储下一个节点的地址 也就是说这是一个引用

    public ListNode(){

    }

    public ListNode(int val){
        this.val = val;
    }
}
public class MyLinkedList {
    public ListNode head;//标识整个链表的头
    //穷举法，先以最low的方法创建一个链表出来
//    public void createList(){
//        ListNode listNode1 = new ListNode(12);
//        ListNode listNode2 = new ListNode(45);
//        ListNode listNode3 = new ListNode(6);
//        ListNode listNode4 = new ListNode(8);
//        ListNode listNode5 = new ListNode(5);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        this.head = listNode1;//head引用 引用了listNode1引用 引用的对象
//    }

    //遍历链表
    public void display1(){
        ListNode cur = this.head;
        while (cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void display2(ListNode head){
        ListNode cur = head;
        while (cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //获取单链表的长度
    public int size(){
        ListNode cur = this.head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    //头插法
    public void addFirst(int data){
        //这里的node实例化一个对象
        ListNode node = new ListNode(data);
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        //第一次插入
        if (this.head == null){
            this.head = node;
        //非第一次插入
        }else{
            ListNode cur = this.head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //在任意位置插入，第一个数据节点为0的下标
    public void addIndex(int index,int data){
        if(index < 0 || index > size()){
            System.out.printf("插入位置不合法！");
            return;
        }
        if(index == size() ){
            addLast(data);
            return;
        }
        if(index == 0){
            addFirst(data);
            return;
        }

        ListNode cur = findIndexSubOne(index);
        ListNode node = new ListNode(data);
        node.next = cur.next;
        cur.next = node;
    }

    public ListNode findIndexSubOne(int index){
        ListNode cur = this.head;
        int count = 0;
//        for (int i = 0; i < index; i++) {
//                cur = cur.next;
//        }
        while(count != index -1 ){
            count++;
            cur = cur.next;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while (cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        //cur == null;
        return false;
    }

    public ListNode searchPrev(int key){
        ListNode prev = this.head;
        while(prev.next != null){
            if(prev.next.val == key){
                return prev;
            }
            prev = prev.next;
        }
        return null;//代表没有找到这个节点
    }

    //删除第一次出现的关键字key节点
    public void remove(int key){
        //0.头节点是要删除的节点
        if(this.head.val == key){
            this.head = this.head.next;
            return;
        }
        //找到删除节点的前驱节点
        ListNode prev = searchPrev(key);
        if(prev == null){
            System.out.println("删除节点不存在");
            return;
        }
        //开始删除
        ListNode del = prev.next;
        prev.next = del.next;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode prev = this.head;
        ListNode cur = this.head.next;
//
//        while(this.head.val == key){
//            this.head = this.head.next;
//        }

        while(cur != null){
            if(cur.val == key){
                prev.next = cur.next;
                cur = cur.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        //判断头节点是否是要删除的节点 如果放在函数前面则必须是循环。
        if(this.head.val == key){
            this.head = this.head.next;
        }
    }

    //清空单链表
    public void clear(){
        //直接置空头节点
//        this.head == null;
        //挨个置空
        ListNode cur = this.head;
        while (cur != null){
            ListNode curNext = cur.next;
            cur.next = null;
            cur = curNext;
        }
        this.head = null;
    }
}
