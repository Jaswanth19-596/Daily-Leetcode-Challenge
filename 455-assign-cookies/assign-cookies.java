class Solution {
    public int findContentChildren(int[] g, int[] s) {
        

        int n = g.length, m = s.length;

        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int cookieIndex = 0;
        for(int i = 0;i<g.length;i++){
           
            int greed = g[i];

            while(cookieIndex < s.length && s[cookieIndex] < greed){
                cookieIndex++;
            }
            if(cookieIndex == s.length) break;
            count++;
            cookieIndex++;
        }

        return count;

    }
}