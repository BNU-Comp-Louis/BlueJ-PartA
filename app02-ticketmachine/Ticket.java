import java.util.Date;
/**
 * Write a description of class Ticket here.
 *
 * @author (Louis Symons)
 * @version (10/10/)
 */
public class Ticket
{
    // Fields 
    
    private String destination;
    
    private Date issueDateTime;
    
    private int price; 
    
    


    /**
     * Constructor for objects of class Ticket
     * Train Ticket destiniation and price. 
     * the date will be the current date of issue. 
     */
    public Ticket(String destination, int price)
    {
      this.destination = destination;
      this.price = price; 
      
      issueDateTime = new Date();
      
    }
    
    /**
     * Print Method for Ticket information (insert more info)
     */
    public void print()
    {
        System.out.println ( " Ticket " + destination + price + " Price " + " Issued " + issueDateTime);
    }    


}