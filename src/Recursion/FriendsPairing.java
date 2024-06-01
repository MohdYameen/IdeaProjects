package Recursion;

public class FriendsPairing {

    public static int countFriendsPair(int n){

        if (n == 1 || n == 2) return n;

        return countFriendsPair(n-1)+ (n-1)*countFriendsPair(n-2);
    }
    public static void main(String[] args) {
        System.out.println(countFriendsPair(5));
    }
}
