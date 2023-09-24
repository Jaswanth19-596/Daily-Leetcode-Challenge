class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double mat[][] = new double[101][101];

        mat[0][0] = poured;

        for(int row = 0;row < 100;row ++){

            for(int col = 0;col <= row;col++){

                if(mat[row][col] > 1){
                    mat[row+1][col] += (mat[row][col]-1)/2.0;
                    mat[row+1][col+1] += (mat[row][col]-1)/2.0;                                 
                    mat[row][col] = 1;
                }
            }
        }

        return mat[query_row][query_glass];
    }
}