import java.util.Arrays;

public class ShellSort {
    /**
     * 希尔排序
     * @param array 排序数组
     * @param gap 每组间隔/组数
     */
    public static void shell(int[] array, int gap){
        for(int i = gap;i< array.length;i++){
            int tmp = array[i];
            int j = i-gap;
            for(;j>=0;j -= gap){
                if(array[j] > tmp){
                    array[j+gap] = array[j];
                }else{
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    /**
     * 时间复杂度：O(n^1.3 ~n^1.5)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * 判断技巧：如果在比较的过程中，没有发生跳跃式的交换，那么就是稳定的
     * @param array
     */
    public static void shellSort(int[] array){
        int gap = array.length;
        while(gap > 1){
            gap = gap /3 + 1;//+1是保证每组的最后一个序列是1，除几都行
            shell(array,gap);
        }
    }
    public static void main(String[] args) {
    }
}
