package bankapplication;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class BankList {
    
    // CHANGİNG COLORS OF TEXTS
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    //CHANGİNG COLORS OF TEXTS 
    
    Scanner scan=new Scanner(System.in);
    HashMap<Integer,String> bankList=new HashMap<Integer,String>();
    static int bankCounter=1000;
    
    
    
    
    // Adding Bank Branch to System
    public void addBank(){
        System.out.println("Enter Bank Branch's Name");
        System.out.print(ANSI_PURPLE+">> "+ANSI_RESET);
        String branchName=scan.nextLine();
        
        bankList.put(bankCounter, branchName);
        
        System.out.println("\n"+ANSI_GREEN+"***Bank Branch Was Added to System***"+ANSI_RESET+"\n");
        System.out.println(branchName+"'s ID is "+bankCounter);
        
        bankCounter++;   
    }// End of Add Bank Branch
    
    
    //Removing Bank Branch
    public void removeBank(){
        System.out.println("Enter Bank ID");
        System.out.print(ANSI_PURPLE+">> "+ANSI_RESET);
        int bankId=scan.nextInt();
        
        if(bankList.containsKey(bankId)==true){
            System.out.println("\n"+ANSI_RED+"***"+bankList.get(bankId)+" Removed from System***"+ANSI_RESET+"\n");
            bankList.remove(bankId);
        }// End of if
        
        else {System.out.println(ANSI_RED+"Bank Branch Couldn't Find"+ANSI_RESET);}// End of Else
    }// End of removeBank
    
    
    //Choosing Bank Branch
    public int selectBank(){
        Set s=bankList.keySet();
        Iterator it=s.iterator();
        int choose;
        
        if(bankList.isEmpty()==false){
        System.out.println(ANSI_BLUE+"     ***Bank Branches List***"+ANSI_RESET);
        System.out.println(ANSI_CYAN+"Branch ID\tBranch Name"+ANSI_RESET);
        
            // Listing All Branches
            while(it.hasNext()){
            int k=(int)it.next();
            System.out.println(k+"\t\t"+bankList.get(k));
            }// End of While
        }// End of if
       
        else{
            System.out.println("!!!There is not any Bank Branch in System!!!");
            return 0;
        }// End of Else
       
        // Choosing Bank Branch
       System.out.println("\nEnter Bank Branch ID");
       System.out.print(ANSI_PURPLE+">> "+ANSI_RESET);
       choose=scan.nextInt();
       return choose;     
    }// End of selectBank
    
    
    // Listing All Branches
    public void listAllBranches (){
    Set key=bankList.keySet();
    Iterator i= key.iterator();
        
    if (bankList.isEmpty()==false){
       System.out.println("          ***Bank Branches List***");
       System.out.println("Branch ID\tBranch Name");
           while(i.hasNext()){
           int k=(int)i.next();
           System.out.println(k+"\t\t"+bankList.get(k));
           }// End of while
    } // End of if
        
    else {System.out.println("There is not any Branch in System.");}// End of else 
    }// End of listAllBranches
    
    
    // Find Bank Branch
    public void findBranch(){
        System.out.println("Enter Bank ID");
        System.out.print(ANSI_PURPLE+">> "+ANSI_RESET);
        int bankId=scan.nextInt();
        
        if(bankList.containsKey(bankId)==true){
            System.out.println(bankId+"\t"+bankList.get(bankId));
        }// End of if
        
        else {System.out.println("Branch Couldn't Find");}// End of Else
    }// End of findBranch
    
}
