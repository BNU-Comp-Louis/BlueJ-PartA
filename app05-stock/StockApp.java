
/**
 * This app provides a user interface to the stock manager so that users can
 * add, edit, print and remove stock products
 *
 * @Louis Symons
 * @version (15/11/2020)
 */

public class StockApp {
    public static final char CLEAR_CODE = '\u000c';
    public static final String QUIT = "quit";
    public static final String ADD = "add";
    public static final String PRINT_ALL = "printall";
    public static final String REMOVE = "remove";
    public static final String DELIVER = "deliver";
    public static final String SEARCH = "search";
    public static final String LOW_STOCK = "lowstock";
    public static final String RE_STOCK = "restock";
    public static final String SELL = "sell";
    private InputReader input;
    private StockManager manager;
    
    /**
     * Use to get users input and previous features from manager.
     */
    public StockApp() {
        this.input = new InputReader();
        this.manager = new StockManager();
        new StockDemo(manager);
    }

    /**
     * Running the application
     */
    public void run() {
        {
            boolean finished = false;

            while (!finished) {
                printHeading();
                printMenuChoices();

                String choice = input.getString().toLowerCase();
                if (choice.equals(QUIT))
                    finished = true;
                else
                    executeMenuChoice(choice);
            }
        }
    }
    
    /**
     * Method to execute the users input via the menu choices provivded 
     */
    private void executeMenuChoice(String choice) {
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
                break;
            case SEARCH:
                searchProduct();
                break; 
            case LOW_STOCK:
                printLowStock();
                break;  
            case RE_STOCK:
                manager.reStockProducts();
                break; 
            case SELL:
                sellProduct();
                break;
            default:
                System.out.println("Menu choice Cannot be found");

        }
    }
    
    /**
     * Method to sell Products
     */
    private void sellProduct()
    {
        System.out.println("Please Enter the ID of the Product to sell");
        int id = input.getInt();
        System.out.println("Please Enter the Amount you wish to sell");
        int amount = input.getInt();
        manager.sellProduct(id, amount);
        System.out.println("");
    }
    
    /**
     * Method to Print products with a low stock level 
     */
     private void printLowStock()
    {
        System.out.println("All Products currently Low Stock\n");
        manager.printLowStock();
    }
    
    /**
     * Method to search for products using there name
     */
     private void searchProduct()
    {
        System.out.println("Please Enter the Name of Product");
        String word = input.getString();
        manager.search(word);
    }
    
    /**
     * Method to deliver a product
     */
     private void deliverProduct() {
        System.out.println("Enter ID of Product for Delivery");
        int id = input.getInt();
        System.out.println("Enter Amount being Delivered");
        int amount = input.getInt();
        manager.deliverProduct(id, amount);
        System.out.println("");
    }
 
    /**
     * Method to remove a product
     */
    private void removeProduct() {
        System.out.println("Removing a Product\n");

        System.out.println("Please Enter the Product ID");
        int id = input.getInt();

        manager.removeProduct(id);
        System.out.println("This Product has been Removed");

        System.out.println();
    }
    
    /**
     * Method to add a product
     */
    private void addProduct() {
        System.out.println("Adding new product\n");

        System.out.println("Please enter the product ID");
        int id = input.getInt();

        System.out.println("Please enter the name of the product");
        String name = input.getString();

        Product product = new Product(id, name);
        manager.addProduct(product);

        System.out.println();
    }

    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices() {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    PrintAll:   Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println("    Deliver:    Delivery of a Product");
        System.out.println("    Sell:       Sell a Current Product");
        System.out.println("    Search:     Search for a Product");
        System.out.println("    LowStock:   Print Products with a low stock");
        System.out.println("    ReStock:    Re Stock all Low stock Products");
        System.out.println();
    }

    /**
     * Print the title of the program and the authors name
     */
    private void printHeading() {
        // System.out.println(CLEAR_CODE);
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Louis Symons");
        System.out.println("******************************");
    }

}
