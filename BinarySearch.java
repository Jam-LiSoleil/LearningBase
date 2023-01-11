package DataStructure.com.Search;

import java.util.ArrayList;

/**
 * @Author ljm~
 * @PackageName DataStructure.com.Search
 * @Time 2023/1/11-16:10
 */
public class BinarySearch {
    public static void main(String[] args) {
        /**
         * 二分查找算法，应该是从小到大
         */
        int arr[] = {1, 8, 10, 89, 1000,1000,1234};
//        int resIndex = binarySearch(arr, 0, arr.length - 1, 1000);
//        System.out.println(resIndex);
        ArrayList<Object> list = new ArrayList<>();
        list =   binarySearch2(arr,0,arr.length-1,1000);
        System.out.println(list);
    }

    /**
     * @param arr     数组
     * @param left    左索引
     * @param right   右索引
     * @param findVal 查找的值
     * @return 如果找到就返回下标，没找到就返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        int midVal = arr[mid];
        if (findVal > midVal) {
            //从小到大，向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    public static ArrayList binarySearch2(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int midVal = arr[mid];
        if (findVal > midVal) {
            //从小到大，向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            //扫描mid的左边，将重复的元素，添加到集合中
            ArrayList<Integer> arrayList = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                arrayList.add(temp);
                temp--;
            }
            arrayList.add(mid);
            //扫描mid右边，将重复元素，添加到集合中
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                arrayList.add(temp);
                temp++;
            }
             return arrayList;
        }


    }

}
