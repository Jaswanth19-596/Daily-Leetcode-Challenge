class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        sort(people.begin(), people.end());

        int fat = people.size()-1;
        int thin = 0;

        int count = 0;

        while(fat >= thin){
            int rem = limit - people[fat];
            fat--;

            if(rem >= people[thin]){
                thin++;
            }
            count++;
        }

        return count;


    }
};