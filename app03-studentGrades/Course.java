
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
    
    private String finalGrade;
    
    

    
    
    /**
     * Constructor for objects of class Course
     */
    public Course (String courseTitle,String courceCode)
    {
        title = courseTitle;
        codeNo = courceCode;
        this.finalGrade = null;
        createModules();
        
    }
    
    public void createModules()
    {
        module1 = new Module("Programming Concepts",  "CO452");
        module2 = new Module("Computer Architectures",  "CO450");
        module3 = new Module("Digital Technologies",  "CO454");
        module4 = new Module("Web Development",  "CO456");
    }
    
    public String getFinalGrade()
    {
        return this.finalGrade;
    }

    public void setModuleMark(int mark, String codeNo)
    {
        if(mark >= 0 && mark <= 100){

            if(module1.getCodeNo() == codeNo)
            {
                module1.awardMark(mark);
            }
            else if(module2.getCodeNo() == codeNo)
            {
                module2.awardMark(mark);
            }
            else if(module3.getCodeNo() == codeNo)
            {
                module3.awardMark(mark);
            }
            else if(module4.getCodeNo() == codeNo)
            {
                module4.awardMark(mark);
            }
            else{
                System.out.println("Module with code number " + codeNo +" cannot be found!");
            }
        }
        else
        {
            System.out.println("Mark cannot be less than 0 or over 100!");
        }
    }
        
    public void calculateFinalGrade()
    {
        if(isCourseCompleted())
        {
            int totalMark = (module1.getMark() + module2.getMark() +
                                    module3.getMark() + module4.getMark()) / 4;

            if (totalMark >= 0 && totalMark <= 39) {
                this.finalGrade = "F";
            } else if (totalMark >= 40 && totalMark <= 49) {
                this.finalGrade = "D";
            } else if (totalMark >= 50 && totalMark <= 59) {
                this.finalGrade = "C";
            } else if (totalMark >= 60 && totalMark <= 69) {
                this.finalGrade = "B";
            } else if (totalMark >= 70 && totalMark <= 100) {
                this.finalGrade = "A";
            }     
                   
            print();
        }
        else 
        {
            System.out.println("The course has not completed yet!");
        }
    }

    public boolean isCourseCompleted()
    {
        if((module1.getIsCompleted()) && (module2.getIsCompleted()) &&
        ((module3. getIsCompleted())) && (module4. getIsCompleted()))
        {
            return true; 
        }
        else return false;
    } 
    
     /**
     * Prints out the details of a course
     */
    public void print()
    {
        // put your code here
        System.out.println("Course " + codeNo + " - " + title);
        System.out.println("Modules: ");

        module1.print();
        module2.print();
        module3.print();
        module4.print();

        System.out.println();
        System.out.println("Final grade: "+ this.finalGrade);
    }
    
    public Module getModule(String moduleCode){
        if(moduleCode == "CO452"){
            return module1;
        }
        else if(moduleCode == "CO450"){
            return module2;
        }
        else if(moduleCode == "CO454"){
            return module3;
        }
        else if(moduleCode == "CO456"){
            return module4;
        }
        else{
            System.out.println("Module with code "+ moduleCode + " cannot be found!");
        }
        return null;
    }
    
}
