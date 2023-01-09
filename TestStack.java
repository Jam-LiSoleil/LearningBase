package DataStructure.com.linkedlist;

import java.util.Stack;

/**
 * @Author ljm~
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //入栈
        stack.add("jack");
        stack.add("smith");
        stack.add("sam");
       while (stack.size()>0){
           System.out.println(stack.pop());
       }
    }
}
