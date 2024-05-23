package Recursion;

public class MagnetProblem {

    static double neutralPoint(double low, double high, double [] magnets){
        int n = magnets.length;

        while(low<high){
            double mid = (low+high)/2;
            double totalForce = 0;

            for(int i=0; i<n; i++){
                totalForce+= 1/(mid - magnets[i]);
            }
            if(Math.abs(totalForce) < 0.001) return mid;
            else if(totalForce < 0) high = mid;
            else low = mid;
        }
        return low;
    }

    static void nullPoints(double [] magnets){
        int n = magnets.length;
        for (int i=0; i<n-1; i++){
            double neutralPoint = neutralPoint(magnets[i], magnets[i+1], magnets);
            System.out.print(String.format("%.2f", neutralPoint)+ " ");
        }
    }

    public static void main(String[] args) {
        double [] magnets = {0,10,20,30};
        nullPoints(magnets);

    }
}
