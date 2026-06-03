class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> map=new HashMap<>();
        for(int i=0; i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],1);
            }
            else
            {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        int arr[]= new int[k];
        int maxVal=0;
        int maxFreq=0;
        for(int i=0; i<k;i++)
        {     
            for(int j : map.keySet())
            {
               if(map.get(j)>maxVal)
                {
                maxVal=map.get(j);
                maxFreq=j;
                }
            }
            arr[i]=maxFreq;
            map.remove(maxFreq);
            maxVal=0;
            maxFreq=0;
        }
        return arr;
    }
}