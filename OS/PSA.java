
//PSA process stratigy algorithem 
public class PSA {
    private String ProcessID;
    private int arrivalTime;
    private int brustTime;
    private int startTime;
    private int termintionTime;
    private int waitTime;
    private int responseTime;
    private int turnaroundTime;
    private int originalBurstTime;

    public PSA (String ProcessID,int arrivalTime,int brustTime){
    this.ProcessID=ProcessID;
    this.arrivalTime=arrivalTime;
    this.brustTime=brustTime;
    this.startTime=-1;
    this.termintionTime=-1;
    this.turnaroundTime=0;
    this.waitTime=0;
    this.responseTime=0;
    this.originalBurstTime=brustTime;
    }
    
    public String getProcessID(){
        return ProcessID;
    }
    public void setProcessID(String id){
        ProcessID=id;
    }
    public int getbrustTime(){
        return brustTime;
    }
    public void setbrustTime(int b){
        brustTime=b;
    }
    public int getOriginalBurstTime() {
        return originalBurstTime;  // Return the original burst time (unchanged)
    }
    public int getstartTime(){
        return startTime;
    }
    public void setstartTime(int s){
        startTime=s;
    }
    public int getTermintionTime(){
        return termintionTime;
    }
    public void setTermintionTime(int t){
        termintionTime=t;
    }
    public int getwaitTime(){
        return waitTime;
    }
    public void setwaitTime(int w){
        waitTime=w;
    }
    public int getresponseTime(){
        return responseTime;
    }
    public void setresponseTime(int r){
        responseTime=r;
    }
    public int getTurnaroundTime(){
        return turnaroundTime;
    }
    public void setTurnaroundTime(int t){
        turnaroundTime=t;
    }
    public int getArrivalTime(){
        return arrivalTime;
    }
    public void setarrivalTime(int a){
        arrivalTime=a;
    }

    @Override
    public String toString() {
        return "ID: "+ProcessID+" arraivale time: "+ arrivalTime+" brust time: "+brustTime;
        
    }
}
