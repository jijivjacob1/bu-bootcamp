import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ContactManager {

    public static void searchContact(Map<String, Contact> contacts,String searchKey) {
       Contact checkContact = contacts.get(searchKey);               

        if (null == checkContact)
            System.out.println("Conatact not found ");
        else
            System.out.println("Contact found: " + checkContact);
    }

    public static void printContacts(Map<String, Contact> contacts) {

        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());

        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));  


        System.out.println("=== All Contacts ===");

        for (Contact contact : sorted) {
            
            System.out.println(contact);
        }
    }


    
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 

        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101")); 
        contacts.put("Sonal Lovelace", new Contact("Sonal Lovelace", "+1 617 855 1101"));
        contacts.put("Asha Borde", new Contact("Asha Borde", "+1 512 555 0101"));
        contacts.put("Tom Hanks", new Contact("Tom Hanks", "+1 512 855 0101"));
        contacts.put("Jessica Lovelace", new Contact("Jessica Lovelace", "+1 512 955 0101"));
 

        searchContact(contacts,"Tom"); //contact does not exists
        searchContact(contacts,"Asha Borde"); //contact exists

 
        // Step 6: print sorted list 

        printContacts(contacts);

        //remove conatact and print
        contacts.remove("Sonal Lovelace"); 

        printContacts(contacts);


    } 
}
