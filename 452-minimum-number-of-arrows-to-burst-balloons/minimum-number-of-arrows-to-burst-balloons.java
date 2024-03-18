class MyComparator implements Comparator<int []>{

    public int compare(int []a, int []b){
        return a[0] < b[0] ? -1 : 1;
    }


}


class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new MyComparator());


        int low = points[0][0], high = points[0][1];
        int count = 1;
        for(int i = 1;i<points.length;i++){
            if(points[i][0] > high){
                count++;
                low = points[i][0];
                high = points[i][1];
            }
            else{
                low = Math.max(low, points[i][0]);
                high = Math.min(high, points[i][1]);
            }
        }

        return count;


        // return 0;
    }
}