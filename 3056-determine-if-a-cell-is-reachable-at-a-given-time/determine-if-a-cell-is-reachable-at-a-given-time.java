class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        

        if(sx == fx && fy == sy && t == 1)    return false;

        // On same row
        if(fx == sx){
            int minNoOfSteps = Math.abs(fy - sy);
            return t >= minNoOfSteps;
        }

        if(fy == sy){
            int minNoOfSteps = Math.abs(fx - sx);
            return t >= minNoOfSteps;
        }

        int downDistance = Math.abs(fx - sx);

        int stDistance = Math.abs(fy - sy);

        String nearer = "";

        if(downDistance < stDistance){
            nearer = "Down";
        }
        else if(stDistance < downDistance){
            nearer = "st";
        }

        System.out.println(nearer);
        int min = 0;
        int max = 0;
        if(nearer.equals("st")){
            min = Math.abs(fy - sy);
            max = Math.abs(fx - sx);
        }
        else if(nearer.equals("Down")){
            min = Math.abs(fx - sx);
            max = Math.abs(fy - sy);
        }
        else{
            return t >= Math.abs(fy - sy);
        }       
        System.out.println(min + (max - min));
        return t >= min + (max - min);
    }
}