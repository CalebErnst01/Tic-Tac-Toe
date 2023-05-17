public class Driver 
{
    //declarations
    public static BigBoard BB;
    public static Input in;
    
    
    public static void main(String args[])
    {
        //basic initializations
        BB = new BigBoard();
        in = new Input();
        
        in.HumOrComp();
        
        
        gameplay();
        
    }
    
    public static void gameplay()
    {
        while(!BB.allFull())
        {
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("PLAYER " + (in.getCurrPlayer()+1) + ": ");
            
            if(in.getPlayerEnum() == Player.Human && ( (BB.boardCol == null && BB.boardRow == null) || BB.Global[BB.boardCol][BB.boardRow].isFull()) ) //if 1st turn or you've been sent to full board
            {
                in.inputBoard(BB);
            }
            else if(in.getPlayerEnum() == Player.Computer && ( (BB.boardCol == null && BB.boardRow == null) || BB.Global[BB.boardCol][BB.boardRow].isFull() ))
            {
                System.out.println("-- COMPUTER THINKING ABOUT IT'S NEXT MOVE --");
                in.compInputBoard(BB);
            }
            
            if(in.getPlayerEnum() == Player.Human)
                in.inputSquareHuman(BB);
            else
                in.inputSquareComputer(BB);
                
            BB.printBoard();
            BB.ShellCW();
        }
        
        System.out.println("GAME HAS ENDED IN A COMPLETE TIE!");
    }
    
}