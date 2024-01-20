class Solution {


    int[] getNextSmallerElement(int []arr){

        Stack<Integer> stack = new Stack<>();

        int next[] = new int[arr.length];
        int n = arr.length;
        next[n-1] = n;
        stack.push(n-1);

        for(int i = n-2;i>=0;i--){
            int curr = arr[i];

            while(stack.size() > 0 && arr[stack.peek()] >= curr){
                stack.pop();
            }
            if(stack.size() == 0){
                next[i] = n;
            }
            else{
                next[i] = stack.peek();
            }
            stack.push(i);
        }
        return next;
    }


    int[] getPrevSmallerElement(int []arr){

        Stack<Integer> stack = new Stack<>();

        int prev[] = new int[arr.length];

        prev[0] = -1;
        stack.push(0);

        for(int i = 1;i<arr.length;i++){

            int curr = arr[i];

            while(stack.size() > 0 && arr[stack.peek()] > curr){
                stack.pop();
            }

            if(stack.size() == 0){
                prev[i] = -1;
            }else{
                prev[i] = stack.peek();
            }
            stack.push(i);
        }
        return prev;
    }


    public int sumSubarrayMins(int[] arr) {
        int prev[] = getPrevSmallerElement(arr);
        int next[] = getNextSmallerElement(arr);

        long res = 0;

        for(int i = 0;i<arr.length;i++){
            long prevValue = i - prev[i] - 1;
            long nextValue = next[i] - i - 1;  

            long halfvalue = ((prevValue + 1) * (nextValue + 1)) % ((long)1e9 + 7);

            long anotherHalf = (halfvalue * arr[i]) % ((long)1e9 + 7);

            res = (res + anotherHalf) % ((long)1e9+7); 
            // res = (res + (((prevValue+1) * (nextValue+1))%((int)1e9 + 7)) * arr[i]) % ((int)1e9 + 7);
        }
        return (int)res;
    }
}