class Solution {

    private int getNoOfBeamsInRow(String []bank, int i){
        int n = 0;
        for(char ch : bank[i].toCharArray()){
            if(ch == '1') n++;
        }
        return n;
    }

    public int numberOfBeams(String[] bank) {
        
        // Find the no of beams in the first row
        // Start iterating from the second row and 
            // If current row has > 0 beams :
                // ans = ans + prevRowBeams * currentRowBeams
                // prevRowBeams = currentRowBeams
        // return ans


        int ans = 0;

        int prevRowBeams = getNoOfBeamsInRow(bank,0);

        for(int i = 1;i<bank.length;i++){

            int currentRowBeams = getNoOfBeamsInRow(bank, i);

            if(currentRowBeams > 0){
                ans += (prevRowBeams * currentRowBeams);
                prevRowBeams = currentRowBeams;
            }
        }
        return ans;

    }
}