package DataStructure.com.Queue;

import java.util.Scanner;

/**
 * @Author ljm~
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列");
        //环形队列
        CircleArray arrayQueue = new CircleArray(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)显示队列");
            System.out.println("e(exit)退出程序");
            System.out.println("a(add)添加数据到队列");
            System.out.println("g(get)从队列取出数据");
            System.out.println("h(head)查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':

                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
            System.out.println("程序退出");
        }
    }
}
class CircleArray{
    private int maxSize;//数组最大含量
    private int front;//指向队列头部
    private int rear;//队列尾
    private int[] arr; //模拟队列，用于存储数据
    public CircleArray(int arrMaxsize){
        maxSize = arrMaxsize;
        arr = new int[maxSize];
        front=0;
        rear=0;
    }
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
    public boolean isEmpty(){
        return rear==front;
    }
    //添加队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
      arr[rear] = n;
        rear = (rear+1) %maxSize;
    }
    //取出数据
    public int getQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            throw new RuntimeException("队列为空，不能取数据");
        }
       //分析出front是指向队列的第一个元素
        /**
         * 1.先把front保留到一个临时变量
         * 2.将front后移
         * 3.将临时保存的变量返回
         */
        int value = arr[front];
        front=(front+1)%maxSize;
        return value;
    }
    //显示所有队列数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[ i % maxSize]);
        }
    }
    //求出当前队列有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }
    //显示队列的头部数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }

}
