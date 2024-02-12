package DSA;

public class ShortestPathString {

    public static double getShortestPath(String str){
        int x=0,y=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == 'N') y++;
            else if (str.charAt(i) == 'S') y--;
            else if (str.charAt(i) == 'E') x++;
            else if (str.charAt(i) == 'W')x--;
            else {}
        }
        double shortestDistance = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
        return shortestDistance;
    }
    public static void main(String[] args) {
        String str = "WNEENESENNN";
        String str2 = "EWNS";
        //System.out.println(getShortestPath(str));


        StringBuilder sb = new StringBuilder("");
        System.out.println("Before "+ sb);
        for(char ch='a'; ch <= 'z'; ch++){
            sb.append(ch);
        }
        System.out.println("After "+sb);
        System.out.println(sb.length());

        //to check if number is odd or even
        System.out.println(8&1);

    }
}
