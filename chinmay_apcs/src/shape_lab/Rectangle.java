package shape_lab;
/*
 * Rectangle.java
 * 
 * @author Chinmay Devadhar
 * @author Period 3
 * @author id: 10022320
 * @since 03/2022
 */

public class Rectangle extends Parallelogram {
	// Again we don't need any new instance variables
	
	// Default constructor of Rectangle
	public Rectangle() {
		super(2.0, 1.0, 1.0);
		System.out.println("I am exiting the Rectangle's Default Constructor");
	}
	// Overloaded constructor - here when we call the super constructor, the side and height will be the same
	// because that is a characteristic of a rectangle
	public Rectangle(double l, double w) {
		super(l, w, w);
		System.out.println("I am exiting the Rectangle's Overloaded Constructor");
	}
	// Getter methods for length and width just reuse the parent getter methors
	public double getLength() {
		return super.getBase();
	}
	public double getWidth() {
		return super.getSide();
	}
	// Setter methods for the instance variables
	public void setLength(double l) {
		super.setBase(l);
	}
	// Since side and height are equal, we must set both in the parent
	public void setWidth(double w) {
		super.setSide(w);
		super.setHeight(w);
	}
	public String toString() {
		return "I am a class Rectangle with a length of " + super.getBase() + " and a width of " + super.getHeight();
	}
}
