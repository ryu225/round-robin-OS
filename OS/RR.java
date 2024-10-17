//import java.io.*;
import java.util.*;

public class RR {

    static Scanner in=new Scanner(System.in);
    
    //static List<PSA> q2= new ArrayList<>();
    static List<PSA> gantChart= new ArrayList<>();
    static int ProcessID=0;
    static int currentTime=0;
    //static boolean terminated =true;

    private static final int QTime=2;
    //private static double TotalTime=0;
    static List<PSA> q1= new ArrayList<>();
    

    public static void main(String[] args){
        double totalWaitingTime=0,totalTurnaroundTime=0;
        int NOProceses=0;
        try{

            System.out.print("Number of processes=");
            String input = in.next().trim();
            NOProceses=Integer.parseInt(input); 

            System.out.print("(");
            for(int i=1; i<=NOProceses;i++){
                System.out.print("p"+i);
                if (i!=NOProceses)
                System.out.print(", ");}
            System.out.print(")");

            if (NOProceses<=0)
                throw new IllegalArgumentException(" Number of process can not be zero or negative.");
             } catch(InputMismatchException e){System.out.println("Input mismatch! please only enter integers./n try again: ");
                in.next();
            }catch(IllegalArgumentException e){
                System.out.println("Invalid input: "+e.getMessage());
                while(NOProceses<0){
                    System.out.println("Illegal Number of processes, reEnter: ");
                    NOProceses=in.nextInt();}
            }

            for (int i =0; i<NOProceses; i++){
                System.out.print("\nArrival times and burst times as follows:");
                try{
                    System.out.print("\nP"+(i+1)+": Arrival time = ");
                    String input = in.next().trim();
                    int arrivalTime=Integer.parseInt(input);
                    while (arrivalTime < 0) {
                        System.out.print("Illegal number of arrivalTime,reEnter:");
                        arrivalTime = in.nextInt();
                    }
                    System.out.print(", Burst time = ");
                    String input2 = in.next().trim();
                    int brustTime=Integer.parseInt(input2);
                    while (brustTime < 0) {
                        System.out.print("Illegal number of brust Time,reEnter:");
                        brustTime = in.nextInt();
                    }

                    PSA process= new PSA("P"+ ++ProcessID, arrivalTime, brustTime);
                    q1.add(process);
                }catch (InputMismatchException e){
                    System.out.println("Some of your inputs are mismatched! Only integers allowed. \nPlease enter again: ");
				    in.next();
				    i--;} 
            }
            
            System.out.println("Scheduling Algorithm: Round Robin (Time Quantum = "+QTime+")");
            System.out.println("Time\tProcess");
            PSA curProcess;
            while(!q1.isEmpty()){
                
                curProcess=RoundRobin();
                totalTurnaroundTime += curProcess.getTurnaroundTime();  
                totalWaitingTime += curProcess.getwaitTime();
            }
                for (int i = 0; i < gantChart.size(); i++) {
                    PSA process = gantChart.get(i);
                    // Print the arrival time for each process
                    System.out.println(process.getArrivalTime()+"-"+process.getbrustTime()+"\t"+process.getProcessID());
            }
            
            double avgTurnaroundTime = (double) totalTurnaroundTime / NOProceses;
            double avgWaitingTime = (double) totalWaitingTime / NOProceses;
            double cpuUtilization = 100;

            System.out.printf("Average Turnaround Time:  %.2f\n", avgTurnaroundTime);
            System.out.printf("Average Waiting Time:  %.2f\n", avgWaitingTime);
            System.out.println("CPU Utilization: " + cpuUtilization );
            
            
            }
        
    
    public static PSA RoundRobin() {
        PSA secProcess, curProcess = q1.remove(0); 
    
       
        if (curProcess.getstartTime() == -1) {
            curProcess.setstartTime(currentTime);
        }
    
        int burstTime = curProcess.getbrustTime(); 
        int executionTime = Math.min(burstTime, QTime); 
        int startTime = currentTime; 
        currentTime += executionTime; 
        int endTime = currentTime; 
    
        
        curProcess.setbrustTime(burstTime - executionTime);
    
        
        gantChart.add(secProcess=new PSA(curProcess.getProcessID(), startTime, endTime));
        
        
        if (curProcess.getbrustTime() > 0) {
            q1.add(curProcess); 
        } else {
            
            curProcess.setTermintionTime(currentTime);
            curProcess.setTurnaroundTime(curProcess.getTermintionTime() - curProcess.getArrivalTime());
            curProcess.setwaitTime(curProcess.getTurnaroundTime() - curProcess.getOriginalBurstTime());
            curProcess.setresponseTime(curProcess.getstartTime() - curProcess.getArrivalTime());
            //bc the constructor of PSA doesnt enclude theotehr vars 
            secProcess.setwaitTime(curProcess.getwaitTime());
            secProcess.setTurnaroundTime(curProcess.getTurnaroundTime());
            secProcess.setresponseTime(curProcess.getresponseTime());
            secProcess.setstartTime(curProcess.getstartTime());
            secProcess.setTermintionTime(curProcess.getTermintionTime());
            
        }
    
        return curProcess; // Return the current process 
    }
    
    
    
}

