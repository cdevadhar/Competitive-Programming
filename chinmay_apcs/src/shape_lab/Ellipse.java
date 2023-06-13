package shape_lab;

/*
 * Ellipse.java
 * 
 * @author Chinmay Devadhar
 * @author Period 3
 * @author id: 10022320
 * @since 03/2022
 */
public class Ellipse implements Shape {
	// Private instance variables defining the ellipse
	double a, b;
	
	// Overloaded constructor initializes variables to passed values
	public Ellipse(double a, double b) {
		System.out.println("I am entering the Ellipse's Overloaded Constructor");
		this.a = a;
		this.b = b;
		System.out.println("I am exiting the Ellipse's Overloaded Constructor");
	}
	// Default cosntructor
	public Ellipse() {
		System.out.println("I am entering the Ellipse's Default Constructor");
		this.a = 2.0;
		this.b = 1.0;
		System.out.println("I am exiting the Ellipse's Default Constructor");
	}
	// Use the ellipse perimeter formula
	public double perimeter() {
		return 2*Math.PI*Math.sqrt((a*a+b*b)/2);
	}
	// Use the ellipse area formula
	public double area() {
		return Math.PI*a*b;
	}
	// Setters and getters for our private instance variables
	public void setA(double a) {
		this.a = a;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getA() {
		return a;
	}
	public double getB() {
		return b;
	}
	// Override the toString
	public String toString() {
		return "I am a class Ellipse with a-axis of " + a + " and b-axis of " + b;
	}
}
