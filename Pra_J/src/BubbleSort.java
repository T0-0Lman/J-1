import java.util.Arrays;

public class BubbleSort {
    /**
     * 时间复杂度：未优化 O(n^2) 优化后 有序的情况下 O(n)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @param array
     */
    public static void bubbleSort(int[] array){
        for(int i = 0;i<array.length-1;i++){
            boolean flg = false;
            for(int j = 0;j<array.length-1-i;j++){
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if(flg == false){
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {58,45,12,34,68,48,98,11,21};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
