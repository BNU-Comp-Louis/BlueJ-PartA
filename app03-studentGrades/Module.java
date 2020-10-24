
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
    
    private int credit;
    
    private boolean completed;
    
    

    
    /**
     * Constructor for objects of class Module
     */
    public Module(String title, String CodeNo)
    {
        this.title = title;
        this.codeNo = codeNo;
        mark = -1;
        credit = 15;
        completed = false;
        
    }
    
    public void awardMark(int mark)
    //Award mark to student 
    {
        this.mark = mark;
    }
    
    public int getMark()
    {
        return mark;
    }
    
    public void print()
    {
        System.out.println("Module: " + title + " " + codeNo + " Mark:" 
        + mark);
    }
    
    public String getCodeNo()
    {
        return codeNo;
    }
    
    public boolean isCompleted()
    {
        return mark >= 0;
    }
    
    
  
  
}
