class Solution {

    boolean search(int i, int j, int index, char [][]board, String str, boolean visited[][]){

        if(index == str.length())   return true;

        if(i >= board.length || i < 0 || j < 0 || j >= board[0].length) return false;

        if(visited[i][j])   return false;

        if(board[i][j] != str.charAt(index))    return false;

        visited[i][j] = true;

        // explore all ways
        boolean right = search(i, j + 1, index + 1, board, str, visited);

        if(right){
            visited[i][j] = false;
            return true;
        }   
        boolean down = search(i+1, j , index + 1, board, str, visited);
        if(down){
            visited[i][j] = false;
            return true;
        }    
        boolean left = search(i, j - 1, index + 1, board, str, visited);
        if(left){
            visited[i][j] = false;
            return true;
        }    
        boolean up = search(i-1, j , index + 1, board, str, visited);

        visited[i][j] = false;
        return up;

    }


    public boolean exist(char[][] board, String word) {
        
        int n = board.length, m = board[0].length;

        int length = word.length();


        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){

                if(board[i][j] == word.charAt(0)){
                    boolean res = search(i,j, 0, board, word, new boolean[n][m]);
                    if(res) return res;
                }
            }
        }
        return false;
    }
}