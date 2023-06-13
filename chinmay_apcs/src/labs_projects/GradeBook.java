package labs_projects;

import java.io.*;
import java.util.*;
/**
 * GradeBook.java  
 *
 * @author - Chinmay Devadhar
 * @author - Period 3
 * @author - Id 10022320
 * @since 02/2021
 *
 * This is a lab for unit 6 to practice array.
 * It will read in a file with 10 students' records
 * and store them in a students array of size 10.
 * Each student in the array is an object of the Student class.
 * Please refer to Student.java for the class definition.
 * 
 * The data file has to be saved in the same directory as this file.
 * (Filename is graebookdata.txt)
 * The format of the data file is:
 * name,id,grade,score 1,score 2,score 3,score 4,score 5
 * such as in below:
 * Joe Biden,10001,12,100,90,90,100,95
 * Each line is for one student. It is comma separated, no space allowed.
 * Name is the full name. (first name and last name).  ID is student ID.
 * gradLevel is student's grade level.  Then 5 scores follow.
 */ 
public class GradeBook
{
	static Student[] students = new Student[10];
    public static void main(String[] args) 
    {
        // Make an array with 10 elements.
        // The datatype of the array is Student
        // Suggested array name is students
    	try {
    	Scanner dataFile = new Scanner(new File("gradebookdata.txt"));
            
            // This variable stores each line read in.
	    String oneLine;

            // This variable keeps track of how many records we read in now.
	    // It is the index for which we add the student data into the array.
	    int studentCount = 0;
	    	
            // Read in one line of data at a time until no more line
        while (dataFile.hasNextLine())
            {
                // Read in one line at a time, store it to oneLine, and convert to uppercase letters.
            oneLine = dataFile.nextLine();
            oneLine = oneLine.toUpperCase();
                // Get rid of leading and trailing blanks.
        	oneLine.trim();
//        	System.out.println(oneLine);
            // When the line is not a blank line, process it
            if (!oneLine.equals(""))
            {
                // Add data to the student array at the index of studentCount for this student.
                // studentCount is the array index you need to add this student into the array.
                // oneLine contains a line of data as a string.
                addStudent(students, studentCount, oneLine);
                
                // Increment the student counter by 1
                studentCount++;
            }
            }
            
        System.out.println("Total " + studentCount + " added to gradebook.\n");
        dataFile.close();
    	}
    	catch(IOException e) {
    		System.out.println("File error");
    	}
       
        
        
        
        
        // Print out the gradebook.  Call displayGradeBook method.
        displayGradeBook(students);
        // Test cases to update some data.  DO NOT CHANGE.
        students[0].setOneScore(1, 90);
        students[1].setID("1002");
        students[2].setGradeLevel(10);
        students[3].setName("Georage W. Bush");
        students[9].setOneScore(5, 60);
        
        // Print out the gradebook again to verify the changes.
        // Call displayGradeBook method.
        displayGradeBook(students);
        // Print a line for the class averages.  Call calculateClassAverage method.
       calculateClassAverage(students);
        // Now allow students to drop one of their lowest score
       for (Student s: students) {
    	   s.deleteLowest();
       }
        // Calculate new avg for each student, add new average to the end of
        // each student record in the output.
        // Print out the original and the new averages.
        // Call displayNewGradeBook method.
       System.out.println();
        displayNewGradeBook(students);
    }
    
    // This method will split the line into fields and then
    // add one student into students array at the position of pos.
    // Use String's split method to split the line into an array and then
    // pass this array to Student's constructor to create a Student object.
    // Then add this Student object into students array.
    public static void addStudent(Student[] students, int pos, String oneLine)
    {
        
        // Split the line into different fields using String's split method.
        // split method returns a String array.
        // You should store the return value of Split method as a String array.
        String[] arr = oneLine.split(",");
//        for (String s: arr) System.out.print(s+" ");
        // Make a new student object with student data (the return value of
        // split method) now.
        Student s = new Student(arr);
        // Add each student object to the students array.
    	students[pos] = s;
//    	System.out.println(students[pos]);

    }

    // Go through the students array and print each student data out.
    // Include an avg at the end.
    // Use ENHANCED for-loop to traverse the array.
    public static void displayGradeBook (Student[] students)
    {
        // Print table headers first.
        System.out.println("Name\t\tID\tGL\ts1\ts2\ts3\ts4\ts5\tavg");
        System.out.println("=============\t======\t==\t=====\t=====\t=====\t=====\t=====\t=====");
        
        // Traverse the array to print out each student's data
        // Use enhanced for-loop for arrays here
        // Call printStudentRecord in Student.java to print.
        for (Student s: students) {
        	s.printStudentRecord();
        }
        System.out.println();
    }
    
    // Go through the students array and print out the class average
    // for the 5 scores and a grand average.
    public static void calculateClassAverage (Student[] students)
    {
        // Use enhanced for-loop to traverse the students array
        // to get the class total for each score.
    	double[] sums = new double[5];
    	double totalSum=0;
    	for (Student s: students) {
    		double[] arr = s.getScoresArray();
    		for (int i=0; i<5; i++) {
    			sums[i]+=arr[i];
    			totalSum+=arr[i];
    		}
    	}
	// Print class average for each score and then a grand average at the end.
        // All fields are seperated by a tab (\t).
    	System.out.print("Class Average\t\t\t");
    	for (int i=0; i<5; i++) {
    		System.out.print(sums[i]/10 + "\t");
    	}
    	System.out.print(totalSum/50+"\t");
        System.out.println();
    }

    // Go through the students array and print each student data out.
    // Allow each student to drop one lowest score.
    // Print the original and the new avg at the end.
    // Use ENHANCED for-loop to traverse the array.
    public static void displayNewGradeBook (Student[] students)
    {
        // Print table headers first.
        System.out.println("Name\t\tID\tGL\ts1\ts2\ts3\ts4\ts5\tavg\tnew avg");
        System.out.println("=============\t======\t==\t=====\t=====\t=====\t=====\t=====\t=====\t======");
        
        // Traverse the array to print out each student's data
        // Use enhanced for-loop for arrays here
        for (Student s: students) {
        	s.printStudentRecordDropLowest();
        }
        // Call printStudentRecordDropLowest in Student.java.
        
    }

}
