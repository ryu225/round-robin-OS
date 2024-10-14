dd
package OS;
import java.io.*;
import java.util.*;

public class RR {

    static Scanner in=new Scanner(System.in);
    static List<PSA> q1= new ArrayList<>();
    static List<PSA> q2= new ArrayList<>();
    static List<PSA> gantChart= new ArrayList<>();
    static int ProcessID=0;
    static int currentTime=0;
    static boolean terminated =true;

    public static void main(String[] args){
        int NOProceses=0;
        try{

            System.out.println("enter number of processes: ");
            NOProceses=in.nextInt();
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
                System.out.println("\nEnter Process "+(ProcessID+1)+" details:");
                try{
                    System.out.println("Enter process arrival time: ");
                    int arrivalTime=in.nextInt();
                    while (arrivalTime < 0) {
                        System.out.print("Illegal number of arrivalTime,reEnter:");
                        arrivalTime = in.nextInt();
                    }
                    System.out.println("Enter process brust time: ");
                    int brustTime=in.nextInt();
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
            System.out.println();
    }
    public RR (){
        PSA curProcess= q1.remove(0);
        
    }
}
