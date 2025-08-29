package DSA;

public class CompareBinaryToHexa {

    public static boolean compareBinToHex(String binary, String hex){
        int n1 = convertFromBasetoDecimal(binary,2);
        int n2 = convertFromBasetoDecimal(hex, 16);
        if(n1<0||n2<0) return false;
        return n1 == n2;
    }

    public static int convertFromBasetoDecimal(String number, int base){
        if(base < 2 || (base >10 && base != 16)) return -1;

        int value = 0;
        for(int i=number.length()-1; i>=0;i--){
            int digit = digitToValue(number.charAt(i));
            if(digit < 0 || digit >= base) return -1;
            int exp = number.length()-i-1;
            value += digit * Math.pow(base, exp);
        }
        return value;
    }

    public static int digitToValue(char c){
        int a = c - '0';
        for(int i=0; i<=9; i++){
            if(a == i) return a;
        }
        return -1;
    }

    public static int intToBinary(int n){
        String s= "";
        while(n != 0){
            if(n%2==1){
                s+='1';
//                System.out.println("adde 1");
            }
            else
                s+='0';

            n/=2;
        }

        // s string reverse it to get binary value

        int sol = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '0')
                sol++;
        }

        return sol;


    }


    public static void main(String[] args) {
//        System.out.println(digitToValue('7'));
//        //System.out.println(convertFromBasetoDecimal("1111", 16));
//
//        // both string in decimal are equals to 22.
//        System.out.println(compareBinToHex("10110", "16"));
        System.out.println("int to binary : "+intToBinary(8));
    }
}
