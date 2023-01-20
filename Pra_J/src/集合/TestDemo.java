package 集合;

import java.util.*;

public class TestDemo {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1998,"jill");
        map.put(1999,"nikita");
        map.put(2000,"zed");
        System.out.println(map);

        String ret = map.getOrDefault(2001,"jack");
        System.out.println(ret);

        System.out.println(map.containsKey(1998));

        Set<Map.Entry<Integer,String>>  entrySet =map.entrySet();

        for (Map.Entry<Integer,String> en:entrySet){
            System.out.println(en.getKey()+"<--->"+en.getValue());
        }
    }
    public static void main1(String[] args) {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(123);
        collection.add(111);

        collection.remove(111);

        Object[] array2 = collection.toArray();
        System.out.println(Arrays.toString(array2));
    }
}
