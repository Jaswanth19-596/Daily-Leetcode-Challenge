class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        int []count = new int[1001];

        for(int ele : arr1){
            count[ele]++;
        }
        int i = 0;
        int ptr = 0;
        while(ptr < arr2.length && i<arr1.length){
            int ele = arr2[ptr];

            while(count[ele] > 0){
                arr1[i] = ele;
                i++;
                count[ele]--;
            }
            ptr++;
        }

        for(int j = 0;j<count.length;j++){
            while(count[j] > 0){
                arr1[i] = j;
                i++;
                count[j]--;
            }
        }

        return arr1;
    }
}