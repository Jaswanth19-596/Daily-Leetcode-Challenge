class DataStream {


    int value, k;
    // int arr[];
    Queue<Boolean> q;

    int falseCount;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        // arr = new int[k];
        q = new LinkedList<Boolean>();
        falseCount = 0;
    }
    
    public boolean consec(int num) {
        q.add(num == this.value);
        if(num != this.value) falseCount += 1;


        if(q.size() < k){
            return false;
        }  

        if(q.size() == k){
            return falseCount == 0;
        }

        boolean val = q.poll();
        if(val == false){
            falseCount -= 1;
        }
        return falseCount == 0;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */