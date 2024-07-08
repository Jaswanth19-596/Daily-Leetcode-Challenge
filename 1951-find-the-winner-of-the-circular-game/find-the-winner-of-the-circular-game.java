class Solution {
    public int findTheWinner(int n, int k) {
        int arr[] = new int[n];

        int i = 1;
        
        for(int itr = 0;itr < n;itr++){
            arr[itr] = i++;
        }


        int eliminate = n;
        int currPtr = 0;
        while(eliminate > 1){

            int count = k - 1;

            while(count > 0){
                if(arr[currPtr] == 0){
                    currPtr = (currPtr + 1) % n;
                    while(arr[currPtr] == 0){
                        currPtr = (currPtr + 1) % n;                                    
                    }
                }
                else{
                    count--;
                    currPtr = (currPtr + 1) % n;
                    while(arr[currPtr] == 0){
                        currPtr = (currPtr + 1) % n;                                    
                    }
                }
            }
            arr[currPtr] = 0;
            eliminate--;
            while(arr[currPtr] == 0){
                currPtr = (currPtr + 1) % n;                                    
            }
        }

        for(int ele : arr){
            if(ele != 0){
                return ele;
            }
        }

        // System.out.println(Arrays.toString(arr));

        return 0;
    }
}