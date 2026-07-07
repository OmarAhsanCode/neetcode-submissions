class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int a=0;
        while(a<matrix.length)
        {
            if(target == matrix[a][(matrix[0].length-1)])
            {
                return true;
            }
            if(target < matrix[a][(matrix[0].length-1)])
            {
                break;
            }
            if(a==(matrix.length-1))
            {
                return false;
            }
            a++;
        }
        int i=0;
        int j=matrix[a].length-1;
        while (i <= j) {

            int mid = i + (j - i) / 2;

            if (target == matrix[a][mid]) {
                return true;
            } else if (target < matrix[a][mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }
}