public class BigBoard extends LocalBoard
{
    public LocalBoard[][] Global = new LocalBoard[3][3];
    
    public Integer boardCol;
    public Integer boardRow;
    
    
    public BigBoard()
    {
        boardCol = null;
        boardRow = null;
        
        for(int x = 0; x < 3; x++)
            for(int y = 0; y < 3; y++)
                Global[x][y] = new LocalBoard();
    }
    
    
    public boolean allFull()
    {
        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                if(!Global[x][y].isFull()) //for if even a single board is not full
                    return false;
            }
        }
    return true;
    }
    
    @Override
    public void printBoard() //yeah, I realize it's a lot...
    {
            //1st LINE
            System.out.print(Global[0][0].board[0][0].displayMark() + " " + Global[0][0].board[0][1].displayMark() + " " + Global[0][0].board[0][2].displayMark() + " | " + Global[0][1].board[0][0].displayMark() + " " + Global[0][1].board[0][1].displayMark() + " " + Global[0][1].board[0][2].displayMark() + " |" + Global[0][2].board[0][0].displayMark() + " " + Global[0][2].board[0][1].displayMark() + " " + Global[0][2].board[0][2].displayMark() + " |");
            System.out.println();
            
            //2nd LINE
            System.out.print(Global[0][0].board[1][0].displayMark() + " " + Global[0][0].board[1][1].displayMark() + " " + Global[0][0].board[1][2].displayMark() + " | " + Global[0][1].board[1][0].displayMark() + " " + Global[0][1].board[1][1].displayMark() + " " + Global[0][1].board[1][2].displayMark() + " |" + Global[0][2].board[1][0].displayMark() + " " + Global[0][2].board[1][1].displayMark() + " " + Global[0][2].board[1][2].displayMark() + " |");
            System.out.println();
            
            //3rd LINE
            System.out.print(Global[0][0].board[2][0].displayMark() + " " + Global[0][0].board[2][1].displayMark() + " " + Global[0][0].board[2][2].displayMark() + " | " + Global[0][1].board[2][0].displayMark() + " " + Global[0][1].board[2][1].displayMark() + " " + Global[0][1].board[2][2].displayMark() + " |" + Global[0][2].board[2][0].displayMark() + " " + Global[0][2].board[2][1].displayMark() + " " + Global[0][2].board[2][2].displayMark() + " |");
            System.out.println();
            
            System.out.println("------+------+--------");
            
            //4th LINE
            System.out.print(Global[1][0].board[0][0].displayMark() + " " + Global[1][0].board[0][1].displayMark() + " " + Global[1][0].board[0][2].displayMark() + " | " + Global[1][1].board[0][0].displayMark() + " " + Global[1][1].board[0][1].displayMark() + " " + Global[1][1].board[0][2].displayMark() + " |" + Global[1][2].board[0][0].displayMark() + " " + Global[1][2].board[0][1].displayMark() + " " + Global[1][2].board[0][2].displayMark() + " |");
            System.out.println();
            
            //5th LINE
            System.out.print(Global[1][0].board[1][0].displayMark() + " " + Global[1][0].board[1][1].displayMark() + " " + Global[1][0].board[1][2].displayMark() + " | " + Global[1][1].board[1][0].displayMark() + " " + Global[1][1].board[1][1].displayMark() + " " + Global[1][1].board[1][2].displayMark() + " |" + Global[1][2].board[1][0].displayMark() + " " + Global[1][2].board[1][1].displayMark() + " " + Global[1][2].board[1][2].displayMark() + " |");
            System.out.println();
            
            //6th LINE
            System.out.print(Global[1][0].board[0][0].displayMark() + " " + Global[1][0].board[0][1].displayMark() + " " + Global[1][0].board[0][2].displayMark() + " | " + Global[1][1].board[2][0].displayMark() + " " + Global[1][1].board[2][1].displayMark() + " " + Global[1][1].board[2][2].displayMark() + " |" + Global[1][2].board[2][0].displayMark() + " " + Global[1][2].board[2][1].displayMark() + " " + Global[1][2].board[2][2].displayMark() + " |");
            System.out.println();
            
            System.out.println("------+------+--------");
            
            //7th LINE
            System.out.print(Global[2][0].board[0][0].displayMark() + " " + Global[2][0].board[0][1].displayMark() + " " + Global[2][0].board[0][2].displayMark() + " | " + Global[2][1].board[0][0].displayMark() + " " + Global[2][1].board[0][1].displayMark() + " " + Global[2][1].board[0][2].displayMark() + " |" + Global[2][2].board[0][0].displayMark() + " " + Global[2][2].board[0][1].displayMark() + " " + Global[2][2].board[0][2].displayMark() + " |");
            System.out.println();

            //8th LINE
            System.out.print(Global[2][0].board[1][0].displayMark() + " " + Global[2][0].board[1][1].displayMark() + " " + Global[2][0].board[1][2].displayMark() + " | " + Global[2][1].board[1][0].displayMark() + " " + Global[2][1].board[1][1].displayMark() + " " + Global[2][1].board[1][2].displayMark() + " |" + Global[2][2].board[1][0].displayMark() + " " + Global[2][2].board[1][1].displayMark() + " " + Global[2][2].board[1][2].displayMark() + " |");
            System.out.println();
            
            //9th LINE
            System.out.print(Global[2][0].board[2][0].displayMark() + " " + Global[2][0].board[2][1].displayMark() + " " + Global[2][0].board[2][2].displayMark() + " | " + Global[2][1].board[0][0].displayMark() + " " + Global[2][1].board[0][1].displayMark() + " " + Global[2][1].board[0][2].displayMark() + " |" + Global[2][2].board[2][0].displayMark() + " " + Global[2][2].board[2][1].displayMark() + " " + Global[2][2].board[2][2].displayMark() + " |");
            System.out.println();
            System.out.println("------+------+--------");
    }
    
    public void printBoardDepreciated() //issue here with boards being improperly printed out... (and why the input problem occurred)
    {
        for(int w = 0; w<3;w++)
        {
            for(int x = 0; x<3; x++)
            {
                for(int y = 0; y<3;y++)
                {
                    //first row
                    for(int z = 0; z<3;z++)
                    {
                        //System.out.print(Global[w][x].board[y][z].displayMark() + " ");
                        System.out.print(Global[x][w].board[y][z].displayMark() + " ");
                    }
                    System.out.print("|"); 
                }

                System.out.println();
            }
            System.out.println("------+------+------");
        }
    }
    
    public void ShellCW()
    {
        checkWin('X');
        checkWin('O');
    }
    
    public void checkWin(Character c)
    {
        for(int i = 0; i<3; i++) //check horizontal
        {
            if(Global[i][0].isWon() && Global[i][1].isWon() && Global[i][2].isWon())
                if(Character.compare(Global[i][0].winner, c)==0 && Character.compare(Global[i][1].winner, c)==0 && Character.compare(Global[i][2].winner, c)==0)
                    winnersPodium(c);
        }
        
        for(int j = 0; j<3; j++) //check vertical
        {
            if(Global[0][j].isWon() && Global[1][j].isWon() && Global[2][j].isWon())
                if(Character.compare(Global[0][j].winner, c)==0 && Character.compare(Global[1][j].winner, c)==0 && Character.compare(Global[2][j].winner, c)==0)
                    winnersPodium(c);
        }
        
        //check both diagonals
        if(Global[0][0].isWon() && Global[1][1].isWon() && Global[2][2].isWon())
            if(Character.compare(Global[0][0].winner, c)==0 && Character.compare(Global[1][1].winner, c)==0 && Character.compare(Global[2][2].winner, c)==0)
                winnersPodium(c);
        
        if(Global[0][2].isWon() && Global[1][1].isWon() && Global[2][0].isWon())
            if(Character.compare(Global[0][2].winner, c)==0 && Character.compare(Global[1][1].winner, c)==0 && Character.compare(Global[2][0].winner, c)==0)
                winnersPodium(c);
    }
    
    public static void winnersPodium(char win)
    {
        /*char w;
        if(win == 'X') //quick solution to negate the auto swap of current player between making a move and checking the board
            w = 'O';
        else
            w = 'X';
        */
        System.out.println("/////////////////////////////////////////////////////////");
        System.out.println("db   d8b   db d888888b d8b   db d8b   db d88888b d8888b. ");
        System.out.println("88   I8I   88   `88'   888o  88 888o  88 88'     88  `8D ");
        System.out.println("88   I8I   88    88    88V8o 88 88V8o 88 88ooooo 88oobY' ");
        System.out.println("Y8   I8I   88    88    88 V8o88 88 V8o88 88~~~~~ 88`8b   ");
        System.out.println("`8b d8'8b d8'   .88.   88  V888 88  V888 88.     88 `88. ");
        System.out.println(" `8b8' `8d8'  Y888888P VP   V8P VP   V8P Y88888P 88   YD ");
        System.out.println("/////////////////////////////////////////////////////////");
        System.out.println("..........PLAYER " + win + " HAS WON THE GAME.............");
        System.exit(0);
    }
}
