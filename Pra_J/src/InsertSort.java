import java.util.Arrays;

public class InsertSort {
    public void insertSort(int[] array){
        for(int i = 1;i<array.length;i++){
            int tmp = array[i];
            int j = i-1;
            for(;j>=0;j--){
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }else{
                    //array[j+1] = tmp;
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {5,4,9,8,3,2,1};
        InsertSort sort = new InsertSort();
        sort.insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
           