class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Integer arr[] = new Integer[people.length];

        for(int i = 0;i<people.length;i++){
            arr[i] = Integer.valueOf(people[i]);
        }

        Arrays.sort(arr, (a,b)->b-a);

        int fat = 0, thin = people.length - 1;
        int count = 0;
        while(fat <= thin){
            
            int rem = limit - arr[fat];
            fat++;
            if(rem >= arr[thin]){
                thin--;
            }
            count++;
        }

        return count;
    }
}