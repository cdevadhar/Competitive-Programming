package shape_lab;

/*
 * Square.java
 * 
 * @author Chinmay Devadhar
 * @author Period 3
 * @author id: 10022320
 * @since 03/2022
 */
public class Square extends Rectangle{
	
	// Overloaded constructor - here we call the Rectangle constructor with the same length for length and width,
	// because that's what a swuare is
	public Square(double side) {
		super(side, side);
		System.out.println("I am exiting Square's Overloaded Constructor");
	}
	// Default Square constructor
	public Square() {
		super(1.0, 1.0);
		System.out.println("I am exiting Square's Default Constructor");
	}
	// Setter method for side: must set the length and with in the parent class
	public void setSide(double s) {
		super.setWidth(s);
		super.setLength(s);
	}
	// Getter for side uses parent getter methods again
	public double getSide() {
		return super.getLength();
	}
	
	public String toString() {
		return "I am a class Square with a side of " + super.getBase();
	}
}
