
package newpackage;




public class Slot {
    private String startTime;
    private String endTime;
    Slot(String s, String e)
    {
        startTime=s;
        endTime=e;
    }
    Slot()
    {
        
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
}
