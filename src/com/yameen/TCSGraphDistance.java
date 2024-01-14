package com.yameen;

import java.util.Scanner;

public class TCSGraphDistance {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int x =0, y = 0;
            char c = 'R';
            int distance = 10;
            while(n>=1){
                switch(c){
                    case 'R':
                        x = x+distance;
                        distance+=10;
                        c = 'U';
                        break;

                    case 'U':
                        y = y+distance;
                        distance+=10;
                        c = 'L';
                        break;

                    case 'L' :
                        x = x-distance;
                        distance+=10;
                        c = 'D';
                        break;

                    case 'D':
                        y = y-distance;
                        distance+=10;
                        c = 'A';
                        break;

                    case 'A':
                        x = x+distance;
                        distance+=10;
                        c = 'R';
                        break;

                }
                n--;
            }
            System.out.println(x + ", "+y);
            sc.close();
        }
}

