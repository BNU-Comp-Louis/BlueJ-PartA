
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Student Name
 * @version 0.1
 */
public class StockApp
{
    public static final char CLEAR_CODE = '\u000c';
    
    public static final String QUIT = "quit";
    public static final String ADD = "add";
    public static final String PRINT_ALL = "printall";
    public static final String REMOVE = "remove";
    public static final String DELIVER = "deliver";
    // Use to get user input
    private InputReader input;
    
    private StockManager manager;
    
    private StockDemo demo;
    
    public StockApp()
    {
        this.input=new InputReader();
        this.manager=new StockManager();
        this.demo = new StockDemo(manager);
    }

    /**
     * 
     */
    public void run()
    {
           {
         boolean finished = false;
        
            while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = input.getString().toLowerCase();
            if(choice.equals(QUIT))
                finished = true;
            else
                executeMenuChoice(choice);
        }
            }
    }
    

    private void executeMenuChoice(String choice)
    {
         switch (choice) {
            case ADD:
                addProduct();
                break;
            case PRINT_ALL:
                manager.printAllProducts();
                break;
            case REMOVE:
                removeProduct();
                break;
            case DELIVER:
               deliverProduct();
            default:
            System.out.println("Commmand Cannot be found");
            
         }
    }
    
    private void deliverProduct()
    {
       System.out.println("Enter ID of Product for Delivery");
       int id = input.getInt();
    }
    
    private void removeProduct()
    {
        System.out.println("Removing a Product\n");
        
        System.out.println("Please Enter the Product ID");
        int id = input.getInt();
        
        manager.removeProduct(id);
        System.out.println("This Product has been Removed");
        
        System.out.println();
    }
    
    private void addProduct()
    {
        System.out.println("Adding new product\n");
        
        System.out.println("Please enter the product ID");
        int id = input.getInt();
        
        System.out.println("Please enter the name of the product");
        String name = input.getString();
        
        Product product = new Product(id , name);
        manager.addProduct(product);
        
        System.out.println();
    }
    
    
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    PrintAll:   Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        //System.out.println(CLEAR_CODE);
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Louis Symons");
        System.out.println("******************************");
    }

   
}   
