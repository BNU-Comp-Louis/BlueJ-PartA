import java.util.*;

/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 * 
 * @author Michael Kölling and David Barnes
 * @version 2016.02.29
 * Louis Symons
 * 16/10/2020
 */
public class Student
{
    // the student's full name
    private String name;
    // the student ID
    private String id;
    //Course for a student
    private Course course;
    
    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String fullName, String studentID)
    {
        name = fullName;
        id = studentID;
    }
    
    
    /**
     * Return the full name of this student.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set a new name for this student.
     */
    public void changeName(String replacementName)
    {
        name = replacementName;
    }

    /**
     * Return the student ID of this student.
     */
    public String getStudentID()
    {
        return id;
    }
   
    /**
     * Return the number of credit points this student has accumulated.
     */
    public int getCredits()
    {
        return this.course.getStudentCredits();
    }

    /**
     * Return the login name of this student. The login name is a combination
     * of the first four characters of the student's name and the first three
     * characters of the student's ID number.
     */
    public String getLoginName()
    {
        return name.substring(0,4) + id.substring(0,3);
    }
    
    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print()
    {
        System.out.println(name + ", student ID: " + id + ", credits: " + this.course.getStudentCredits());
        this.course.print();
    }
    
       /**
    * This method will enroll the student to a course (if else)
    */
    public void enrollOnCourse(Course course)
    {
        this.course = course;
    }
    
        
}
