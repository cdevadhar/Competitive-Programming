package shape_lab;

/*
 * Triangle.java
 * 
 * @author Chinmay Devadhar
 * @author Period 3
 * @author id: 10022320
 * @since 03/2022
 */
public class Triangle implements Shape {
	// Private instance variables store the side lengths
	private double a, b, c;
	
	// Default contructor for triangle
	public Triangle() {
		System.out.println("I am entering the Triangle's Default Constructor");
		// One line trick to set multiple variables
		this.a = this.b = this.c = 1;
		System.out.println("I am exiting the Triangle's Default Constructor");
	}
	// Overloaded constructor takes in passed values for the sides
	
	public Triangle(double a, double b, double c) {
		System.out.println("I am entering the Triangle's Overloaded Constructor");
		this.a = a;
		this.b = b;
		this.c = c;
		System.out.println("I am exiting the Triangle's Overloaded Constructor");
	}
	
	// Getters for all our private instance variables
	public double getA() {
		return a;
	}
	public double getB() {
		return b;
	}
	public double getC() {
		return c;
	}
	// Setters for all our private instance variables
	public void setA(double a) {
		this.a = a;
	}
	public void setB(double b) {
		this.b = b;
	}
	public void setC(double c) {
		this.c = c;
	}
	// Calculate the area using heron's formula
	public double area() {
		// S is the semiperimeter
		double s = (a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	// The perimeter is the sum of the 3 sides
	public double perimeter() {
		return a+b+c;
	}
	// Override the toString
	public String toString() {
		return "I am a class Triangle with 3 sides of " + a + ", " + b + ", and " + c;
	}
}
