import java.lang.String;
import java.util.*;
/**
 * Model some details of a product sold by a company.
 * 
 * @author Louis Symons.
 * @version 30/10/2020
 */
public class Product
{
    // An identifying number for this product.
    private int id;
    // The name of this product.
    private String name;
    // The quantity of this product in stock.
    private int quantity;

    /**
     * Constructor for objects of class Product.
     * The initial stock quantity is zero.
     * @param id The product's identifying number.
     * @param name The product's name.
     */
    public Product(int id, String name)
    {
        this.id = id;
        this.name = name;
        quantity = 0;
    }

    /**
     * @return The product's id.
     */
    public int getID()
    {
        return id;
    }

    /**
     * @return The product's name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method to change the name of a product.
     */
    public void changeName(String changeName)
    {
        this.name = changeName;
    }
    
    /**
     * @return The quantity in stock.
     */
    public int getQuantity()
    {
        return quantity;
    }
    
    /**
     * Method to check if a product has a low stock level
     */
    public boolean lowStock()
    { 
        if(getQuantity() <=3)
     {
        return true;
     }
     else
     {
        return false;
     }
    }
    
    /**
      * Method to get low stock 
     */
     public void getLowStock()
     {
        if (lowStock() == true)
        {
            
        {
            System.out.println("Product has low stock level: " + id + " " + getQuantity()
            + "in stock");
        }
     }
    }

    /**
     * @return The id, name and quantity in stock.
     */
    @Override
    public String toString()
    {
        return id + ": " +  name + " stock level: " + quantity;
    }

    /**
     * Restock with the given amount of this product.
     * The current quantity is incremented by the given amount.
     * @param amount The number of new items added to the stock.
     *               This must be greater than zero.
     */
    public void increaseQuantity(int amount)
    {
        if(amount > 0) 
        {
            quantity += amount;
        }
        else 
        {
            System.out.println("Attempt to restock " + name +
                               " with a non-positive amount: " + amount);
        }
    }

    /**
     * Sell one of these products.
     * An error is reported if there appears to be no stock.
     */
    public void sell(int amount)
    {
        if(amount < 0)
        {
            System.out.println("The amount cannot be negative number");
        }
     
        else if(quantity >= amount) 
        {
            quantity-= amount;
            System.out.println("Sold " + amount + " of " + name);
            System.out.println("Transation Complete");
        }
        else if(amount > quantity)
        {
            System.out.println("Attempt to sell an out of stock item: " + "In Stock " + 
            quantity + " Ordered Amount : " + amount);
            System.out.println("We only have : " + quantity + " Currently in Stock");
            System.out.println("Please only order the amount we have in stock");
        }
    }
    
    /**
     * Method to set the name of a product.
     */
    public void setName(String name)
    {
        this.name = name;
    }
}
