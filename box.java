public class box 
{
    private char display;
    private boolean occupied;
    
    public box()
    {
        display = '-';
        occupied = false;
    }
    
    public void markBox(char a)
    {
        display = a;
        occupied = true;
    }
    
    public void swapIdle() //for when board is now won, yet space is still blank
    {
        display = '*';
    }
    
    public boolean isOccupied(){ return occupied;}
    public char displayMark(){ return display;}
}
