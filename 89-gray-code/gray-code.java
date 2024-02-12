class Solution {


    List<String> solve(int n){
        
        if(n == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add("0");
            list.add("1");
            return list;
        }

        List<String> prev = solve(n - 1);

        List<String> curr = new ArrayList<>();

        for(int i = 0;i<prev.size();i++){
            String appended = '0' + String.valueOf(prev.get(i));
            // int m = Integer.parseInt(appended);
            curr.add(appended);
        }
        for(int i = prev.size()-1;i>=0;i--){
            String appended = '1' + String.valueOf(prev.get(i));
            // int m = Integer.parseInt(appended);
            curr.add(appended);
        }
        return curr;

    }

    int getNum(String str){

        int res = 0;

        for( int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            int bit = ch - '0';
            res = res + (int)(bit * Math.pow(2, str.length() - i - 1));
        }
        return res;
    }


    public List<Integer> grayCode(int n) {
        List<String> res =  solve(n);
        List<Integer> finalArr = new ArrayList<>();

        for(String str : res){
            finalArr.add(getNum(str));
        }
        return finalArr;


    }
}