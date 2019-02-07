package bankapplication;

public class Customer {
    private String gender;
    private String name;
    private String lastName;
    private float credit;
    private int customerId;
    
    public Customer( String inputName, String inputLastName, float inputCredit, String inputGender){
        credit=inputCredit;
        gender=inputGender;
        name=inputName;
        lastName=inputLastName;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String inputName){
        name=inputName;
    }
    
    
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String inputLastName){
        lastName=inputLastName;
    }
    
    
    public float getCredit(){
        return credit;
    }
    public void setCredit(float inputCredit){
        credit=credit+inputCredit;  
    }  
    
    
    public String getGender(){
        return gender;
    }
    public void setGender(String inputGender){
        gender=inputGender;
    }
    
    public int getId(){
        return customerId;
    }
      
}
