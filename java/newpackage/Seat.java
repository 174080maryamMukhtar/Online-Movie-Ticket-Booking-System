
package newpackage;


public class Seat {
    private int seatNumber;
    private boolean status;
    Seat(int n)
    {
        seatNumber=n;
        status=true;    //free 
    }
    Seat()
    {
        
    }
    boolean isFree()
    {
        return isStatus();
    }
    boolean isTaken()
    {
        if(isStatus()==true)    //not taken
        {
            return false;
        }
        return true;
    }
    void setStatus(boolean s)
    {
        status=s;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isStatus() {
        return status;
    }
    
}
