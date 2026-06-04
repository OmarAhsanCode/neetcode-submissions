class Solution {
    public boolean isValidSudoku(char[][] board) {
        //rows
        for(int i=0; i<9; i++)
        {
            HashSet<Character> set= new HashSet<>();
            for(int j=0; j<9; j++)
            {
                if(board[i][j]=='.')
                {
                    continue;
                }
               else if(!set.add(board[i][j]))
               {
                return false;
               }
            }
        }
        //coloumns
        for(int i=0; i<9; i++)
        {
            HashSet<Character> set= new HashSet<>();
            for(int j=0; j<9; j++)
            {
                if(board[j][i]=='.')
                {
                    continue;
                }
               else if(!set.add(board[j][i]))
               {
                return false;
               }
            }
        }
        //boxes
        for(int i=0; i<9;i=i+3)
        {
            for(int j=0; j<9; j=j+3)
            {
                 HashSet<Character> set= new HashSet<>();
                for(int k=i; k<i+3; k++)
                {
                    for(int l=j; l<j+3; l++)
                    {
                        if(board[k][l]=='.')
                         {
                            continue;
                         }
                        else if(!set.add(board[k][l]))
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}