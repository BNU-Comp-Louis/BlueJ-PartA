/**
 * Write a description of class Module here.
 *
 * @author (Louis Symons)
 * @version (24/10/20)
 */
public class Module
{
    //Title of a course 
    private String title;
    //Code number for a module 
    private String codeNo;
    //Mark for a module
    private int mark;
    // isCompleted
    private boolean isCompleted;
    
    /**
     * Constructor for objects of class Module
     */
    public Module(String title, String codeNo)
    {
        this.title = title;
        this.codeNo = codeNo;
        mark = -1;
        isCompleted = false;
        
    }
    
    public int getMark()
    //Show Mark for module 
    {
        return mark;
    }

    public void awardMark(int mark)
    //Award mark to student 
    {
        if(mark > 39)
        {
            this.isCompleted = true;
        }
        else
        {
            System.out.println("Minimum has not been achieved!");
        }

        this.mark = mark;
    }
    
    public String getCodeNo()
    //Show code number
    {
        return codeNo;
    }
    
    public String getTitle()
    //Show title 
    {
        return this.title;
    }

    public boolean getIsCompleted()
    //shows if the module is complete
    {
        return this.isCompleted;
    }

    public void print()
    //Print module and code number 
    {
        System.out.print("Module: " + title + " " + codeNo);
        if(mark == -1)
        {
            System.out.println(" This module has not been completed yet!");
        }
        else
        {
            System.out.println(" Mark:" + mark);
        }
    }
}
