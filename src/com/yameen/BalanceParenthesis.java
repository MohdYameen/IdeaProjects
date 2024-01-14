package com.yameen;

import java.util.Stack;

public class BalanceParenthesis {

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
    }
}