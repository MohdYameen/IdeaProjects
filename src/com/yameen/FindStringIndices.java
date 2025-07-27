package com.yameen;

import java.util.ArrayList;
import java.util.List;

public class FindStringIndices {

    public static List<Integer> findIdn(String text, String word){
//        List<Integer> indices = new ArrayList<>();
//        int textLength = text.length();
//        int wordLength = word.length();
//
//        for(int i=0 ; i<textLength - wordLength;i++){
//            boolean found = true;
//            for(int j=0;j<wordLength;j++){
//                if(text.charAt(i+j) != word.charAt(j)){
//                    found = false;
//                    break;
//                }
//            }
//            if(found){
//                indices.add(i);
//            }
//        }
//        return indices;

        List<Integer> indices = new ArrayList<>();
        int textLength = text.length();
        int wordLength = word.length();

        for (int i = 0; i <= textLength - wordLength; i++) {
            boolean found = true;

            for (int j = 0; j < wordLength; j++) {
                if (text.charAt(i + j) != word.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                indices.add(i);
            }
        }

        return indices;
    }

    public static void main(String[] args) {

        String text = "the try fox jumped over the other fox in the try fores";
        String word = "try";

        List<Integer> result = findIdn(text, word);
        System.out.println("Occurrences of \"" + word + "\" found at indices: " + result);

    }
}
