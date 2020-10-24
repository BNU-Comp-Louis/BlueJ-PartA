
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
    
    private int finalMark;
    
    private String finalGrade;
    
    

    
    
    /**
     * Constructor for objects of class Course
     */
    public Course (String courseTitle,String courceCode)
    {
        title = courseTitle;
        codeNo = courceCode;
        this.finalMark =0;
        this.finalGrade = null;
        createModules();
        
    }
    
    public void createModules()
    {
        module1 = new Module("CO452",  "Programming Concepts");
        module2 = new Module("CO450",  "Computer Architectures");
        module3 = new Module("CO454",  "Digital Technologies");
        module4 = new Module("CO456",  "Web Development");
    }
    
    public void addModule(Module module, int moduleNo)
    {
        if(moduleNo == 1)
        {
        this.module1 = module;
    } // added others 
    }
    
    public void setMark(int mark, String codeNo)
    {
        if(module1.getCodeNo() == codeNo)
        {
            module1.awardMark(mark);
        }
    }
        
    public void calculatorFinalMark()
    {
        if(courseCompleted())
        {
        int totalMark = finalMark = module1.getMark() + module2.getMark() +
        module3.getMark() + module4.getMark();
        
        finalMark = totalMark / 4;      
        
        print();
    }
    else 
    {
        
    }
    
    }
        
    public boolean courseCompleted()
    {
        if((module1.isCompleted()) && (module2.isCompleted()) &&
        ((module3. isCompleted())) && (module4. isCompleted()))
        {
            return true; 
        }
        else return false;
    } 
    
     
    
    




    //Print individual module marks 
    
     /**
     * Prints out the details of a course
     */
    public void print()
    {
        // put your code here
        System.out.println("Course " + codeNo + " - " + title);
        
    }
    
    public void printModules()
    {
        if(courseCompleted())
        {
        System.out.println("Final Mark = " + finalMark);
    }
    }
    
    
}
