package DSA;

public class TwoStringsArrayCommonSubstring {

    public static void twoStringsCommonSubstrings(String [] a, String [] b){
        String [] res = new String[a.length];

        for(int i=0; i<a.length; i++){
            int bitMaskA = 0;
            int bitMaskB = 0;

            for(int j=0; j<a[i].length(); j++){
                char ac = a[i].charAt(j);
                char bc = b[i].charAt(j);
                bitMaskA |= 1 << (ac - 'a');
                bitMaskB |= 1 << (bc - 'a');
//                System.out.print(i+": bitmaskA " +bitMaskA+" bitmaskB  "+bitMaskB+", a&B -> ");
//                System.out.print((bitMaskA & bitMaskB) + ", ");
            }

            res[i] = (bitMaskA & bitMaskB) > 0 ? "YES" : "NO";
//            System.out.print("final a&B : "+(bitMaskA & bitMaskB) + ", ");
//            System.out.println();
        }
//
        for (String s:res){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        String [] a = {"ab", "cd", "ef"};
        String [] b = {"ad", "ek", "ef"};
        twoStringsCommonSubstrings(a,b);
    }
}
