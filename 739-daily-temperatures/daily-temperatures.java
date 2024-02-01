class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> stack = new Stack<>();


        int next[] = new int[temperatures.length];

        stack.push(temperatures.length - 1);

        for(int i = temperatures.length - 2;i>=0;i--){

            while(stack.size() > 0 && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }
            if(stack.size() == 0){
                next[i] = 0;
            }
            else{
                next[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return next;





    }
}