class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] days= new int[temperatures.length];
        for(int i=0; i<temperatures.length-1;i++)
        {
            int count= 0;
            for(int j=i+1; j<temperatures.length; j++)
            {
                if((j==temperatures.length-1)&&(!(temperatures[j]>temperatures[i])))
                {
                    count=0;
                    break;
                }
                else if(!(temperatures[j]>temperatures[i]))
                {
                    count++;
                }
                else
                {
                    count++;
                    break;
                }
            }
            days[i]=count;
        }
        return days;
    }
}