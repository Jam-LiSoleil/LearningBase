package DataStructure.com.linkedlist.DoubleLinkedList;




/**
 * @Author ljm~
 */
@SuppressWarnings({"all"})
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 h1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 h2 = new HeroNode2(4, "小明", "aaa");
        HeroNode2 h3 = new HeroNode2(2, "小红", "bbb");
        HeroNode2 h4 = new HeroNode2(5, "小丁", "ccc");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(h1);
//        doubleLinkedList.add(h2);
//        doubleLinkedList.add(h3);
//        doubleLinkedList.add(h4);
//        doubleLinkedList.list();

        doubleLinkedList.addByOrder(h1);
//        doubleLinkedList.addByOrder(h2);
//        doubleLinkedList.addByOrder(h3);
//        doubleLinkedList.addByOrder(h4);
        doubleLinkedList.list();
//        HeroNode2 h5 = new HeroNode2(2, "小白", "ddd");
//        doubleLinkedList.update(h5);
//        doubleLinkedList.list();
//        System.out.println("删除");
//        doubleLinkedList.del(5);
//        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 遍历链表的方法
     */

    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //头节点不能动，需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
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
     * 添加
     */
    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，我们需要一个辅助变量temp
        HeroNode2 temp = head;
        //遍历链表
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //当退出while循环时， temp就指向链表最后
        //形成双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    //修改一个节点的内容
    /**
     * 第二种添加方法，按照id来加
     */
    public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        boolean flag = false;
        while (true){
            if (temp.next==null){
                flag=true;
                break;
            }
            if (temp.next.id > heroNode.id){
                //说明找到了
                flag = true;
                break;
            }
            if (temp.id == heroNode.id){
                System.out.println("有相同id，无法添加");
                break;
            }
            temp = temp.next;
        }
        if (flag==true){//先判断heroNode的id是不是最大，是不是最后一个
         heroNode.next = temp.next;
         if (temp.next !=null){
             temp.next.pre = heroNode;
         }
         temp.next = heroNode;
         heroNode.pre = temp;
        }else {
            System.out.println("无法添加");
        }
    }
    /**
     * 1.修改节点的信息，根据id来进行修改
     * 2.根据newHeroNode的id来进行修改
     */
    public void update(HeroNode2 newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
        HeroNode2 temp = head.next;
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
     * 删除节点，双向链表可以直接找到节点
     * 1.head节点不动
     * 2.需要temp辅助节点,temp.next.no与需要删除的no进行比较
     */
    public void del(int id) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;//表示是否找到
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {//需要判断是否为最后一个节点
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }

        } else {
            System.out.printf("并未找到%d", id);
        }
    }
}

class HeroNode2 {
    public int id;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个节点
    public HeroNode2 pre;//指向前一个结点

    public HeroNode2(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示方便，重写toString方法


    @Override
    public String toString() {
        return "HeroNode2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

