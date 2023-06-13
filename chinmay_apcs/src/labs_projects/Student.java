package labs_projects;
/**
 * Student.java  
 *
 * @author - Chinmay Devadhar
 * @author - Period 3
 * @author - Id 10022320
 * @since 02/2021
 *
 * This Student class has student's reocrd - name, student ID,
 * grade level, and 5 scores
 * 
 */ 
public class Student
{
    // Declare your PIVs here
    // Name stores full name (first name + " " + last name)
    // Student ID is a String and can have different lengths
    // Student's grade level is an int
    // 5 scores in a double array
    
    // Constructor - data array size needs to match with # of PIV
    // If you don't use String's split method to process data,
    // you can change the constructor here to suit your needs.
	private String name;
	private String id;
	private int gradeLevel;
	private String scoreStr;
	private double[] scores;
	private double avg;
	private double newAvg;
	private boolean dropped;
    public Student(String[] data)
    {
        // data is an array with 8 elements.
        // First element is name, 2nd is ID, 3rd is grade level.
        // The next 5 are the scores.
        // They are stored as Strings
        // Need to convert to the correct datatype before you can make
        // a Student object.
    	dropped = false;
    	double sum=0;
    	scoreStr = "";
    	this.name = data[0];
    	this.id = data[1];
    	this.gradeLevel = Integer.parseInt(data[2]);
    	scores = new double[5];
    	for (int i=3; i<8; i++) {
    		double d = Double.parseDouble(data[i]);
//    		System.out.println(d);
    		scores[i-3] = d;
//    		scoreStr = scoreStr+scores[i-3]+"\t";
    		sum+=Double.parseDouble(data[i]);
    	}
    	createStr();
    	avg = sum/5;
    }
    // Deletes the lowest score from the student's scores. This is representing by having the negative of that number put into scores. 
    // That way, we can see which was deleted when we print it out
    public void deleteLowest() {
    	double sum = 0;
    	double min = 1000000000;
    	for (double i: scores) min = Math.min(min, i);
//    	System.out.println(min);
    	for (int i=0; i<5; i++) {
    		if (scores[i]==min) {
    			scores[i]*=(-1);
    			break;
    		}
    	}
    	for (double i: scores) if (i>=0) sum+=i;
    	newAvg = sum/4;
    	dropped = true;
    }
    // Creates the string representation of all the scores, including the dropped one
    public void createStr() {
    	scoreStr="";
    	for (int i=0; i<5; i++) {
    		if (scores[i]<=0 && dropped) {
    			scoreStr+=(-1)*scores[i] + "*"+"\t";
    		}
    		else scoreStr+=scores[i]+"\t";
    	}
    }
    // Getters - return the value of all instance variables
    public String getName()
    {
        return name;
    }

    public String getID()
    {
        return id;
    }

    public int getGradeLevel()
    {
        return gradeLevel;
    }

    // This returns 5 scores in a double array.
    public double[] getScoresArray()
    {
        return scores;
    }

    // Get only one score specified by 1-5
    public double getOneScore(int whichScore)
    {
        return scores[whichScore-1];
    }

    // Setters - set the values of private instance variables
    public void setName(String name)
    {
        this.name = name;
    }

    public void setID(String id)
    {
        this.id = id;
    }

    public void setGradeLevel(int gradeLevel)
    {
        this.gradeLevel = gradeLevel;
    }
    
    // This sets scores array using the passed in array parameter.
    public void setScoresArray(double[] scores)
    {
        this.scores = scores;
        double sum=0;
        for (double d: scores) {
        	sum+=d;
        }
        avg = sum/5;
    }
    
    // Set only one score specified by 1-5
    public void setOneScore(int whichScore, double score)
    {
//    	double prev = scores[whichScore-1];
    	double sum=0;
        scores[whichScore-1] = score;
        for (double d: scores) {
        	sum+=d;
        }
        avg = sum/5;
        
    }

    // Print out student record with a score avg at the end
    // Each field is separated by "\t" (tab)
    public void printStudentRecord()
    {
        // scoreStr contains all 5 scores as a string (separated by \t)
        // You don't have to do the same if you have a different way
        // to print scores.
    	createStr();
        System.out.println(name + "\t" + id + "\t" + gradeLevel + "\t" + scoreStr + avg);
    }   
    
    // Allow students to drop one lowest score
    // Print out the record with original avg and new avg
    // Each field is separated by "\t" (tab)
    // The dropped score will have a * next to it
    public void printStudentRecordDropLowest()
    {
//        deleteLowest();
        createStr();
        System.out.println(name + "\t" + id + "\t" + gradeLevel + "\t" + 
            scoreStr + avg + "\t" + newAvg);
    }    
}