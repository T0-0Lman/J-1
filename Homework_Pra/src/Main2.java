
class DoublyLinkedList{
    public int val;
    public DoublyLinkedList prev;
    public DoublyLinkedList next;
    public DoublyLinkedList(int val){
        this.val = val;
    }
}

class MyDoublyLinkedList{
    public DoublyLinkedList head;
    public DoublyLinkedList last;

    public void display(){
        DoublyLinkedList cur = this.head;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

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

    public DoublyLinkedList searchIndex(int index){
        DoublyLinkedList cur = this.head;
        while(index != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    public int size(){
        DoublyLinkedList cur = head;
        int count = 0;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }

    public void addIndex(int index,int data){
        if(index < 0 || index > size()){
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

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(data);
        DoublyLinkedList cur = searchIndex(index);
        doublyLinkedList.next = cur;
        cur.prev.next = doublyLinkedList;
        doublyLinkedList.prev = cur.prev;
        cur.prev = doublyLinkedList;
    }

    public boolean cotains(int key){
        DoublyLinkedList cur = this.head;
        while(cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void remove(int key){
        DoublyLinkedList cur = this.head;
        while(cur != null){
            if(cur.val == key){
                if(cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else{
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
    //有点懵删除所有关键字
    public void removeAllKey(int key){
        DoublyLinkedList cur = this.head;
        while (cur != null){
            if(cur.val == key){
                if(cur == this.head){
                    this.head = this.head.next;
                    if(this.head != null){
                        this.head.prev = null;
                    }else{
                        last = null;
                    }
                }else{
                    cur.prev.next = cur.next;
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


public class Main2 {
    public static void main(String[] args) {
        MyDoublyLinkedList doublyLinkedList = new MyDoublyLinkedList();
        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(2);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addLast(4);
        doublyLinkedList.display();
        doublyLinkedList.addIndex(3,99);
        doublyLinkedList.display();
        System.out.println(doublyLinkedList.cotains(3));
        doublyLinkedList.remove(99);
        doublyLinkedList.display();
        doublyLinkedList.removeAllKey(3);
        doublyLinkedList.display();
        doublyLinkedList.removeAll();
        doublyLinkedList.display();

    }
}
