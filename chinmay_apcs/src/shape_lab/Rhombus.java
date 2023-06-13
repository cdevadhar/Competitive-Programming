package shape_lab;
/*
 * Rhombus.java
 * 
 * @author Chinmay Devadhar
 * @author Period 3
 * @author id: 10022320
 * @since 03/2022
 */
public class Rhombus extends Parallelogram {
	// We don't need any new private instance variables, we can use the ones in the parent class
	
	// Overloaded constructor takes in side and height
	public Rhombus(double side, double height) {
		// Since all sides of a rhombus are equal, we call the super constructor with equal base and side
		super(side, height, side);
		System.out.println("I am exiting the Rhombus's Overloaded Constructor");
	}
	// Default constructor for Rhombus - also calls super
	public Rhombus() {
		super(2.0, 1.0, 2.0);
		System.out.println("I am exiting the Rhombus's Default Constructor");
	}
	// Setter method for side must set both the base and the side of the parent parallelogram because these must be equal
	public void setSide(double s) {
		super.setSide(s);
		super.setBase(s);
	}
	// Overriding toString again
	public String toString() {
		return "I am a class Rhombus with a side of " + super.getSide() + " and a height of " + super.getHeight();
	}
}
