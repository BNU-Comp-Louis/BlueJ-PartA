
/**
 * This a computing course held in G100 by Nicholas Day 
 *
 * @author (louis symons)
 */
public class Course
{
    //Computing G100
    private String title; 
    


    private String codeNo;
    
    private Module module1;
    
    private Module module2;
    
    private Module module3;
    
    private Module module4;

    
    
    /**
     * Constructor for objects of class Course
     */
    public Course (String courseTitle,String courceCode)
    {
        title = courseTitle;
        codeNo = courceCode;
    }
    
    public void addModule(Module module, int moduleNo)
    {
        if(moduleNo == 1)
        {
        this.module1 = module;
    } // added others 
    }
    
      /**
     * Prints out the details of a course
     */
    public void print()
    {
        // put your code here
        System.out.println("Course " + codeNo + " - " + title);
    }

}
