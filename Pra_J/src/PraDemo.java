//import java.util.*;
////不能只导入一个具体的包，必须具体到类。
//class Animal{
//    public String name;
//    public void eat(){
//        System.out.println(this.name + "吃饭！");
//    }
//}
//
//class Cat extends Animal{
//
//}
//
//class Bird extends Animal{
//    public void fly(){
//        System.out.println(this.name + "飞起来了！");
//    }
//}
//public class PraDemo {
//    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
//        Cat cat = new Cat();
//        cat.name = "cat1";
//        cat.eat();
//    }
//}

//class A<T>{
//    T value;
//    A(T value){
//      this.value = value;
//    }
//    T get(){
//        return value;
//    }
//}
//public class PraDemo {
//    public static void main(String[] args) {
//        A<Integer> a1 = new A<>(1);
//        System.out.println(a1.get());
//    }
//}

//import java.util.*;
//
//class PraDemo{
//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//
//        list.add(5);
//        list.add(3);
//        list.add(1);
//        list.add(2);
//        list.add(4);
//
//        Collections.sort(list);
//        System.out.println(list);
//
//
//    }
//}
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//class Student implements Comparable<Student>{
//    private int age;
//    private String name;
//    public Student(int age, String name) {
//        this.age = age;
//        this.name = name;
//    }
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "age=" + age +
//                ", name='" + name + '\'' +
//                '}';
//    }
//
//    @Override
//    public int compareTo(Student o) {
//        return this.age - o.age;
//    }
//}
//
//class PraDemo{
//    public static void main(String[] args) {
//        List<Student> students = new ArrayList<>();
//        students.add(new Student(20, "张三"));
//        students.add(new Student(19, "李四"));
//        Collections.sort(students);
//        System.out.println(students);
//    }
//}

//import java.util.ArrayList;
//
//class PraDemo{
//    public static void main(String[] args) {
//        String str1 = "welcome to java";
//        String str2 = "come";
//
//        ArrayList<Character> list = new ArrayList<>();
//
//        for (int i = 0; i < str1.length() ; i++) {
//            char ch = str1.charAt(i);
//            if(!str2.contains(ch+"")){
//                list.add(ch);
//            }
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i));
//        }
//
//    }
//}



//有问题
//class PraDemo{
//    public static int removeElement(int[] nums, int val) {
//        int count = 0;
//        int len = nums.length;
//        for(int i = 0; i<nums.length-1;i++){
//                int j = i+1;
//                if(nums[i] == val && nums[i] != nums[j]){
//                    int tmp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = tmp;
//                    count++;
//                }
//            }
//        return len - count;
//    }
//
//    public static void main(String[] args) {
//       int[] nums = new int[]{3,2,2,3};
//       int val = 3;
//       int ret = removeElement(nums,val);
//       System.out.println(ret);
//    }
//}

//class PraDemo{
//    public  static int  removeElement(int[] nums, int val) {
//            int slow = 0;
//            int fast = slow+2;
//            int cur = slow+1;
//            for(slow = 0; slow<nums.length-2;slow++){
//                if(nums[slow] == val && nums[cur] == val  && nums[fast] != val){
//                    int tmp = nums[slow];
//                    nums[slow] = nums[fast];
//                    nums[fast] = tmp;
//                }
//            }
//            return slow;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = new int[]{0,1,2,2,3,0,4,2};
//        int ret =  removeElement(nums,2);
//        System.out.println(ret);
//    }
//}

//class PraDemo{
//    public  static int  removeElement(int[] nums, int val) {
//        int start = 0;
//        int end = nums.length-1;
//        while(start <= end){
//            if(nums[start] == val &&  nums[end] != val ){
//                int tmp = nums[start];
//                nums[start] = nums[end];
//                nums[end] = tmp;
//                start++;
//                end--;
//            } else if (nums[start] != val && nums[end] == val  ) {
//                end--;
//                start++;
//            }else if(nums[start] != val && nums[end] != val ){
//                start++;
//            }else{
//                end--;
//            }
//        }
//        return start;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = new int[]{0,1,2,2,3,0,4,2};
//        int ret =  removeElement(nums,2);
//        System.out.println(ret);
//        System.out.print("nums"+"[");
//        for (int i = 0; i < ret-1; i++) {
//            System.out.print(nums[i]+",");
//            if(i == ret -2){
//                System.out.print(nums[i]);
//            }
//        }
//        System.out.print("]");
//        System.out.println();
//        System.out.println(nums.length);
//    }
//}

