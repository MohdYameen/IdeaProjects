package Recursion;

public class RemoveDuplicates {

    //only a-z small alphabets

    public static void removeDuplicates(String str, int i, StringBuilder sb, boolean [] map){
        if(i == str.length()){
            System.out.println(sb);
            return;
        }
        if(map[str.charAt(i) - 'a'] == true){
            removeDuplicates(str, i+1, sb, map);
        } else {
            map[str.charAt(i)-'a'] = true;
            removeDuplicates(str, i+1, sb.append(str.charAt(i)), map);
        }
    }
    public static void main(String[] args) {
        String str = "apnacollege";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);

    }

}
