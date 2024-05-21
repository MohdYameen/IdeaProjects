package DSA;

import java.util.Stack;

public class ReverseStack {

    public static void pushAtBottom(Stack<Integer> stack, int data){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);
    }

    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int top = stack.peek();
        stack.pop();
        reverseStack(stack);
        pushAtBottom(stack, top);
    }
    public static void printStack(Stack<Integer> stack){
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        //printStack(stack);

        System.out.println("Reverse");
        reverseStack(stack);
        printStack(stack);


    }
}
