package DataStructure.com.Sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author ljm~
 * @PackageName DataStructure.com.Sort
 * @Time 2023/1/9-15:37
 */
public class SelectSort {
    public static void main(String[] args){
        //选择排序
//        int[] arr = {101, 34, 119, 1, -1, 90,123};
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
//        System.out.println("排序后");
        int[] arr = new  int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() *800000);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date);
        System.out.println("选择排序前的时间是:" + date1Str);

        selectSort(arr);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("选择排序后的时间是:" + date2Str);





    }
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
           int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                    //重置最小值
                }
            }
            if (minIndex !=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
//            System.out.println("第" + (i+1) + "轮后:" + Arrays.toString(arr));
        }
    }
}
