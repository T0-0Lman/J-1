public class TestDemo {
    //合并两个有序链表
//    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//
//        ListNode newHead = new ListNode();
//        ListNode tmp = newHead;
//
//        while(list1 != null && list2 != null){
//            if(list1.val > list2.val){
//                tmp.next = list2;
//                list2 = list2.next;
//                tmp = tmp.next;
//            }else{
//                tmp.next = list1;
//                list1 = list1.next;
//                tmp = tmp.next;
//            }
//        }
//        if(list1 != null){
//            tmp.next = list1;
//        }
//        if(list2 != null){
//            tmp.next = list2;
//        }
//        return newHead.next;
//    }

    public static void main(String[] args) {
        //顺序表引用的对象
//        MyArrayList myArrayList = new MyArrayList();
//        myArrayList.add(0,1);
//        myArrayList.add(1,2);
//        myArrayList.add(2,3);
//        myArrayList.add(3,4);
//        myArrayList.add(4,5);
//        myArrayList.add(5,6);
//        myArrayList.add(6,7);
//        //myArrayList.add(7,7);
//        myArrayList.display();
//
////        try{
////            int ret = myArrayList.getPos(3);
////            System.out.println(ret);
////        }catch (UnsupportedOperationException e){
////            e.printStackTrace();
////        }
//
//        int index = myArrayList.search(7);
//        System.out.println(index);
//
//        System.out.println(myArrayList.contains(8));
//
//        myArrayList.setPos(6,88);
//        myArrayList.display();
//
//        //rugumyArrayList.remove(88);
//        myArrayList.remove(4);
//        myArrayList.remove(1);
//        myArrayList.display();
//        MyLinkedList myLinkedList = new MyLinkedList();
//      myLinkedList.createList();
//      myLinkedList.addFirst(1);
//      myLinkedList.addFirst(2);
//      myLinkedList.addFirst(3);

//        myLinkedList.addLast(1);
//        myLinkedList.addLast(2);
//        myLinkedList.addLast(3);
//        myLinkedList.addFirst(88);
//        myLinkedList.display();
//
//        myLinkedList.addIndex(4,188);
//        myLinkedList.remove(188);
//        myLinkedList.remove(88);
//        myLinkedList.display();
//        System.out.println(myLinkedList.size());
//        System.out.println(myLinkedList.contains(1));
//
//        myLinkedList.clear();
//        myLinkedList.display();

//        MyLinkedList myLinkedList1 = new MyLinkedList();
//        myLinkedList1.addLast(2);
//        myLinkedList1.addLast(4);
//        myLinkedList1.addLast(5);
//        myLinkedList1.addLast(6);
//        myLinkedList1.addLast(7);
//        myLinkedList1.display1();
//
//        MyLinkedList myLinkedList2 = new MyLinkedList();
//        myLinkedList2.addLast(1);
//        myLinkedList2.addLast(3);
//        myLinkedList2.addLast(7);
//        myLinkedList2.addLast(9);
//        myLinkedList2.addLast(10);
//        myLinkedList2.display1();
//
//        ListNode ret = mergeTwoLists(myLinkedList1.head,myLinkedList2.head);
//        myLinkedList1.display2(ret);
        MyDoublyLinkedList doublyLinkedList = new MyDoublyLinkedList();
//        doublyLinkedList.addLast(1);
//        doublyLinkedList.addLast(2);
//        doublyLinkedList.addLast(3);
//        doublyLinkedList.addLast(4);
//        doublyLinkedList.addLast(5);

        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(1);
        doublyLinkedList.display();
        doublyLinkedList.addIndex(4,99);
        doublyLinkedList.display();
        //System.out.println(doublyLinkedList.contins(1));
        doublyLinkedList.remove(99);
        doublyLinkedList.display();
        //doublyLinkedList.removeAllKey(1);
        doublyLinkedList.removeAll();
        doublyLinkedList.display();


    }
}

