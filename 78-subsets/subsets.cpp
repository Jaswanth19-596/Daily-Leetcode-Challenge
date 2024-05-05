class Solution {
public:

    vector<vector<int>> mat;

    void findSubsets(int i, vector<int> &arr, vector<int>& nums){
        if(i == nums.size())   {
            mat.push_back(arr);
            return;
        }

        // two options
        // not select
        findSubsets(i+1, arr, nums);

        // select
        arr.push_back(nums[i]);

        findSubsets(i+1, arr, nums);

        arr.pop_back();
    }


    vector<vector<int>> subsets(vector<int>& nums) {
        
        vector<int> arr;
        findSubsets(0, arr, nums);
        return mat;
    }
};