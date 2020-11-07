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
        
        
        
        manager.addProduct(new Product(100, "Samsung Mobile"));
        manager.addProduct(new Product(101,  "Apple Mobile"));
        manager.addProduct(new Product(102,  "Razer Mobile"));
        manager.addProduct(new Product(103, "Samsung Tv"));
        manager.addProduct(new Product(104,  "Apple Mac"));
        manager.addProduct(new Product(105,  "Xbox "));
        manager.addProduct(new Product(106, "Playstation"));
        manager.addProduct(new Product(107,  "Alienware Laptop"));
        manager.addProduct(new Product(108,  "Lg Mobile"));
        manager.addProduct(new Product(109,  "LG Tv "));
        manager.addProduct(new Product(110, "Apple iPad"));
        manager.addProduct(new Product(111,  "Sony Tv"));
        manager.addProduct(new Product(112,  "Lenovo Laptop"));
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    
    
    public void runDemo()
    {
        // Show details of all of the products.
        manager.printAllProducts();
        // Take delivery of 5 items of one of the products.
        demoDelivery();
        demoSell();
        manager.printAllProducts();
    }
    
    private void demoDelivery()
    {
        printHeading("delivery");
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
        printHeading("Sell");
        
        int amount = 0;
        
        for(int id = 101; id <= 112; id++)
        {
            amount = generator.nextInt(7) + 1;
            manager.sellProduct(id, amount);
        }
    }  
    
    public void printHeading(String verb)
    {
        System.out.println();
        System.out.println("Demonstrating Delivery of Products");
        System.out.println();
    }
    
}


