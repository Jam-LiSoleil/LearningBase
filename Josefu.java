package DataStructure.com.linkedlist;

/**
 * @Author ljm~
 */
public class Josefu {
    public static void main(String[] args){
        CircleSingleList circleSingleList = new CircleSingleList();
        circleSingleList.addBoy(5);
        circleSingleList.list();
        circleSingleList.countBoy(1,2,5);
    }

}
class CircleSingleList{
    private Boy first = null;
    public void addBoy(int nums){
        //nums代表需要添加多少个小孩
        if (nums<1){
            System.out.println("数据不正确");
            return;
        }
        Boy curBoy = null;//辅助指针
        for (int i = 1; i <= nums; i++) {
          Boy boy = new Boy(i);
          if (i==1){
              first = boy;
              first.setNext(first);
              curBoy = first;
          }else {
              curBoy.setNext(boy);
              boy.setNext(first);
              curBoy = boy;
          }

        }
    }

    /**
     * 遍历环形列表
     */
    public void list(){
        Boy curBoy = first;
        if (first==null){
            System.out.println("该环形链表为空");
            return;
        }
        while (true){
            System.out.printf("小孩的编号%d\n",curBoy.getNo());
            if (curBoy.getNext()==first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     *
     * @param startNum 从第几个小孩开始
     * @param countNum 数几次
     * @param nums 一共有几个小孩
     */
    public void  countBoy(int startNum, int countNum, int nums){
        if (startNum>nums || startNum<1 || first==null){
            System.out.println("输入的数据不合理，请重新输入");
            return;
        }
        //创建一个辅助变量，帮助小孩出圈
        Boy helper = first;
        //让辅助变量指向链表的最后
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        //在小孩移动前，先让指针指到确定的位置
        for (int i = 0; i < startNum - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //开始出圈
        while (true){
            if (helper == first){
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n",first.getNo());
            first = first.getNext();
            helper.setNext(first);

        }
        System.out.printf("留在圈中的小孩%d",first.getNo());
    }

}
//遍历环形链表

class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
