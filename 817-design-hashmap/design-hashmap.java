class MyHashMap {   
    
    class Pair{
        int key,value;

        Pair(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    ArrayList<LinkedList<Pair>> list;
    int size = 113;


    public MyHashMap() {
        list = new ArrayList<>();

        for(int i = 0;i<size;i++){
            list.add(new LinkedList<>());
        }
    }
    
    public void put(int key, int value) {
        
        int index = key % size;
        
        if(list.get(index).size() == 0){
            list.get(index).add(new Pair(key,value));
            return;
        }

        // check if the key exists
        LinkedList<Pair> tempList = list.get(index);
        
        int i = 0;
        while(i < tempList.size()){
            if(tempList.get(i).key == key){
                tempList.get(i).value = value;
                return;
            }
            i++;
        }

        // The key is not present
        tempList.add(new Pair(key,value));
    }
    
    public int get(int key) {
        int index = key % size;

        LinkedList<Pair> tempList = list.get(index);
        int i = 0;
        while(i < tempList.size()){
            if(tempList.get(i).key == key){
                return tempList.get(i).value;
            }
            i++;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = key % size;

        int i = 0;
        LinkedList<Pair> tempList = list.get(index);

        while( i < tempList.size()){
            if(tempList.get(i).key == key){
                tempList.remove(i);
                return;
            }
            i++;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */