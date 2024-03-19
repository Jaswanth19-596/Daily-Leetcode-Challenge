class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int freq[] = new int[26];

        for(char ch : tasks){
            freq[ch-65]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int fr : freq){
            if(fr > 0){
                pq.add(fr);
            }
        }

        int time = 0;
        while(pq.size()>0){
            int temp = n + 1;

            ArrayList<Integer> waitingTasks = new ArrayList<>();

            while(temp > 0){

                if(pq.size() > 0){
                    int fr = pq.poll();
                    fr = fr - 1;
                    if(fr>0){
                        waitingTasks.add(fr);
                    }
                }  
                else if(waitingTasks.size() == 0){
                    return time;
                }


                time++;
                temp--;
            }

            for(int fr : waitingTasks){
                pq.add(fr);
            }
        }

        return time;
    }
}