import java.util.Arrays;
import java.util.Stack;
//
///**
// * 递归方法快排
// */
//public class QuickSort {
//    /**
//     * 挖坑法
//     * @param array
//     * @param low
//     * @param high
//     * @return
//     */
//    public static int partition(int[] array,int low,int high){
//        int tmp = array[low];
//        while(low < high){
//            while(low<high && array[high] >= tmp){
//                high--;
//            }
//            array[low] = array[high];
//            while (low < high &&array[low] <= tmp){
//                low++;
//            }
//            array[high] = array[low];
//        }
//        array[low] = tmp;
//        return low;
//    }
//    public static void swap(int[] array,int i,int j){
//        int tmp = array[i];
//        array[i] = array[j];
//        array[j] = tmp;
//    }
//    public static void selectPivotMedianOfThree(int[] array,int start,int end,int mid){
//        //array[mid] <= array[start] <= array[end]
//        if(array[start] < array[mid]){
//           swap(array,start,mid);
//        }
//        if(array[end] < array[start]){
//             swap(array,end,start);
//        }
//        if(array[end] < array[mid]){
//            swap(array,end,mid);
//        }
//    }
//
//    public static void insertSort2(int[] array,int start,int end){
//        for(int i = start+1;i<=end;i++){
//            int tmp = array[i];
//            int j = i-1;
//            for(;j>=start;j--){
//                if(array[j] > tmp){
//                    array[j+1] = array[j];
//                }else{
//                    break;
//                }
//            }
//            array[j+1] = tmp;
//        }
//    }
//
//    public static void quick(int[] array,int start,int end){
//        if(start >= end){
//            return;
//        }
//
//        if(end - start <= 100){
//            insertSort2(array,start,end);
//            return;
//        }
//
//        int mid = (start+end)/2;
//        selectPivotMedianOfThree(array,start,end,mid);
//        int pivot = partition(array,start,end);
//        quick(array,start,pivot-1);
//        quick(array,pivot+1,end);
//    }
//
//    /**
//     * 时间复杂度：最好O(n*log2^n) 均匀分割下
//     *          最坏O(n^2) 数据有序下
//     * 空间复杂度：最好O(log2^n)
//     *          最坏O(n)
//     * 稳定性：不稳定
//     * @param array
//     */
//    public static void quickSort1(int[] array){
//        quick(array,0,array.length-1);
//    }
//
//    public static void main(String[] args) {
//        int[] array = {58,45,12,34,68,48,98,11,21};
//        quickSort1(array);
//        System.out.println(Arrays.toString(array));
//    }
//}


/**
 * 非递归方法快排
 */
public class QuickSort {
    /**
     * 挖坑法
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] array,int low,int high){
        int tmp = array[low];
        while(low < high){
            while(low<high && array[high] >= tmp){
                high--;
            }
            array[low] = array[high];
            while (low < high &&array[low] <= tmp){
                low++;
            }
            array[high] = array[low];
        }
        array[low] = tmp;
        return low;
    }
    public static void swap(int[] array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void selectPivotMedianOfThree(int[] array,int start,int end,int mid){
        //array[mid] <= array[start] <= array[end]
        if(array[start] < array[mid]){
            swap(array,start,mid);
        }
        if(array[end] < array[start]){
            swap(array,end,start);
        }
        if(array[end] < array[mid]){
            swap(array,end,mid);
        }
    }

    public static void insertSort2(int[] array,int start,int end){
        for(int i = start+1;i<=end;i++){
            int tmp = array[i];
            int j = i-1;
            for(;j>=start;j--){
                if(array[j] > tmp){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    public static void quick(int[] array,int start,int end){
        if(start >= end){
            return;
        }

        if(end - start <= 100){
            insertSort2(array,start,end);
            return;
        }

        int mid = (start+end)/2;
        selectPivotMedianOfThree(array,start,end,mid);
        int pivot = partition(array,start,end);
        quick(array,start,pivot-1);
        quick(array,pivot+1,end);
    }

    /**
     * 时间复杂度：最好O(n*log2^n) 均匀分割下
     *          最坏O(n^2) 数据有序下
     * 空间复杂度：最好O(log2^n)
     *          最坏O(n)
     * 稳定性：不稳定
     * @param array
     */
    public static void quickSort2(int[] array){
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int end = array.length-1;

        int pivot = partition(array,start,end);
        if(pivot>start+1){
            stack.push(0);
            stack.push(pivot-1);
        }

        if(pivot < end -1){
            stack.push(pivot+1);
            stack.push(end);
        }

        while(!stack.empty()){
            end = stack.pop();
            start = stack.pop();
            pivot = partition(array,start,end);
            if(pivot>start+1){
                stack.push(0);
                stack.push(pivot-1);
            }

            if(pivot < end -1){
                stack.push(pivot+1);
                stack.push(end);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {58,45,12,34,68,48,98,11,21};
        quickSort2(array);
        System.out.println(Arrays.toString(array));
    }
}

