package DSA;

public class ZigzagConversion {

    public static String convert(String s, int numRows){
        if(numRows == 1) return s;
        StringBuilder result;
        result = new StringBuilder();


        for(int r=0; r<numRows; r++){
            int increment = 2 * (numRows - 1);
            for(int i=r; i<s.length(); i=i+increment){
                // work for first and last row
                result.append(s.charAt(i));
                //for middle rows
                if(r>0 && r<numRows-1 && i+increment - 2*r < s.length()){
                    result.append(s.charAt(i+increment-2*r));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));

    }
}
