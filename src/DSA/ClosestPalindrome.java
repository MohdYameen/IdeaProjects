package DSA;

public class ClosestPalindrome {

    static boolean isPalindrome(String str){
        int left = 0;
        int right = str.length()-1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    static int closestPalindrome(int n){
        int lowerP = n-1;
        int higherP = n+1;
        while (!isPalindrome(Integer.toString(lowerP))){
            lowerP--;
        }
        while (!isPalindrome(Integer.toString(higherP))){
            higherP++;
        }
//        System.out.println("lower P "+ lowerP);
//        System.out.println("higher P "+ higherP);
        if( Math.abs(n - lowerP) > Math.abs(n-higherP) ) return higherP;
        else return lowerP;

    }


    public static void main(String[] args) {
        int n =217;
        //System.out.println(isPalindrome("abc"));
        System.out.println(closestPalindrome(n));

    }
}
