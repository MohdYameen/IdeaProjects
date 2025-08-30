package com.yameen;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalanceParenthesis {

//    private static final Map<Character, Character> PAIRs = Maps.of();

    private static final Map<Character, Character> PAIRS = new HashMap<>();
    static {
        PAIRS.put(')', '(');
        PAIRS.put(']', '[');
        PAIRS.put('}', '{');
    }

    public static boolean isBalanced(String s){
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='('||c=='{'||c=='[')
                stack.push(c);
            else if (c==')'||c=='}'||c==']'){
                if(stack.size()==0 || stack.pop() != PAIRS.get(c))
                    return false;
            }
        }
        return true;
    }

    public static void main(String ... args){
        String s = "((){})";
        Stack<Character> mystack = new Stack<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                mystack.push(ch);
            }
            else if(ch == ')'){
                if(mystack.size() == 0){
                    System.out.println(false);
                    return;
                }
                else if( ch == '{' || ch == '['){
                    System.out.println(false);
                    return;
                }
                else{
                    mystack.pop();
                }

            }
            else if(ch == '}'){
                if(mystack.size() == 0){
                    System.out.println(false);
                    return;
                }
                else if( ch == '(' || ch == '{'){
                    System.out.println(false);
                    return;
                }
                else{
                    mystack.pop();
                }
            }
            else if(ch == ']'){
                if(mystack.size() == 0){
                    System.out.println(false);
                    return;
                }
                else if( ch == '{' || ch == '('){
                    System.out.println(false);
                    return;
                }
                else{
                    mystack.pop();
                }

            }

        }
        if(mystack.size()==0){
            System.out.println(true);
        }
        else
            System.out.println(false);


        System.out.println("New easy approach");
        System.out.println(isBalanced(s));
    }
}