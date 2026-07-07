class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int MA=0;
        while(l<r)
        {
            int a=(r-l)*(Math.min(height[l],height[r]));
            if(a>MA){
                MA=a;
            }
            if(height[l]>height[r]){
                r--;
            }
            else{
                l++;
            }
        }
        return MA;
    }
}