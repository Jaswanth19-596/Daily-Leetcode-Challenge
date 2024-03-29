import java.util.Random;
class RandomizedSet {

    HashMap<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))    return false;

        // insert into list and map
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val) == false)   return false;

        if(map.size() == 1){
            map.clear();
            list.clear();
            return true;
        }

        int index = map.get(val);

        int lastElement = list.get(list.size()-1);
        list.set(index, lastElement);
        map.put(lastElement, index);
               
               
        list.remove(list.size()-1);

        map.remove(val);
        
        return true;

    }
    
    public int getRandom() {
        Random random = new Random();

        int randomIndex = random.nextInt(list.size());

        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */