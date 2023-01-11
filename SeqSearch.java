package DataStructure.com.Search;

/**
 * @Author ljm~
 * @PackageName DataStructure.com.Search
 * @Time 2023/1/11-15:59
 */
public class SeqSearch {
    public static void main(String[] args){
        int arr[] = {1,9,11,-1,34,89};
        int index = seqSearch(arr,11);
        if (index==-1){
            System.out.println("没有查找到");
        }else {
            System.out.println(index);
        }

    }
    //这里线性查找是，找到一个就返回
    public static int seqSearch(int[] arr, int value){
        //线性查找是逐一比对，发现相同值就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }
}
