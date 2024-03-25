class Solution {
    public int findDuplicate(int[] arr) {
        
        int n = arr.length;

        int slow = arr[0], fast = arr[0];

        while(true){
            slow = arr[slow];
            fast = arr[arr[fast]];


            if(slow == fast){
                slow = arr[0];

                while(slow != fast){
                    slow = arr[slow];
                    fast = arr[fast];
                }

                return slow;

            }
        }

        // return slow;
       

    }
}