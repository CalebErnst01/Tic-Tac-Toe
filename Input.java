import java.util.Scanner;
import java.util.Random;

public class Input 
{
    private Scanner s;
    private Player[] P = new Player[2]; //P[0] is X, P[1] is O
    private int currentPlayer;
    private Random RNG;
    
    public Input()
    {
        s = new Scanner(System.in);
        currentPlayer = 0;
    }
    
    public Player getPlayerEnum()
    {
        return P[currentPlayer];
    }
    
    public int getCurrPlayer()
    {
        return currentPlayer;
    }
    
    public void HumOrComp()
    {
        int playNum = 0;
        
        while(playNum < 2)
        {
            System.out.println("Is player " + (playNum+1) + " a human or computer? (H/C)");
            String option = s.next();
            
            if(option.equals("H"))
            {
                P[playNum] = Player.Human;
                playNum++;
            }
            else if(option.equals("C"))
            {
                P[playNum] = Player.Computer;
                RNG = new Random(); //initialize if computer is used
                playNum++;
            }
            else
            {
                System.out.println(option + " IS INVALID, TRY AGAIN.");
            }
        }
    }
    
    public void inputBoard(BigBoard b)
    {
        boolean invalid;
        
        do
        {
            invalid = false;
            
            System.out.println("Input board COLUMN number (0-2, inclusive).");
            b.boardCol = s.nextInt();
            System.out.println("Input board ROW number (0-2 inclusive).");
            b.boardRow = s.nextInt();
            
            if(b.boardCol < 0 || b.boardCol > 2 || b.boardRow < 0 || b.boardRow > 2)
            {
                System.out.println("COLUMN INPUT OR ROW INPUT INVALID, TRY AGAIN.");
                invalid = true;
            }       
            else if(b.Global[b.boardCol][b.boardRow].isFull())
            {
                System.out.println("SELECTED BOARD IS ALREADY FULL, INPUT ANOTHER.");
                invalid = true;
            }
                    
        } while(invalid);
    }
    
    public void compInputBoard(BigBoard b)
    {
        boolean repeat;
        
        do
        {
            repeat = false;
            
            b.boardCol = RNG.nextInt(3); //0-2
            b.boardRow = RNG.nextInt(3);
            
            if(b.Global[b.boardCol][b.boardRow].isWon() || b.Global[b.boardCol][b.boardRow].isFull()) //repeat if the selected board is already won or is complete
                repeat = true;
            
        }while(repeat);
    }
    
    public void inputSquareHuman(BigBoard b)
    {
        boolean invalid;
        int LocalCol;
        int LocalRow;
        
        do
        {
            invalid = false;
            
            System.out.println("Board [" + b.boardCol + "," + b.boardRow + "]" + " selected, please input LocalCol(0-2).");
            LocalCol = s.nextInt();
            System.out.println("Please input LocalRow (0-2).");
            LocalRow = s.nextInt();

            if(LocalCol < 0 || LocalCol > 2 || LocalRow < 0 || LocalRow > 2)
            {
                System.out.println("INVALID COLUMN OR ROW, TRY AGAIN");
                invalid = true;
            }
            else if(b.Global[b.boardCol][b.boardRow].board[LocalCol][LocalRow].isOccupied())
            {
                System.out.println("Selected Space already occupied, Try again.");
                invalid = true;
            }
            
        }while(invalid);
        
        
        b.Global[b.boardCol][b.boardRow].makeMove(getMark(), LocalCol, LocalRow);
        //b.Global[b.boardCol][LocalRow].makeMove(getMark(), b.boardRow, LocalCol);
        
        System.out.println("At Board [" + b.boardCol + "," + b.boardRow + "], mark spot [" + LocalCol +","+LocalRow+"]");

        
        b.boardCol = LocalCol; //for next turn
        b.boardRow = LocalRow; 
    }
    
    public void inputSquareComputer(BigBoard b)
    {
        boolean repeat;
        
        
        do
        {
            repeat = false;
            
            int LocalCol = RNG.nextInt(3);
            int LocalRow = RNG.nextInt(3);
            
            if(b.Global[b.boardCol][b.boardRow].board[LocalCol][LocalRow].isOccupied())
                repeat = true;
            else
            {
                b.Global[b.boardCol][b.boardRow].makeMove(getMark(), LocalCol, LocalRow);
                //b.Global[b.boardCol][LocalRow].makeMove(getMark(), b.boardRow, LocalCol); //don't ask me why this works, but somehow it does
                b.boardCol = LocalCol;
                b.boardRow = LocalRow;
            }
        } while(repeat);
    }
    
    public char getMark()
    {
        switch (currentPlayer) {
            case 0:
                currentPlayer = 1; //reseting vars for next turn
                return 'X';
            case 1:
                currentPlayer = 0; //same as comment above
                return 'O';
            default:
                System.out.println("ERROR, UNKNOWN CURRENT PLAYER");
                return '?';
        }
    }
}
