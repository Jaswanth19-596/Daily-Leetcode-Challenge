class Solution {

    boolean canIPlaceAll(int []position, int m, int dist){

        int prev = 0;

        int n = m - 1;

        int count = 0;
        for(int i = 1;i<position.length;i++){

            if(position[i] - position[prev] >= dist){
                count++;
                prev = i;
            }
        }

        if(count >= n)  return true;
        return false;
    }



    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int min = 0, max = (int)1e9;

        int res = 0;
        while(min <= max){
            int mid = min + (max - min)/2;

            if(canIPlaceAll(position, m, mid)){
                res = mid;
                min = mid + 1;
            }
            else{
                max = mid - 1;
            }
        }

        return res;


    }
}