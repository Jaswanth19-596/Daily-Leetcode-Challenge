class Pair implements Comparable<Pair>{

    int profit, difficulty;

    Pair(int difficulty, int profit){
        this.profit = profit;
        this.difficulty = difficulty;
    }

    public int compareTo(Pair p){

        if(this.difficulty < p.difficulty){
            return -1;
        }
        else if(this.difficulty > p.difficulty){
            return 1;
        }
        else if(this.profit > p.profit){
            return -1;
        }
        else if(this.profit < p.profit){
            return 1;
        }
        return 0;
    }

    public String toString(){
        return this.difficulty + " "+this.profit;
    }

}


class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

       Pair []arr = new Pair[profit.length];

        for(int i = 0;i<profit.length;i++){
            arr[i] = new Pair(difficulty[i], profit[i]);
        }

        Arrays.sort(arr);
        Arrays.sort(worker);

        // for(Pair p : arr){
        //     System.out.println(p);
        // }


        int maxProfitTillNow = 0;

        int workerIndex = 0, difficultyIndex = -1;

        int finalProfit = 0;

        while(workerIndex < worker.length && difficultyIndex < profit.length){

            // If the worker can do the next job
            if(difficultyIndex +1 < profit.length && worker[workerIndex] >= arr[difficultyIndex + 1].difficulty){
                difficultyIndex++;
                maxProfitTillNow = Math.max(maxProfitTillNow, arr[difficultyIndex].profit);
            }
            else{
                // If the worker cannot do the next job, he can only do the job till now.
                workerIndex++;
                finalProfit += maxProfitTillNow;
                // System.out.println(finalProfit);
            }
        }

        while(difficultyIndex == profit.length && workerIndex < worker.length){
            finalProfit += maxProfitTillNow;
            workerIndex++;
        }

        return finalProfit;
    }
}