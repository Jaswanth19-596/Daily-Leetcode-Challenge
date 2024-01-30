class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int res = 0;

        for(String token : tokens){

            if(token.equals("+")){
                int cal = stack.pop() + stack.pop();
                stack.push(cal);
            }
            else if(token.equals("-")){
                int ele2 = stack.pop();
                int ele1 = stack.pop();
                stack.push(ele1 - ele2);
            }
            else if(token.equals("*")){
                int cal = stack.pop() * stack.pop();
                stack.push(cal);
            }
            else if(token.equals("/")){
                int ele2 = stack.pop();
                int ele1 = stack.pop();
                stack.push(ele1/ele2);
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();


    }
}