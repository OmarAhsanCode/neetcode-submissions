class Solution {
    public int search(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        int m;
        boolean a=(target<nums[0])?true:false;
        while (i <= j) {
        m = i + (j - i) / 2;

        if (nums[m] == target)
            return m;

        if (nums[i] <= nums[m]) {        // Left half sorted
            if (nums[i] <= target && target < nums[m])
                j = m - 1;
            else
                i = m + 1;
        } else {                         // Right half sorted
            if (nums[m] < target && target <= nums[j])
                i = m + 1;
            else
                j = m - 1;
    }
}
        return -1;
    }
}
