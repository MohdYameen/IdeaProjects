package DSA;

import java.util.Stack;

public class ReverseStringUsingStack {

    public static String reverseUsingStack(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        //String newString = "";
        for(int i=0;i<s.length();i++){
            stringBuilder.append(stack.pop());
        }
       return stringBuilder.toString();

    }
    public static void main(String[] args) {
        String s = "yameen";
        System.out.println(s);
        //reverseUsingStack(s);
        String result = reverseUsingStack(s);
        System.out.println(result);

    }
}
