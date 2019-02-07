    
package bankapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class CustomerList {
    
    // CHANGİNG COLORS OF TEXTS
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    //CHANGİNG COLORS OF TEXTS 
    

    HashMap<Integer,Customer> customerList=new HashMap<Integer,Customer>();
    Scanner scan=new Scanner(System.in);
    BankList bankList;
    static int customerCounter=1000;
    ArrayList <Integer> emptyId=new ArrayList<Integer>();
    
     public CustomerList(BankList bl)
    {
        bankList = bl;
    }
    
 

    // Adding Customer
    public void addCustomer(){
        int customerId;
        String x;
        
        System.out.println("Enter Bank Branch ID Or Press 1 for Bank Branches List");
        System.out.print(ANSI_PURPLE+">> "+ANSI_RESET);
        int bankId=scan.nextInt(); 
        scan.nextLine();  //The access of enter, system comprehend as a number
        
        if(bankId==1){
            
            bankId=bankList.selectBank();
            
            //  If there is not any branch at system
            if(bankId==0){
                System.out.println(ANSI_RED+"!!!Please Add a Bank Branch!!!"+ANSI_RESET);
                bankList.addBank();
                bankId= bankList.selectBank(); 
            }// End of Second if     
        }// End of if
        
        // If Enter a Invalid Branch Id
         while(bankList.bankList.containsKey(bankId)==false){
            System.out.println(ANSI_RED+"!!!Please Enter a Valid Bank Branch ID!!!"+ANSI_RESET);
            bankId=scan.nextInt();
            scan.nextLine();
        }// End of While
         
        // Customer Informations
        System.out.println(ANSI_BLUE+"////CUSTOMER INFORMATIONS////"+ANSI_RESET);
        
        System.out.println("Enter Customer's Name");
        String name=scan.next();
        
        System.out.println("Enter Customer's Last Name");
        String lastName=scan.next();
        
        System.out.println("Enter Customer's Credit");
        float credit=scan.nextFloat();

        System.out.println("Enter Customer's Gender");
        String gender=scan.next();
        // End of Customer Informaitons
        
        // Create Customer ID       
        x=Integer.toString(bankId)+Integer.toString(customerCounter);
        customerId=Integer.parseInt(x);       
        //End of Create Customer ID
        if(emptyId.isEmpty()==false)
        {
           // This part use the id which is deleted account
           Customer cst=new Customer(name,lastName,credit,gender);
           customerId=emptyId.get(0);
           customerList.put(customerId, cst);
           emptyId.remove(0);
        }
        else{
          Customer cst=new Customer(name,lastName,credit,gender);
        customerList.put(customerId, cst);  
        customerCounter++;
        }
        
        
        System.out.println("\n"+ANSI_RED+"***Customer Was Added to System***"+ANSI_RESET+"\n");
        System.out.println(customerList.get(customerId).getName()+" "+customerList.get(customerId).getLastName()+"'s ID is: "+customerId);
        System.out.println(customerList.get(customerId).getName()+" "+customerList.get(customerId).getLastName()+"'s Bank Branch ID is: "+(customerId/10000));
        
        
    }// End of addCustomer
    
    
    // Find Customer
    public void findCustomer(){
        System.out.println("Enter Customer ID");
        int id=scan.nextInt();

      if(customerList.containsKey(id)==true){
        System.out.println("Name Last Name\tCredit\tGender\tCustomer Bank ID");
        System.out.println(customerList.get(id).getName()+" "+customerList.get(id).getLastName()+"\t"+customerList.get(id).getCredit()+"\t"+customerList.get(id).getGender()+(id/10000));
      }// End of if
      
      else {System.out.println(ANSI_RED+"There Is No Customer in System."+ANSI_RESET);}// End of else 
    }// End of findCustomer
    
    
    
    // Removing Customer
    public void removeCustomer(){
        int id;
        System.out.println("Enter Customer ID");
        id=scan.nextInt();
        
        if(customerList.containsKey(id)==true){
            customerList.remove(id);
            emptyId.add(id);
        }// End of if
        
        else {System.out.println("There Is No Customer in System.");}// End of else 
    }// End of removeCustomer
        

    
    // Listing All Customer at System
    public void listAllCustomers (){
    Set key=customerList.keySet();
    Iterator i= key.iterator();
        
    if (customerList.isEmpty()==false){
       
       while(i.hasNext()){
           System.out.println("Customer Bank ID\tName\tLast Name\tCredit\tGender");
           int k=(int)i.next();
           System.out.println(k+" "+customerList.get(k).getName()+" "+customerList.get(k).getLastName()+"\t"+customerList.get(k).getCredit()+"\t"+customerList.get(k).getGender());
        }// End of while
            } // End of if
        
    else {System.out.println("There Is No Customer in System.");}// End of else    
    }// End of listAllCustomers
    
    
    
    // Listing All Customers at Branch
    public void listAllCustomersByBranchId (){
    Set key=customerList.keySet();
    Iterator i= key.iterator();
    
    System.out.println("Enter Bank Branch ID");
    int bankId=scan.nextInt();
    if (customerList.isEmpty()==false){

       while(i.hasNext()){
           int m=(int)i.next();
           
           if(m/10000==bankId){
               System.out.println(customerList.get(m).getName()+" "+customerList.get(m).getLastName()+"\t"+customerList.get(m).getCredit()+"\t\t"+customerList.get(m).getGender());
           }// End of if
           
        }// End of while
    } // End of if
        
    else {System.out.println("There Is No Customer in This Bank.");}// End of else   
    }// End of listAllCustomersByBranchId
    
    
    
    // Update Name
    public void updateName(){
        System.out.println("Enter Customer ID");
        int id=scan.nextInt();
        
        if(customerList.containsKey(id)==true){
            System.out.println("Enter New Name");
            String newName=scan.next();
            
            customerList.get(id).setName(newName);
            
            System.out.println("\n***The Name Was Updated***\n");
        }// End of if
        
        else {System.out.println("Customer Couldn't Find");}// End of else    
    }// End of updateName
    
    
    
    // Update Last Name
    public void updateLastName(){
        System.out.println("Enter Customer ID");
        int id=scan.nextInt();
        
        System.out.println("Enter New Last Name");
        String newLastName=scan.next();
         
        if(customerList.containsKey(id)==true){
            customerList.get(id).setLastName(newLastName);
        }// End of if
        
        else {System.out.println("Customer Couldn't Find");}// End of else     
    }// End of updateLastName
    
    
    
    // Update Gender
    public void updateGender(){
        System.out.println("Enter Customer ID");
        int id=scan.nextInt();
        
        System.out.println("Enter New Gender");
        String newGender=scan.next();
         
        if(customerList.containsKey(id)==true){
            customerList.get(id).setGender(newGender);
        }// End of if
        
        else {System.out.println("Customer Couldn't Find");}// End of else    
    }// End of updateGender
    
    
    
    // Adding Money to Customer Account
    public void addMoney(){
        System.out.println("Enter Customer ID");
        int id=scan.nextInt();
        
        if(customerList.containsKey(id)==true){        
        System.out.println("Enter Amount");
        float money=scan.nextFloat();
        customerList.get(id).setCredit(money);
        System.out.println(ANSI_GREEN+money + "Added to "+customerList.get(id).getName()+"'s Account"+ANSI_RESET);
        
        }// End of if
        
       else {System.out.println("Customer Couldn't Find.");}// End of else    
    }// End of addMoney
    
    
    
    // Withdrawing Money from Customer Account
    public void withdrawdMoney(){
        System.out.println("Enter Customer ID");
        int id=scan.nextInt();
        
        
        
        if(customerList.containsKey(id)==true){
            System.out.println("Enter Amount");
            float money=scan.nextFloat();
            
           if(customerList.get(id).getCredit()-money>0)
           {
            customerList.get(id).setCredit(-money);
           System.out.println(money + "Withdrew from "+customerList.get(id).getName()+"'s Account");
           }
           else
               System.out.println("There is not Enough Account Balance.");
       
        }// End of if
        
        else {System.out.println("Customer Couldn't Find.");}// End of else   
    }// End of withdrawMoney
    
    
    
    // Show All Money at System
    public void allMoney(){
    Set key=customerList.keySet();
    Iterator i= key.iterator();
    
    float allMoney=0;
    
    if (customerList.isEmpty()==false){

       while(i.hasNext()){
           int m=(int)i.next();
           allMoney=allMoney+customerList.get(m).getCredit();          
        }// End of while
    } // End of if
        
   else {System.out.println("There Is No Customer in This Bank.");}// End of else 
    
    System.out.println("There Is "+allMoney+"$ at All Bank");
    }// End of allMoney
    
    
    
    // Show All Money at Branch
    public void allMoneyAtBranch (){
    Set key=customerList.keySet();
    Iterator i= key.iterator();
    
    System.out.println("Enter Bank Branch ID");
    int bankId=scan.nextInt();
    float allMoney=0;
    
    if (customerList.isEmpty()==false){

       while(i.hasNext()){
           int m=(int)i.next();
           
           if(m/10000==bankId){
               allMoney=allMoney+customerList.get(m).getCredit();
           }// End of Second if     
        }// End of while
    } // End of if
        
    else {System.out.println("There Is No Customer in This Bank.");}// End of else 
    
    System.out.println("There Is "+allMoney+"$ at All at "+ bankList.bankList.get(bankId));  
    }//End of allMoneyAtBranch
}
