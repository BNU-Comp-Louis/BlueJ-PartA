
/**
 * This a computing course held in G100 by Nicholas Day 
 *
 * @author Louis Symons
 * 28/09/20
 */
public class Course
{
    //Title of course
    private String title; 
    //Code for a course
    private String code;

    /**
     * Constructor for objects of class Course
     */
    public Course (String courseTitle,String courceCode)
    {
        title = courseTitle;
        code = courceCode;
    }
    
       /**
     * Returns the code number 
     **/
    public String getCodeNumber()
    {
        return this.code;
    }

    /**
     * Returns the title 
     **/
    public String getTitle()
    {
        return this.title;
    }
}


