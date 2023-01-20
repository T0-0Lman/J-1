package StringDemo;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class PraDemo {
    public static void main1(String[] args) {
        String string1 = "hello";
        String string2 = new String("hello");
        char[] chs = {'h', 'e', 'l', 'l', 'o'};
        String string3 = new String(chs);

//        System.out.println(string1);
//        System.out.println(string2);
//        System.out.println(string3);
        //比较引用的地址
        System.out.println(string1 == string2);
        //比较引用里面的内容
        System.out.println(string1.equals(string2));
    }

    public static void main2(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        System.out.println(str1 == str2);
        //编译时这个地方相当于String str3 = "hello";
        String str3 = "he" + "llo";
        System.out.println(str1 == str3);

        String str4 = "he";
        String str5 = "llo";
        String str6 = str4 + str5;
        System.out.println(str1 == str6);

        String str7 = "he" + new String("llo");
        System.out.println(str1 == str7);
    }

    public static void main3(String[] args) {
        String str1 = "hello";
        String str2 = str1;
        System.out.println(str1);
        System.out.println(str2);

        str1 = "zengcool";
        System.out.println(str1);
        System.out.println(str2);
    }

    public static void main4(String[] args) {
        String str = null;
        //方式一 可能会出现空指针异常的情况
        //System.out.println(str.equals("hello"));
        //方式二
        System.out.println("hello".equals(str));
    }

    public static void main5(String[] args) {
        //false
//        String str1 = "hello";
//        String str2 = new String("hello");
//        System.out.println(str1 == str2);
        //true
        String str1 = "hello";
        //手动入池
        String str2 = new String("hello").intern();
        System.out.println(str1 == str2);
    }

    public static void main6(String[] args) {

        char[] chs = {'h', 'e', 'l', 'l', 'o'};
        String str1 = new String(chs, 1, 3);
        System.out.println(chs);

        String str2 = "hello";
        char ch = str2.charAt(1);
        System.out.println(ch);

        char[] chars = str1.toCharArray();
        System.out.println(Arrays.toString(chars));
    }

    public static void main7(String[] args) throws UnsupportedEncodingException {
        //将字节数组转变为字符串
//        byte[] bytes = {97,98,99,100};
//        String str = new String(bytes);
//        System.out.println(str);

        //将部分数组字节中的内容变为字符串
//        byte[] bytes = {97,98,99,100};
//        String str = new String(bytes,1,3);
//        System.out.println(str);
        //将字符串以字节数组的形式返回
//        String str = "abcd";
//        byte[] bytes = str.getBytes();
//        System.out.println(Arrays.toString(bytes));

//        String str = "路虽遥疾风归";
//        byte[] bytes = str.getBytes("utf-8");
//        System.out.println(Arrays.toString(bytes));

        String str = "路虽遥疾风归";
        byte[] bytes = str.getBytes("GBK");
        System.out.println(Arrays.toString(bytes));
    }

    public static void main8(String[] args) {
        String str1 = new String("1");
        String str2 = "1";
        str1.intern();
        System.out.println(str1 == str2);
    }

    public static void main9(String[] args) {
        String str1 = new String("1") + new String("1");
        str1.intern();
        String str2 = "11";
        System.out.println(str1 == str2);
    }

    public static void main10(String[] args) {
        String str1 = new String("11").intern();
        //str1 = str1.intern();
        //str1.intern();
        String str2 = "11";
        System.out.println(str1 == str2);
    }

    public static void main11(String[] args) {
        String str1 = new String("hello");
        String str2 = "hello";
        String str3 = "Hello";

        System.out.println(str1 == str2);//比较字符串地址
        System.out.println(str1.equals(str2));//比较字符串内容
        System.out.println(str2.equalsIgnoreCase(str3));//忽略大小写比较
        System.out.println(str2.compareTo(str3));//比较字符串的大小写
    }

    public static void main12(String[] args) {
//        String str1 = "abdfe";
//        //contains方法
//        boolean flg = str1.contains("abcd");
//        System.out.println(flg);


    }

    public static void main13(String[] args) {
        String str = "asabccbd";
        int index = str.indexOf("abc", 4);
        System.out.println(index);
    }

    public static void main14(String[] args) {
        String str = "asabccbd";
        int index = str.lastIndexOf("abc", 5);
        System.out.println(index);
    }

    public static void main15(String[] args) {
        String str = "absdfae";
        boolean temp = str.startsWith("ab");
        System.out.println(temp);
    }

    public static void main16(String[] args) {
        String str = "absdfae";
        boolean temp = str.endsWith("ae");
        System.out.println(temp);
    }

    public static void main17(String[] args) {
        String str = "sabfafasdabs";
        String ret = str.replaceAll("ab", "AB");
        System.out.println(ret);
    }

    public static void main18(String[] args) {
        String str = "abfafasdabs";
        String ret = str.replaceFirst("ab", "AB");
        System.out.println(ret);
    }

    public static void main19(String[] args) {
        String str = "never late";
        String[] strs = str.split(" ");
        for (String s : strs) {
            System.out.println(s);
        }
    }

    public static void main20(String[] args) {
        String str = "192.168.1.1";
        String[] strs = str.split(" \\.");
        for (String s : strs) {
            System.out.println(s);
        }
    }

    public static void main21(String[] args) {
        String str = "192\\168\\1\\1";
        String[] strs = str.split(" \\\\");
        for (String s : strs) {
            System.out.println(s);
        }
    }

    public static void main22(String[] args) {
        String str = "Java20-split#2";
        String[] strs = str.split(" -|#");
        for (String s : strs) {
            System.out.println(s);
        }
    }

    public static void main23(String[] args) {
        String str = "ababcebrara";
        System.out.println(str.substring(3,4));
    }

    public static String reverse(String str){
        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while(i<j){
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return new String(chars);
        //return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要逆转的字符串");
        String str  = scanner.nextLine();
        String ret = reverse(str);
        System.out.println(ret);
    }

}
