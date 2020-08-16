package self;

import java.util.ArrayList;
import java.util.List;

/**
 * 各种排序
 * 稳定排序： 直接插入，折半插入，冒泡排序，归并排序
 * 时间复杂度：O(n^2):直接插入排序，简单选择排序，冒泡排序。
 * O(nlogn):快速排序，归并排序，希尔排序，堆排序。
 */
public class Sort {

    //直接插入排序
    public static int[] insertSort(int[] array){
        if(array == null || array.length == 0 || array.length == 1)
            return array;
        for(int i = 1; i < array.length; i++){
            for(int j = 0; j < i; j++){
                if(array[j] > array[i]){
                    int temp = array[i];
                    System.arraycopy(array, j, array, j + 1, i - j);
                    array[j] = temp;
                    break;
                }
            }
        }
        return array;
    }

    //折半插入排序
    public static int[] binaryInsertSort(int[] array){
        if(array == null || array.length == 0 || array.length == 1)
            return array;
        for(int i = 1; i < array.length; i++){
            int temp = array[i];
            int start = 0,end = i - 1;
            while(start <= end){
                int mid = (start + end)/2;
                if(array[mid] > temp)
                    end = mid - 1;
                else{
                    start = mid + 1;
                }
            }
            System.arraycopy(array, start, array, start + 1, i - start);
            array[start] = temp;
        }
        return array;
    }

    //希尔排序
    public static int[] shellSort(int[] array){
        if(array == null || array.length == 0 || array.length == 1)
            return array;
        int h = 1;
        int len = array.length;
        while(h <= len/3)
            h = h * 3 + 1;
        while(h >= 1){
            for(int i = h; i < len; i++){
                for(int j = i; j >= h && array[j] < array[j - h]; j -= h){
                    swap(array, j, j - h);
                }
            }
            h /= 3;
        }
        return array;
    }

    //简单选择排序
    public static int[] simpleSelectionSort(int[] array){
        if(array == null)
            return array;
        int len = array.length;
        for(int i = 0; i < len - 1; i++){
            for(int j = i + 1; j < len; j++){
                if(array[i] > array[j]){
                    swap(array, i, j);
                }
            }
        }
        return array;
    }

    //堆排序
    public static int[] heapSort(int[] array){
        if(array == null)
            return array;
        int len = array.length;
        for(int i = len - 1; i > 0; i--){
            for(int j = (i - 1)/2; j >= 0; j--){
                //存在节点只有一个叶子节点
                if((i == 2 * j + 1) && (i % 2) != 0 ){
                    if(array[j] < array[2 * j + 1]){
                        swap(array, j, 2 * j + 1);
                    }
                }
                else{
                    if(array[j] < array[2 * j + 1])
                        swap(array, j, 2 * j + 1);
                    if(array[j] < array[2 * j + 2])
                        swap(array, j, 2 * j + 2);
                }
            }
            swap(array, 0, i);
        }
        return array;
    }

    //冒泡排序
    public static int[] bubbleSort(int[] array){
        if(array == null)
            return array;
        int len = array.length;
        for(int i = len - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    //快速排序
    public static void quickSort(int[] array, int start, int end){
        if(array == null || (start == end))
            return ;
        int i = start + 1;
        int j = end;
        while(i < j){
            for(;array[i] < array[start] && i < j; i++);
            for(;array[j] > array[start] && j > i; j--);
            swap(array, i, j);
        }
        if(array[i] < array[start]){
            swap(array, i, start);
        }
        quickSort(array, 0, i - 1);
        quickSort(array, i, end);
    }

    //归并排序
    public static void mergeSort(int[] array, int low, int high){
        if(low < high){
            int mid = (low + high)/2;
            mergeSort(array, low ,mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }
    public static void merge(int[] array, int low ,int mid, int high){
        int temp[] = new int[array.length];
        int i = low, k = low;
        int j = mid + 1;
        while(i <= mid && j <= high){
            if(array[i] < array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }
        while(i <= mid){
            temp[k++] = array[i++];
        }
        while(j <= high){
            temp[k++] = array[j++];
        }
        while(low <= high){
            array[low] = temp[low++];
        }
    }

    //基数排序
    public static int[] radixSort(int[] array){
        if(array == null)
            return array;
        int max = 0,time = 0;
        int len = array.length;
        List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        //找出带排序中的最大值
        for(int i = 0; i < len; i++){
            if(max < array[i])
                max = array[i];
        }
        while(max > 0){
            max /= 10;
            time++;
        }
        //生成十个队列，List保证维护元素的次序
        for(int i = 0; i < 10; i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < time; i++){
            for(int j = 0; j < len; j++){
                int s = array[j] % (int)Math.pow(10, i+1) / (int)Math.pow(10, i);
                list.get(s).add(array[j]);
            }
            //调整
            int count = 0;
            for(int k = 0; k < 10; k++){
                ArrayList<Integer> alist = list.get(k);
                while(alist.size() > 0){
                    array[count++] = alist.remove(0);
                }
            }
        }
        return array;
    }
    public static int[] radixSort1(int[] array){
        //找到最大数，确定要排序几趟
        int max = 0;
        for (int i = 0; i < array.length; i++){
            if(max<array[i])
                max = array[i];
        }
        //判断位数
        int times = 0;
        while(max>0){
            max = max/10;
            times++;
        }
        //建立十个队列
        List<ArrayList<Integer>> alist = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++){
            ArrayList<Integer> queue = new ArrayList<Integer>();
            alist.add(queue);
        }
        //进行times次分配和收集
        for (int i = 0; i < times; i++){
            //分配
            for (int j = 0; j < array.length; j++){
                int x = array[j]%(int)Math.pow(10, i+1)/(int)Math.pow(10, i);
                alist.get(x).add(array[j]);
            }
            //收集
            int count = 0;
            for (int j = 0; j < 10; j++){
                ArrayList<Integer> queue = alist.get(j);
                while(queue.size()>0){
                    array[count++] = queue.remove(0);
                }
            }
        }
        return array;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
