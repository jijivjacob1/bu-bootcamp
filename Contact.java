import java.util.ArrayList;


public class Contact { 
 
    // FIELDS: the data each Contact object holds 
    private String  name; 
    private String  phone; 

 
    // CONSTRUCTOR: runs when you write new Conact(...) 
    public Contact(String name, String phone) { 
        this.name   = name;     // 'this.name' is the field; 'name' is the parameter 
        this.phone = phone; 
      
    } 
 
    // GETTERS: controlled read access to private fields 
    public String  getName()   { return name; } 
    public String  getPhone() { return phone; } 

 
    // TOSTRING: what prints when you System.out.println(employee) 
    @Override 
    public String toString() { 
        return name + " | " + phone; 
    } 

     public static void main(String[] args) {

        // An ordered list of conatact to test 
        ArrayList<Contact> contacts = new ArrayList<>(); 
        contacts.add(new Contact("Ada Lovelace", "1 678 778 6789")); 
       

        for (Contact cntct : contacts) { 
            System.out.println(cntct);   // calls toString automatically 
        }

       
     }
} 
