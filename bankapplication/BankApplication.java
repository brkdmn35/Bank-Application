package bankapplication;

import java.util.Scanner;


public class BankApplication {
    
    // CHANGİNG COLORS OF TEXTS
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    //CHANGİNG COLORS OF TEXTS 
  
    public static void main(String[] args) {
         
       BankList bankList=new BankList();
       CustomerList customerList=new CustomerList(bankList);
       Scanner scan=new Scanner(System.in);
       
       int choose1=0, choose2,choose3,loop=0;
       
       // Choosing Transactions
       while(choose1!=-1){
       System.out.println("\n////BANK APPLICATION////\n");
       System.out.println("(1)-Customer Transactions");
       System.out.println("(2)-Bank Branch Transactions");
       System.out.println("(3)-Customer's Money Transactions");
       System.out.println("(-1)-Finish the Program");
       System.out.print(ANSI_PURPLE+">> "+ANSI_RESET);
       choose1=scan.nextInt();
       System.out.println(ANSI_BLUE+"/////////////////////////////////"+ANSI_RESET);
       
       //Customer Transactions
       if(choose1==1){
           System.out.println("   (1)-Add Customer");
           System.out.println("   (2)-Find Customer");
           System.out.println("   (3)-Remove Customer");
           System.out.println("   (4)-List All Customers");
           System.out.println("   (5)-Update Customer Informations");
           System.out.print(ANSI_PURPLE+">> "+ANSI_RESET);
           choose2=scan.nextInt();
           System.out.println(ANSI_BLUE+"/////////////////////////////////"+ANSI_RESET);
           
           
           switch(choose2){
               case 1: {customerList.addCustomer(); break;}
               case 2: {customerList.findCustomer(); break;}
               case 3: {customerList.removeCustomer(); break;}
               case 4: {customerList.listAllCustomers(); break;}
               case 5: {
                   System.out.println("      (1)-Update Name");
                   System.out.println("      (2)-Update Last Name");
                   System.out.println("      (3)-Update Gender");
                   System.out.print(ANSI_PURPLE+">> "+ANSI_RESET);
                   choose3=scan.nextInt();
                   System.out.println(ANSI_BLUE+"/////////////////////////////////"+ANSI_RESET);
                   
                   if(choose3==1){customerList.updateName();}
                   else if(choose3==2){customerList.updateLastName();}
                   else if(choose3==3){customerList.updateGender();}
                   break;
               }
           }
       }// End of Customer Transactions
       
       //Bank Branch Transactions
       else if(choose1==2){
           System.out.println("   (1)-Add Bank Branch");
           System.out.println("   (2)-Find Bank Branch");
           System.out.println("   (3)-Remove Bank Branch");
           System.out.println("   (4)-List All Branches");
           System.out.println("   (5)-List All Customers at the Bank Branch");
           System.out.print(ANSI_PURPLE+">> "+ANSI_RESET);
           choose2=scan.nextInt();
           System.out.println(ANSI_BLUE+"/////////////////////////////////"+ANSI_RESET);
           
           switch(choose2){
               case 1: {bankList.addBank(); break;}
               case 2: {bankList.findBranch(); break;}
               case 3: {bankList.removeBank(); break;}
               case 4: {bankList.listAllBranches(); break;}
               case 5: {customerList.listAllCustomersByBranchId(); break;}
           }
           
       }
       
       else if(choose1==3){
           System.out.println("   (1)-Add Money to Customer Account");
           System.out.println("   (2)-Withdraw Money from Customer Account");
           System.out.println("   (3)-Show All Money");
           System.out.println("   (4)-Show All Money at a Branch");
           System.out.print(ANSI_PURPLE+">> "+ANSI_RESET);
           choose2=scan.nextInt();
           System.out.println(ANSI_BLUE+"/////////////////////////////////"+ANSI_RESET);
           
           switch(choose2){
               case 1: {customerList.addMoney(); break;}
               case 2: {customerList.withdrawdMoney(); break;}
               case 3: {customerList.allMoney(); break;}
               case 4: {customerList.allMoneyAtBranch(); break;}
           }
           
       }
     
       
       }
       
       
       
    }
    
}
