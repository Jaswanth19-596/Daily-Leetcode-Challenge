class Solution {


    int getOnesCount(int ele){

        int count = 0;

        while(ele > 0){
            count += ele % 2;
            ele = ele/2;
        }
        return count;


    }


    public int[] sortByBits(int[] arr) {
        
        ArrayList<PriorityQueue<Integer>> list = new ArrayList<>();

        for(int i = 0;i<32;i++){
            list.add(new PriorityQueue<>());
        }

        for(int ele : arr){
            int noOfOnes = getOnesCount(ele);
            list.get(noOfOnes).add(ele);
        }

        int []res = new int[arr.length];
        int index = 0;
        for(int i = 0;i< 32;i++){
            PriorityQueue<Integer> pq = list.get(i);

            while(pq.size() > 0){
                res[index++] = pq.poll();
            }
        }
        return res;


    }
}