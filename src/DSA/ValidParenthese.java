package DSA;

import java.util.Stack;

public class ValidParenthese {

    public static boolean isParentheseBalanced(String str){
        Stack<Character> s = new Stack<>();
//        for(int i =0;i<str.length(); i++){
//            char ch = str.charAt(i);
//            if(ch == '(' || ch == '{' || ch == '['){
//                s.push(ch);
//            } else {
//                //closing
//                if(s.isEmpty()) return false;
//
//                if( (s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')){
//                    s.pop();
//                } else return false;
//
//            }
//        }

        for(char c : str.toCharArray()){
            if(c == '(' || c == '{' || c == '[') s.push(c);
            else if (c == ')' || c == '}' || c == ']'){
                if(s.isEmpty()) return false;
                char top = s.pop();
                if((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) return false;
            }
        }

        if(s.isEmpty()) {
            return true;
        } else{
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "((){}[])";
        System.out.println(isParentheseBalanced(str));

    }
}
