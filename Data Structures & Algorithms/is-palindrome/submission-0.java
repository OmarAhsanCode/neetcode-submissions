class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int L=0;
        int R=s.length()-1;
        while(L < R)
        {
            if(s.charAt(L)!= s.charAt(R))
            {
                return false;
            }
            L++;R--;
        }
        return true;
    }
}