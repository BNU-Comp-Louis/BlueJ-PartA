import java.util.Date;

/**
 * A selection of Tickets to three different destinations, 
 * price and the date and time purchased
 *
 * @author Louis Symons
 * @version (15/10/2020)
 */
public class Ticket
{
    //Fields 
    private String destination;
    //Destination of a Ticket
    private int price;
    // This is in pence
    private Date datePurchased; 
    // Print a date of Purchase
  
    /**
     * Destination and price of a ticket with date. 
     */
    public Ticket(String destination, int price)
    {
        this.price = price;
        this.destination = destination;
        datePurchased = new Date();
    }
    
    /**
     * Set Price for Ticket
     */
    public void setPrice(int price)
    {
        this.price = price;
    }
   
    /**
     * Return the value of the Ticket
     */
    public int getPrice()
    {
        return price;
    }
    
    public Date datePurchased()
    /**
     * Will show the date and time of purchase
     */
    {
        return datePurchased;
    }
    
     /**
     * Return the destination 
     */
    public String getDestination()
    {
        return destination;
    }
    /**
     * Method to print destination, price and date of issue.
     */
    public void print()
    {
        System.out.print("Destination: " + destination);
        System.out.println("Price:" + price + "pence");  
        System.out.println("Issued:" + datePurchased);
    }
    
}  