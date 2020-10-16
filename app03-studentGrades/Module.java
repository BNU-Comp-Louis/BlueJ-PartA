
/**
 * Write a description of class Module here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Module
{
    //Fields
    private String title;
    //
    private String codeNo;
    //
    private int mark;
    
    
    
    /**
     * Constructor for objects of class Module
     */
    public Module(String title, String CodeNo)
    {
        this.title = title;
        this.codeNo = codeNo;
        mark = 0;
        
    }
    
    public void awardMark(int mark)
    //Award mark to student 
    {
        this.mark = mark;
    }
    
    

  
  
}
