package DataStructure.com.Sparearray01;

/**
 * @Author ljm~
 */
public class SparseArray {
    public static void main(String[] args) {
        //1表示黑子，2表示蓝子
        //a和b
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 3;
        //输出原始的二维数组,i是行,j是列
        System.out.println("原始的二维数组:");
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                System.out.print(chessArr1[i][j] + "\t");
            }
            System.out.println();
        }
        //1.将二维数组转为稀疏数组
        //先遍历二维数组,拿到非0的量
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
//        System.out.println(sum);
        //2.创建对应的稀疏数组
        int sparseArray[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //存放非零数据(遍历二维数组)
        int temp01 = 1;//计数，表示稀疏数组第temp01行
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArray[temp01][0] = i;//给row赋值
                    sparseArray[temp01][1] = j;//给col赋值
                    sparseArray[temp01][2] = chessArr1[i][j];//给val赋值
                    temp01++;
                }
            }
        }
        System.out.println("稀疏数组:");
        for (int i = 0; i <sparseArray.length ; i++) {
            for (int j = 0; j <sparseArray[i].length ; j++) {
                System.out.print(sparseArray[i][j] + "\t");
            }
            System.out.println();
        }
        //将稀疏数组还原为初始数组

        int[][] arr2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
           arr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("还原后的初始数组:");
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length ; j++) {
                System.out.print(arr2[i][j] + "\t");
            }
            System.out.println();


        }
    }
}
