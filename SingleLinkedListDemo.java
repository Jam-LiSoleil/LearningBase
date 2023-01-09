package DataStructure.com.linkedlist;


import java.util.Stack;

/**
 * @Author ljm~
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //创建节点
        HeroNode h1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode h2 = new HeroNode(4, "小明", "aaa");
        HeroNode h3 = new HeroNode(2, "小红", "bbb");
        HeroNode h4 = new HeroNode(5, "小丁", "ccc");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(h1);
        singleLinkedList.addByOrder(h2);
        singleLinkedList.addByOrder(h3);
        singleLinkedList.addByOrder(h4);
        singleLinkedList.list();
//        System.out.println("删除id");
//        singleLinkedList.del(2);
//        singleLinkedList.list();
//        System.out.println(getLength(singleLinkedList.getHead()));

        /**
         * 测试是否得到倒数第k个节点
         */
//        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 4);
//        System.out.println(res);
         reverseList(singleLinkedList.getHead());
        System.out.println("翻转过后");
         singleLinkedList.list();
        System.out.println("倒叙打印");
        reversePrint(singleLinkedList.getHead());
    }
    /**
     * 查找单链表的倒数第k个节点[新浪面试题]
     * 1.编写方法,接收head节点，接收一个index
     * 2.index表示倒数index个节点
     * 3.先把链表从头到尾遍历,得到总长度
     * 4.得到size后，我们从链表的第一个开始遍历，遍历(size - index)个
     */


    /**
     * 单链表进行反转
     *
     */
    public static void reverseList(HeroNode head){
        if (head.next == null || head.next.next==null){
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        while (cur!=null){
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;

    }

    /**
     * 获取单链表节点个数,带头节点,不统计头结点
     * @param head
     * @return
     */
    public static int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur !=null){
            length++;
            cur = cur.next;
        }
        return length;

    }
    public static HeroNode findLastIndexNode(HeroNode head , int index){
        if (head.next == null){
            return null;
        }
        int size = getLength(head);
        if (index<=0||index>size){
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }
    /**
     * 使用栈来进行逆序打印
     */
    public static void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将链表所有节点压入栈中
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }

    }
}

class SingleLinkedList {
    //初始化头节点
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    //添加节点到单向链表
    //1.找到当前链表最后节点
    //2.将最后节点的next指向新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动，我们需要一个辅助变量temp
       HeroNode temp = head;
        //遍历链表
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //当退出while循环时， temp就指向链表最后
        temp.next = heroNode;
    }

    /**
     * 第二种添加方法，按照id来加
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
               boolean flag = false;
               while (true){
                   if (temp.next==null){
                       break;
                   }
                   if (temp.next.id > heroNode.id){
                       //说明找到了
                       flag = true;
                       break;
                   }
                   if (temp.next.id == heroNode.id){
                       System.out.println("有相同id，无法添加");
                       break;
                   }
                   temp = temp.next;
               }
               if (flag=true){
                   heroNode.next = temp.next;
                   temp.next = heroNode;
               }else {
                   System.out.println("无法添加");
               }
    }

    //显示链表[遍历链表]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //头节点不能动，需要一个辅助变量来遍历
       HeroNode temp = head.next;
        while (true) {
            //判断链表是否到最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }

    }

    /**
     * 1.修改节点的信息，根据id来进行修改
     * 2.根据newHeroNode的id来进行修改
     */
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
       HeroNode temp = head.next;
        boolean flag = false;//表示是否找到
        while (true) {
            if (temp == null) {
                System.out.println("链表遍历完毕");
                break;
            }
            if (temp.id == newHeroNode.id) {
                //找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号%d节点，不能修改\n", newHeroNode.id);
        }
    }

    /**
     * 删除节点
     * 1.head节点不动
     * 2.需要temp辅助节点,temp.next.no与需要删除的no进行比较
     */
    public void del(int id) {
        HeroNode temp = head;
        boolean flag = false;//表示是否找到
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("并未找到%d", id);
        }
    }

}

class HeroNode {
    public int id;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示方便，重写toString方法


    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