//import java.util.Scanner;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class PraDemo {
//    public static void main(String[] args) {
//        Queue<Integer> queue = new LinkedList<>();
//
//        queue.offer(1);
//        queue.offer(2);
//        queue.offer(3);
//
//        System.out.println(queue.peek());//得到对头元素
//        System.out.println(queue.poll());//出队元素
//        System.out.println(queue.poll());//出队元素
//    }
//}
////有问题
//public class PraDemo {
//    public static int[] sortedSquares(int[] nums) {
//        int start = 0;
//        int end = nums.length -1;
//        while(start <= end){
//            if(nums[start]*nums[start] >nums[end]*nums[end]){
//                int tmp = nums[start]*nums[start];
//                nums[start] = nums[end]*nums[end];
//                nums[end] = tmp;
//            }
//            end--;
//        }
//        return nums;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = new int[]{-4,-1,0,3,10};
//        int[] array = sortedSquares(nums);
//        for(int i = 0;i <array.length;i++){
//            System.out.print(" "+array[i]+" ");
//        }
//    }
//}

//public class PraDemo {
//    public static void main1(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("请输入年：");
//        int year = scanner.nextInt();
//        while(year < 0 ){
//            System.out.print("非法的年份，请重新输入：");
//            year = scanner.nextInt();
//        }
//        System.out.print("请输入月：");
//        int month = scanner.nextInt();
//        while(month < 1 || month > 12){
//            System.out.print("非法的月份，请重新输入：");
//            month = scanner.nextInt();
//        }
//        if(((year%4 == 0 && year %100 != 0) ||year % 400 == 0) && month == 2){
//            System.out.println("该月天数:29");
//        } else if (month == 2) {
//            System.out.println("该月天数:28");
//        } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ) {
//            System.out.println("该月天数:31");
//        } else {
//            System.out.println("该月天数:30");
//        }
//    }
//}
//public class PraDemo {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("请输入年：");
//        int year = scanner.nextInt();
//        while(year < 0 ){
//            System.out.print("非法的年份，请重新输入：");
//            year = scanner.nextInt();
//        }
//
//        System.out.print("请输入月：");
//        int month = scanner.nextInt();
//        while(month < 1 || month > 12){
//            System.out.print("非法的月份，请重新输入：");
//            month = scanner.nextInt();
//        }
//
//        int days = 0;
//        switch (month){
//            case 1:
//            case 3:
//            case 5:
//            case 7:
//            case 8:
//            case 10:
//            case 12:
//                days = 31;
//                break;
//            case 4:
//            case 6:
//            case 9:
//            case 11:
//                days = 30;
//                break;
//            case 2:
//                if(((year%4 == 0 && year %100 != 0) ||year % 400 == 0) && month == 2) {
//                    days = 29;
//                } else {
//                    days = 28;
//                }
//        }
//        System.out.println("该月天数："+days);
//    }
//}
//

//public class PraDemo {
//    public static int minSubArrayLen(int target, int[] nums) {
//        if ( nums.length == 0) {
//            return 0;
//        }
//        int start = 0;
//        int sum = 0;
//        int result = Integer.MAX_VALUE;
//        for(int end = 0;end < nums.length;end++){
//            sum += nums[end];
//            while(sum >= target){
//                int len = end - start + 1;
//                result = Math.min(result,len);
//                sum -= nums[start++];
//            }
//        }
//        return result == Integer.MAX_VALUE ? 0 : result;
//    }
//    public static void main(String[] args) {
//       int[] nums = new int[]{2,3,1,2,4,3};
//       int ret =  minSubArrayLen(7, nums);
//        System.out.println(ret);
//        int tmp = Integer.MAX_VALUE;
//        System.out.println(tmp);
//    }
//}

//public class PraDemo {
//    public static void main(String[] args) {
//        int a = 10;
//        int b = 12;
//        System.out.println("!=");
//    }
//}publi

//public class PraDemo {
//    public static void main(String[] args) {
//
//    }
//}