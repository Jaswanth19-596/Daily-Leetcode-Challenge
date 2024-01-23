class Solution {

    int length = 0;

    void func(int i, boolean visited[], List<String> arr){

        if(i == arr.size()){

            int size = 0;

            for(int j = 0;j<visited.length;j++){
                if(visited[j])  size++;
            }
            length = Math.max(length, size);
            return;
        }

        boolean[] precheck = new boolean[128];

        for(char ch : arr.get(i).toCharArray()){
            if(precheck[ch]){
                func(i+1, visited, arr);
                return;
            }
            precheck[ch] = true;
        }


        func(i+1, visited, arr);

        // Make sure that the current characters are not visited

        for(char ch : arr.get(i).toCharArray()){
            if(visited[ch] == true) return;
        }

        // mark the characters
        for(char ch : arr.get(i).toCharArray()){
            visited[ch] = true;
        }

        func(i+1, visited, arr);

         for(char ch : arr.get(i).toCharArray()){
            visited[ch] = false;
        }
    }


    public int maxLength(List<String> arr) {
        

        boolean visited[] = new boolean[128];

        func(0, visited,arr);

        return length;



    }
}