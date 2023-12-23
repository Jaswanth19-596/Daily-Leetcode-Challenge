class Solution {
    public boolean isPathCrossing(String path) {
        
        int x = 0, y = 0;

        HashSet<String> set = new HashSet<>();

        set.add(x + " "+y);
        for(char ch : path.toCharArray()){
            switch(ch){
                case 'N' : y = y + 1;  break;
                case 'E' : x = x + 1; break;
                case 'W' : x = x - 1; break;
                case 'S' : y = y - 1; break;
            }
            if(set.contains(x+" "+y)){
                return true;
            }
            set.add(x + " "+y);
        }
        return false;
    }
}