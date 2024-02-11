class MyComparator implements Comparator<int []>{

    public int compare(int []arr1, int []arr2){
        if(arr1[1] < arr2[1])   return -1;
        return 1;
    }


}

class Solution {

    public int findLongestChain(int[][] pairs) {
        // return 0;
        Arrays.sort(pairs, new MyComparator());

        int max = pairs[0][1];
        int count = 1;
        for(int i = 1;i<pairs.length;i++){

            if(pairs[i][0] > max){
                max = pairs[i][1];
                count++;
            }
        }

        return count;



    }
}