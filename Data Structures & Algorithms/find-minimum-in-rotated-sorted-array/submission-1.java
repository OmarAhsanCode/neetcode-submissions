class Solution {
    public int findMin(int[] nums) {
        int i=0;
        int j=nums.length-1;
        if(nums[i]<=nums[j])
        {
            return nums[i];
        }
        while(i<=j)
        {
            int m= i+(j-i)/2;
            if(nums[m]>nums[m+1])
            {
                return nums[m+1];
            }
            if(nums[m]<nums[m-1])
            {
                return nums[m];
            }
            if(nums[0]>nums[m])
            {
                j=m-1;
            }
            else
            {
                i=m+1;
            }
        }
        return 0;
    }
}

