package Graph;

public class FloodFillAlgo {

    public int [][] floodFill(int [][] image, int sr, int sc, int color){
        boolean vis [][] = new boolean[image.length][image[0].length];
         floodFillUtil(image, sr, sc, color, vis, image[sr][sc]);
         return image;
    }

    //O(m*n)
    public static void floodFillUtil(int [][] image, int sr, int sc, int color, boolean [][] vis, int orgColor){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgColor){
            image[sr][sc] = color;
            return;
        }
                //left
        floodFillUtil(image, sr, sc-1, color, vis, orgColor);
        //right
        floodFillUtil(image, sr, sc+1, color, vis, orgColor);
        //up
        floodFillUtil(image, sr-1, sc, color, vis, orgColor);
        //down
        floodFillUtil(image, sr+1, sc, color, vis, orgColor);
    }

    public static void main(String[] args) {

    }
}
