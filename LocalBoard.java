public class LocalBoard 
{
    public box[][] board = new box[3][3];
    public Character winner;
    
    public LocalBoard()
    {
        winner = null;
        
        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                board[x][y] = new box();
            }
        }
    }
    
    
    public void makeMove(char a, int x, int y) //assume space has already been checked for ifOccupied or not
    {
        board[x][y].markBox(a);
        checkVictory(a);
    }
    
    
    public boolean isFull()
    {
        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                if(!board[x][y].isOccupied())
                    return false; //for if even a single space is unoccupied
            }
        }
        return true;
    }
    
    public void checkVictory(char XorO)
    {
        for(int x = 0; x < 3; x++) //check all horizontals
        {
            if(Character.compare(board[x][0].displayMark(), XorO)==0 && Character.compare(board[x][1].displayMark(), XorO)==0 && Character.compare(board[x][2].displayMark(), XorO)==0)
            {
                winner = XorO;
                finalizeWin();
            }
        }
        
        for(int y = 0; y < 3; y++) //check all verticals
        {
            if(Character.compare(board[0][y].displayMark(), XorO)==0 && Character.compare(board[1][y].displayMark(), XorO)==0 && Character.compare(board[2][y].displayMark(), XorO)==0)
            {
                winner = XorO;
                finalizeWin();
            }
        }
            
        //manually check both diagonals
        if(Character.compare(board[0][0].displayMark(), XorO)==0 && Character.compare(board[1][1].displayMark(), XorO)==0 && Character.compare(board[2][2].displayMark(), XorO)==0)
        {
            winner = XorO;
            finalizeWin();
        }
        
        if(Character.compare(board[2][0].displayMark(), XorO)==0 && Character.compare(board[1][1].displayMark(), XorO)==0 && Character.compare(board[0][2].displayMark(), XorO)==0)
        {
            winner = XorO;
            finalizeWin();
        }
    }
    
    public void finalizeWin()
    {
        System.out.println("SWAPPING CHARS");
        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                if(!board[x][y].isOccupied()) //swap all unoccupied displays from '-' to '*'
                    board[x][y].swapIdle();
            }
        }
        
        printBoard();
    }
    
    public void printBoard()
    {
        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                System.out.print(board[x][y].displayMark() + " ");
            }
            System.out.println();
        }
        
        System.out.println();
    }
    
    public boolean isWon(){ return !(winner == null); }
}
