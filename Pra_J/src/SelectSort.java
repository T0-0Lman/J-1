import java.util.Arrays;

public class SelectSort {
    /**
     * 时间复杂度：O(n^2)。
     * 空间复杂度：O(1)。
     * 稳定性：不稳定
     * @param array
     */
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for(int j = i+1;j<array.length;j++){
                if(array[j] < array[i]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {58,45,12,34,68,48,98,11,21};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
