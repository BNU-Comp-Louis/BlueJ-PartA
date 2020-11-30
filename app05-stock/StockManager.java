import java.util.ArrayList;
import java.util.*;
/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Louis Symons
 * @version (30/10/2020)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;
    
    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
        
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public boolean addProduct(Product item)
    {
        if(isProductIDExist(item.getID()))
        {
            System.out.println("This Product ID already Exists");
            return false;
        }
        else
        {
            stock.add(item);
            System.out.println("\n You Have Added " + item);
            return true;
        }
        
    }
    
    /**
     * Change a Products name
     */
    public void changeName(int id, String newName)
    {
        Product product = findProduct (id);
        if (product !=null)
        {
            product.changeName(newName);
           
        }
        else
        {
            System.out.println("Product ID not found");
        }
            
    }
    
    /**
     * Remove a product from the list
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);
        if (product !=null)
        {
            stock.remove(product);
            System.out.println(product);
            
        }
        else
        {
            System.out.println("Product ID not found");
        }
    }
    
    /**
      * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void deliverProduct(int id, int amount)
    {
        Product product = findProduct(id);
        if(product != null)
        {
        
            product.increaseQuantity(amount);
            System.out.println("Product delivered :" + product);
        }
        else
        {
            System.out.println("Product ID" + id + "NOT FOUND!!!");
        }
    }
    
    /**
     * Search for a word within the product name
     */
    public void search(String word)
    {
    ArrayList<Product> result = new ArrayList<Product>();
    for(Product product : stock) 
        { 
            String productName = product.getName().toLowerCase();
           if(productName.contains(word.toLowerCase()))  
            { 
                printProduct(product.getID());
                result.add(product);                
            }
        }
    if(result.size() == 0)
        {
            System.out.println("There is no product name`s consisting the word: " + word);
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
     public Product findProduct(int id)
    {
        for(Product product : stock)
        {
            if(product.getID()== id)
            {
                return product;
            }
        }
        return null;
    } 
    
    public boolean isProductIDExist(int id)
    {
          for(Product product : stock)
        {
            if(product.getID()== id)
            {
                return true;
            }
        }
        return false;
    }
        
    /**
      * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
     public void sellProduct(int id, int amount )
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            printDetails(id);
            product.sell(amount);
        }
        else
        {
            System.out.println("Product ID not found");
        }    
    }
    
    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printDetails(int id)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        return 0;
    }
    
    /**
     * Method to check if there is any 
     */
     private ArrayList<Product> getLowStock() 
    {
        ArrayList<Product> result = new ArrayList<Product>();
        for (Product product : stock) {
            if(product.getQuantity() <= 1)
            {
                result.add(product);
            }
        }
        return result;
    }
    
    /**
     * Restock proudcts that are low stock 
     */
    public void reStockProducts()
    {
        ArrayList<Product> lowStockProducts=getLowStock();
        if (!lowStockProducts.isEmpty()){
            System.out.println("Re Stocking Low Stocked Products");
            for (Product product : lowStockProducts) {
                product.increaseQuantity(1);
                printProduct(product.getID());
            }
        }
        else System.out.println("No Products Currently Low Stock");
    }

    /**
     * Print any products that have a stock level 
     */
    public void printLowStock()
    {
        ArrayList<Product> products = getLowStock();

        if(products.size() > 0)
        {
            for (Product product : products) {
                System.out.println(product);
            }
        }
        else
        {
            System.out.println("Currently no Products have low stock");
        }
    }
    
    /**
     * Print details of all the products.
     */
    public void printAllProducts()
    {
        for(Product product : stock)
        {  
            System.out.println(product);  
        }
    }
    
    /**
     * Print a product using its ID
     */
      public void printProduct(int id)
    {
        Product product = findProduct(id);
        if (product !=null)
        {
            System.out.println(product);
        }
        else 
        {
            System.out.println("Product ID : " + id+ " cannot be found");
        }
    }
    
    /**
     * Heading for print message
     */
    public void printHeading()
    {
        System.out.println("********");
        System.out.println("********");
        System.out.println("Louis's Stock List");
        System.out.println("********\n");
    }
}
