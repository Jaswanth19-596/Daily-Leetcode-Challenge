class Solution {

        public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ele : arr){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        int freqArray[] = new int[map.size()];
        int index = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            freqArray[index++] = e.getValue();
        }

        int count = 0;

        Arrays.sort(freqArray);
        int i = 0;
        while(k>0){
            if(freqArray[i] > k) {
                return (freqArray.length - i);
            }   
            k -= freqArray[i];
            i++;
        }
        return freqArray.length - i;

    }
}