package DataStructure.com.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author ljm~
 */
public class BubbleSort {
    public static void main(String[] args){
//        int[] arr = {3,9,-1,10,20};
//        System.out.println("排序前");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + "\t");
//        }
//        System.out.println();
        A a = new A();
//        a.sortWay(arr);
//        System.out.println("排序后");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + "\t");
//        }
        int[] arr = new  int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() *800000);
       }
//        System.out.println(Arrays.toString(arr));

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date);
        System.out.println("冒泡排序前的时间是:" + date1Str);
        a.sortWay(arr);
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("冒泡排序后的时间是:" + date2Str);


    }

}
class A{
    public int[] sortWay(int[] arr1){
        int temp = 0;
        //按降序排列
        //创建一个标识符，用来确定是否需要进行交换
        boolean flag = false;
        for (int i = 0; i < arr1.length - 1; i++) {
            for (int j = 0; j < arr1.length - 1 - i; j++) {
                if (arr1[j] > arr1[j+1]){
                    flag = true;
                    temp = arr1[j + 1];
                    arr1[j + 1] = arr1[j];
                    arr1[j] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
//                System.out.println("第" + (i + 1) + "趟排序的数组" + Arrays.toString(arr1));
                flag = false; //重置flag,进行下次交换
            }
        }
        return arr1;
    }
}
