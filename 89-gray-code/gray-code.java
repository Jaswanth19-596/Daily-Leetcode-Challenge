class Solution {

    ArrayList<Integer> list = new ArrayList<>();


    int getNum(int arr[]){
        int n = 0;

        for(int i = 0;i<arr.length;i++){
            n += (arr[i] * Math.pow(2, arr.length - i - 1));
        }

        return n;
    }


    boolean solve(int arr[], Set<Integer> set){

        if(list.size() == Math.pow(2, arr.length)){
            return true;
        }

        int n = getNum(arr);

        if(set.contains(n)) return false;

        set.add(n);
        list.add(n);

        for(int i = 0;i<arr.length;i++){
            arr[i] = arr[i] ^ 1;
            boolean res = solve(arr, set);
            if(res == true) return true;
            arr[i] = arr[i] ^ 1;
        }
        list.remove(list.size()-1);
        set.remove(n);

        return false;
    }


    public List<Integer> grayCode(int n) {
        int arr[] = new int[n];
        solve(arr, new HashSet<>());
        return list;
    }
}