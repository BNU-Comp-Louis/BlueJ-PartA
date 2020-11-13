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
    //Random number generator
    private Random generator;
    
    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo(StockManager manager)
    {
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
        manager.addProduct(new Product(108,  "LG Mobile"));
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
        manager.printHeading();
        manager.printAllProducts();
        demoDelivery();
        demoSell();
        System.out.println();
        manager.printHeading();
        System.out.println();
        manager.printAllProducts();
        System.out.println();
    }
    
    /**
     * Random generator to deliver products within the set range of product ID's
     */
    private void demoDelivery()
    {
        printHeading("Delivery");
        int amount = 0;
        for (int id = 101; id <= 112; id++)
        {
         amount = generator.nextInt(7) + 1;
         manager.deliverProduct(id, amount); 
         amount++;
        }
        System.out.println();
    }
    
    /**
     * Random generator to sell products within the set range of product ID's 
     */
    private void demoSell()
    {
        printHeading("Selling");
        
        int amount = 0;
        
        for(int id = 101; id <= 112; id++)
        {
            amount = generator.nextInt(7) + 1;
            manager.sellProduct(id, amount);
            System.out.println();
        }
    }  
    
    /**
     * Print heading for delivery and selling methods. 
     */
    public void printHeading(String verb)
    {
        System.out.println();
        System.out.println("Demonstrating " + verb + " of Products");
        System.out.println();
    }
}


