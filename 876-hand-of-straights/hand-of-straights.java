class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length % groupSize != 0)    return false;

        int n = hand.length;
        Arrays.sort(hand);

        ArrayList<PriorityQueue<Integer>> list = new ArrayList<>();

        for(int i = 0;i<n/groupSize;i++){
            list.add(new PriorityQueue<>(Collections.reverseOrder()));
        }

        for(int ele : hand){


            for(int i = 0;i<list.size();i++){
                PriorityQueue<Integer> pq = list.get(i);


                if(pq.size() == groupSize){
                    continue;
                }
                else if(pq.size() == 0){
                    pq.add(ele);
                    break;
                }
                else if(pq.peek() == ele){
                    if(i == list.size()-1)  return false;
                    continue;
                }
                else{
                    if(ele - pq.peek() == 1){
                        pq.add(ele);
                        break;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}