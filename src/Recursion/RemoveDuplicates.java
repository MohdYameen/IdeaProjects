package Recursion;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    //only a-z small alphabets

//    public static void removeDuplicates(String str, int i, StringBuilder sb, boolean [] map){
//        if(i == str.length()){
//            System.out.println(sb);
//            return;
//        }
//        if(map[str.charAt(i) - 'a'] == true){
//            removeDuplicates(str, i+1, sb, map);
//        } else {
//            map[str.charAt(i)-'a'] = true;
//            removeDuplicates(str, i+1, sb.append(str.charAt(i)), map);
//        }
//    }

    public static String removeDup(String s){
        Set<Character> seen = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(!seen.contains(c)){
                seen.add(c);
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static String removeDupFromSentence(String s){

        String [] sArray = s.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        Set<String> seen = new HashSet<>();

        for(String word : sArray){
            if(!seen.contains(word)){
                seen.add(word);
                sb.append(word+ " ");
            }
        }

        return sb.toString();

    }


    public static void main(String[] args) {
        String str = "apnacollege";
//        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);

        System.out.println(removeDup(str));

        String sentence = "This is new laptop and this has new mouse as well";
        System.out.println(removeDupFromSentence(sentence));

    }

}
