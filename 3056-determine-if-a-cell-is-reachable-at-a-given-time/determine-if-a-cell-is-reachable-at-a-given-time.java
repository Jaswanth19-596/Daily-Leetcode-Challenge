class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        
        if(sx == fx && sy == fy && t == 1)  return false;
        
        int horDist = Math.abs(fy - sy);
        int verDist = Math.abs(fx - sx);

        int min_time = Math.max(horDist, verDist);

        return t >= min_time;
       
    }
}