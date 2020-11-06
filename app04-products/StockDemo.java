import java.util.Random;
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author Louis Symons.
 * @version 30/10/2020
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;
    
    
    private Random generator;
    
    private String name = "Samsung Galaxy"; 
    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo(StockManager manager)
    {
        if(name.startsWith("samsung"))
        {
            System.out.println();
        }
        
        generator = new Random();
        this.manager = manager;
        
        
        
        manager.addProduct(new Product(100, "Clock Radio"));
        manager.addProduct(new Product(101,  "Mobile Phone"));
        manager.addProduct(new Product(102,  "Microwave Oven"));
        manager.addProduct(new Product(103, "Clock Radio"));
        manager.addProduct(new Product(104,  "Mobile Phone"));
        manager.addProduct(new Product(105,  "Microwave Oven"));
        manager.addProduct(new Product(106, "Clock Radio"));
        manager.addProduct(new Product(107,  "Mobile Phone"));
        manager.addProduct(new Product(108,  "Microwave Oven"));
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    //add 10 items for demo items 
    
    public void runDemo()
    {
        // Show details of all of the products.
        manager.printAllProducts();
        // Take delivery of 5 items of one of the products.
        demoDelivery();
        demoDelivery();
        manager.printAllProducts();
        
        demoDelivery();
        manager.printAllProducts();
    }
    
    private void demoDelivery()
    {
        printHeading();
        int amount = 0;
        for (int id = 101; id <= 112; id++)
        {
         amount = generator.nextInt(7) + 1;
         manager.deliverProduct(id, amount); 
         amount++;
        }
        
    }
    
    private void demoSell()
    {
        int amount = 0;
        for (int id = 101; id <= 112; id++)
        {
         amount = generator.nextInt(7) + 1;
         manager.deliverProduct(id, amount); 
         amount++;
        }
 
    }
    
    public void printHeading()
    {
        System.out.println("Demonstrating Delivery of Products");
        System.out.println();
    }
    
}


