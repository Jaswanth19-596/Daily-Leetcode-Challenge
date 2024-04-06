class Solution {


    class Pair{
        char ch;
        int index;

        Pair(char ch, int index){
            this.ch = ch;
            this.index = index;
        }
    }


    public String minRemoveToMakeValid(String s) {
        
        Stack<Pair> stack = new Stack<>();

        String res = "";

        for(char ch : s.toCharArray()){
            if(ch == '('){
                res += ch;
                stack.push(new Pair(ch, res.length()-1));
            }
            else if(ch == ')'){
                if(stack.size() != 0){
                    res += ch;
                    stack.pop();
                }
            }
            else{
                res += ch;
            }
        }
        String finalRes = "";

        for(int i = res.length() - 1;i>=0;i--){

            if(res.charAt(i) == '('){
                if(stack.size() > 0 && stack.peek().index == i){
                    stack.pop();
                }
                else{
                    finalRes = res.charAt(i) + finalRes;
                }
            }
            else{
                finalRes = res.charAt(i) + finalRes;
            }
        }

        
        return finalRes;

    }
}