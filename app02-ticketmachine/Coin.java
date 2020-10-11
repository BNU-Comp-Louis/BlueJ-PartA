
/**
 * This class will select different amounts of coins 
 *
 * @author (Louis Symons)
 * @version (10/10/2020)
 */

    
       public enum Coin
       //Amounts of coins
    {
        P10 (10),
        P20 (20),
        P100 (100),
        P200 (200);
        
        private final int value;
        
        
        
        private Coin (int value)
        {
            this.value = value;
        }
        //Returns the value of coins 
        public int getValue()
        {
            return value;
        }
    }
    
        
 

  
    

