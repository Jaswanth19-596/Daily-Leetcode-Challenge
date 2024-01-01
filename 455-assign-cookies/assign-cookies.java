class Solution {
    public int findContentChildren(int[] g, int[] s) {
        

        int m = g.length;
        int n = s.length;

        Arrays.sort(g);
        Arrays.sort(s);


        int child = 0;
        int cookie = 0;
        int satisfiedChildren = 0;

        while(child < m && cookie < n){

            if(s[cookie] >= g[child]){
                child++;
                cookie++;
                satisfiedChildren++;
            }
            else{
                cookie++;
            }
        }

        return satisfiedChildren;


    }
}