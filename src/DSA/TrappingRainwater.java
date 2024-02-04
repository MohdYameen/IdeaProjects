package DSA;

public class TrappingRainwater {

    /*
    Water level =

    Case 1: single bar => No water trapped
    Case 2: 2 bars => No water trapped
    Hence not applicable for both of the cases
    Ascending or Descending order can not trap water.

    Boundary is needed to trap water.

    Water can ce stored only in valley/pocket i.e both sides should have boundary greater than middle one,

    Min no. of bars required to hold some water should be 3 or more;

    Maximum boundary of left and maximum boundary of right => Minimum among these 2.
    Maximum boundary of left and maximum boundary of right should be less than actual(current) bar.

    Trapped Water = water level - height

    water level = min(MaxLeft and MaxRight)

    Auxiliary arrays:



     */
    public static int trapRainWater(int []a){
        System.out.print("Height Array: ");

        for (int j : a) {
            System.out.print(j + ", ");
        }
        System.out.println();

        int [] left_max_boundary = new int[a.length];
        left_max_boundary[0] = a[0];
        int [] right_max_boundary = new int[a.length];

        right_max_boundary[right_max_boundary.length-1] = a[a.length-1];

        for(int i=1;i<left_max_boundary.length;i++){

            left_max_boundary[i] = Math.max(left_max_boundary[i-1], a[i]);

        }

        System.out.print("Max Left Array: ");
        for (int k : left_max_boundary) {
            System.out.print(k + ", ");
        }

        for(int i = right_max_boundary.length -2; i>=0;i--){
            right_max_boundary[i] = Math.max(right_max_boundary[i +1], a[i]);
        }
        System.out.println();
        System.out.print("Max Right Array: ");

        for (int j : right_max_boundary) {
            System.out.print(j + ", ");
        }

        int trapped_water = 0;

        for(int i=0;i<a.length;i++){
            int water_level =  Math.min(left_max_boundary[i], right_max_boundary[i]);
            trapped_water += water_level - a[i];

        }
        System.out.println();

        System.out.println("Trapped Water: "+trapped_water);



      return trapped_water;
    }


    public static void main(String[] args) {

        int [] height_array = {4,2,0,6,3,2,5};
        System.out.println(trapRainWater(height_array));


    }
}
