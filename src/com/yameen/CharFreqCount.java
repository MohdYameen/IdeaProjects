package com.yameen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharFreqCount {

    public static boolean freqChecker(String s){
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c: s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
        }

        //  check size of map always be 4, not more not less
        if(freqMap.size() != 4) return false;

        // insert all values to a set, if alll values are same, set size will be 1
        Set<Integer> sameFreq = new HashSet<>(freqMap.values());
        return sameFreq.size() == 1;
    }

    public static int firstNonRepeatingChar(String s){
        Map<Character, Integer> hashMap = new HashMap<>();

        for(char c: s.toCharArray()){
            hashMap.put(c, hashMap.getOrDefault(c, 0)+1);
        }

        int index = 0;
        for(char c: s.toCharArray()){
            if(hashMap.get(c)==1){
                System.out.println("char : "+c);
                return index;
            }
            index++;
        }

        return -1;
    }

    public static int findFirstNonRCI(String s){
        Map<Character, Long> map = s.chars()
                .mapToObj(c-> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.value+" ");
        inOrder(root.right);
    }

    public static TreeNode leftRot(TreeNode root){
        if(root== null || root.right == null){
            return root;
        }

        TreeNode y = root.right;
        TreeNode temp = y.left;

        y.left = root;
        root.right = temp;

        return y;
    }

    public static void main(String[] args) {
        String s = "abcdadcbadbkc";
        System.out.println(freqChecker(s));
        System.out.println(firstNonRepeatingChar(s));
        System.out.println(findFirstNonRCI(s));

//        TreeNode root = new TreeNode(10);
//        root.right = new TreeNode(20);
//
//        inOrder(root);
//
//        System.out.println("after left rot");
//        inOrder(leftRot(root));



    }
}

class TreeNode{
    int value;
    TreeNode left, right;

    public TreeNode(int value){
        this.value = value;
    }
}
