package Backtrack;

public class SubsetString {

    public static void printSubsetOfString(String str, String ans, int i){

        if(i == str.length()){
            System.out.println(ans);
            return;
        }
        //Yes choice
        printSubsetOfString(str, ans+str.charAt(i), i+1);
        //No choice
        printSubsetOfString(str, ans, i+1);

    }

    public static void main(String[] args) {
        String str = "abcd";
        printSubsetOfString(str, "", 0);
    }
}
