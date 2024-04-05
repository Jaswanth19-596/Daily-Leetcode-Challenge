class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();


        for(char ch : s.toCharArray()){
            if(stack.size() > 0 && Math.abs(stack.peek() - ch) != 32){
                stack.push(ch);
            }
            else if(stack.size() == 0){
                stack.push(ch);
            }
            else if(stack.size() > 0 && Math.abs(stack.peek() - ch) == 32){
                stack.pop();
            }
        }


        String res = "";

        while(stack.size() > 0){

            res = stack.pop() + res;
        }
        return res;

    }
}