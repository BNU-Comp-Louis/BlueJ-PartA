import java.util.Date;

/**
 * A selection of Tickets to three different destinations.
 *
 * @author Louis Symons
 * @version (15/10/2020)
 */
public class Ticket
{
    private String destination;
    //Destination of a Ticket
    private double price;
    // This is in pence
    private Date datePurchased; 
    // Print a date of Purchase
  
    /**
     * 
     */
    public Ticket(String destination, double price)
    {
        this.price = price;
        this.destination = destination;
        datePurchased = new Date();
    }
    
    /**
     * Set Price for Ticket
     */
    public void setPrice(double price)
    {
        this.price = price;
    }
   
    /**
     * Return the value of the Ticket
     */
    public double getPrice()
    {
        return price;
    }
    
    public Date datePurchased()
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
        System.out.println(" Price:£ " + price);  
        System.out.println("Issued:" + datePurchased);
    }
    
}  