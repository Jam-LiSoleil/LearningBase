package DataStructure.com.Sort;

import java.util.Arrays;

/**
 * @Author ljm~
 * @PackageName DataStructure.com.Sort
 * @Time 2023/1/9-16:34
 */
public class InsertSort {
    public static void main(String[] args) {
//         int[] arr = {101,34,119,1};
         int[] arr = {1,2,3,4};
        System.out.println("未排序前:");
        System.out.println(Arrays.toString(arr));
        System.out.println("排序后:");
         insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //插入排序
    public static void insertSort(int[] arr){
        //逐步推导的方式
        //定义待插入的数
        int insertVal = 0;
        int insertIndex = 0;//arr[1]的前面这个数的下标
        for (int i = 1; i < arr.length ; i++) {
             insertVal = arr[i];
             insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal<arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //判断是否需要赋值重置
            if (insertIndex + 1 != i){
                arr[insertIndex + 1] = insertVal;
            }
        }
        //给insertVal找到插入的位置
        //insertVal<arr[insertIndex]说明待插入的数，还没找到插入位置
        //需要将insertIndex后移

    }
}
