class Solution {
    public int search(int[] nums, int target) {
        int ans=-1;
        int i=0;
        int j=nums.length-1;
        while(i<=j)
        {
            if(target==nums[i + (j - i) / 2])
            {
                return (i + (j - i) / 2);
            }
            else if(target<nums[i + (j - i) / 2])
            {
                j=(i + (j - i) / 2)-1;
            }
            else
            {
                i=(i + (j - i) / 2)+1;
            }
        }
        return ans;
    }
}