package shape_lab;

/*
 * Circle.java
 * 
 * @author Chinmay Devadhar
 * @author Period 3
 * @author id: 10022320
 * @since 03/2022
 */
public class Circle extends Ellipse {
	// A circle is just an ellipse with a == b (thr radius)
	
	// Default Circle constructor
	public Circle() {
		super(1.0, 1.0);
		System.out.println("I am exiting the Circle's Default Constructor");
	}
	// Overloaded constructor - define a and b both to be radius
	public Circle(double radius) {
		super(radius, radius);
		System.out.println("I am exiting the Circle's Overloaded Constructor");
	}
	// Reuse parent getter methods
	public double getRadius() {
		return super.getA();
		
	}
	// We must set both a and b in the parent class to our new radius
	public void setRadius(double radius) {
		super.setA(radius);
		super.setB(radius);
	}
	public String toString() {
		return "I am a class Circle with a radius of " + super.getA();
	}
}
