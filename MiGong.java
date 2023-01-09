package DataStructure.com.Recursion;

/**
 * @Author ljm~
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //将墙体置为1
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 7; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        //使用递归回溯找路
        findWay4(map,1,1);
        //输出新的地图
        System.out.println("找路");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
//        for (int i = 0; i < 4; i++) {
//            if (i==0){
//
//            }else if (i==1){
//
//            }else if (i==2){
//
//            }else {
//
//            }
//        }
    }

    /**
     * @param map 地图
     * @param i   从哪个位置开始找
     * @param j
     * @return 找到通路，返回true,否则返回false
     * 1代表墙体，2代表走的路，0代表没有走
     * 出发点map[1][1],重点map[6][5]
     * 行走的策略是，下->右→上→左
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                //按照策略走下->右→上→左
                map[i][j] = 2;//假定该点可以走通
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                //如果map[i][j] !=0,可能是1,2,3
                return false;
            }
        }
    }
    //下右上左
    public static boolean findWay1(int[][] map,int i, int j){
        int count1 = 0;
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j]==0){
                map[i][j]=2;
                if (findWay1(map,i+1,j)){
                    count1++;
                    return true;
                }else if (findWay1(map,i,j+1)){
                    count1++;
                    return true;
                }else if (findWay1(map,i-1,j)){
                    count1++;
                    return true;
                }else if (findWay1(map,i,j-1)){
                    count1++;
                    return true;
                }
                else {
                    map[i][j]=3;
                    return false;
                }
            }
            else {
                return false;
            }
        }
    }
    //左下右上
    public static boolean findWay2(int[][] map,int i, int j){
        int count2 = 0;
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j]==0){
                map[i][j]=2;
                if (findWay2(map,i,j-1)){
                    count2++;
                    return true;
                }else if (findWay2(map,i+1,j)){
                    count2++;
                    return true;
                }else if (findWay2(map,i,j+1)){
                    count2++;
                    return true;
                }else if (findWay2(map,i-1,j)){
                    count2++;
                    return true;
                }
                else {
                    map[i][j]=3;
                    return false;
                }
            }
            else {
                return false;
            }
        }
    }
    //上左下右
    public static boolean findWay3(int[][] map,int i, int j){
        int count3 = 0;
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j]==0){
                map[i][j]=2;
                if (findWay3(map,i-1,j)){
                    count3++;
                    return true;
                }else if (findWay3(map,i,j-1)){
                    count3++;
                    return true;
                }else if (findWay3(map,i+1,j)){
                    count3++;
                    return true;
                }else if (findWay3(map,i,j+1)){
                    count3++;
                    return true;
                }
                else {
                    map[i][j]=3;
                    return false;
                }
            }
            else {
                return false;
            }
        }
    }
    //右上左下
    public static boolean findWay4(int[][] map,int i, int j){
        int count4 = 0;
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j]==0){
                map[i][j]=2;
                if (findWay4(map,i,j+1)){
                    count4++;
                    return true;
                }else if (findWay4(map,i-1,j)){
                    count4++;
                    return true;
                }else if (findWay4(map,i,j-1)){
                    count4++;
                    return true;
                }else if (findWay4(map,i+1,j)){
                    count4++;
                    return true;
                }
                else {
                    map[i][j]=3;
                    return false;
                }
            }
            else {
                return false;
            }
        }
    }
}
