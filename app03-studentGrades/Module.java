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
    {
        return codeNo;
    }
    
    public String getTitle() {
        return this.title;
    }

    public boolean getIsCompleted()
    {
        return this.isCompleted;
    }

    public void print()
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
