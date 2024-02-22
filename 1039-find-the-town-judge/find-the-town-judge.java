class Solution {
    public int findJudge(int n, int[][] trust) {
       Map<Integer, Integer> map = new HashMap<>();

        for(int i = 1;i<=1000;i++){
            map.put(i, 0);
        }

       for(int arr[] : trust){
           int a1 = arr[0];
           int b1 = arr[1];

           map.put(a1, map.get(a1) - 1);
           map.put(b1, map.get(b1) + 1);
       }

       for(Map.Entry<Integer, Integer> e : map.entrySet()){
           if(e.getValue() == n -1) return e.getKey();
       }
       return -1;
    }
}