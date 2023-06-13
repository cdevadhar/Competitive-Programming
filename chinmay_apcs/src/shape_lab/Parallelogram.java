package shape_lab;
/*
 * Parallelogram.java
 * 
 * @author Chinmay Devadhar
 * @author Period 3
 * @author id: 10022320
 * @since 03/2022
 */

public class Parallelogram implements Shape {
	// private instance variables
	private double base, side, height;
	// Overloaded constructor - takes in values for the base, height, and side
	public Parallelogram(double base, double height, double side) {
		System.out.println("I am entering the Parallelogram's Overloaded Constructor");
		this.base = base;
		this.side = side;
		this.height = height;
		System.out.println("I am exiting the Parallelogram's Overloaded Constructor");
	}
	// default no argument constructor - sets instance variables to the default values
	public Parallelogram() {
		System.out.println("I am entering the Parallelogram's Default Constructor");
		base = 3.0;
		height = 1.0;
		side = 2.0;
		System.out.println("I am exiting the Parallelogram's Default Constructor");
	}
	// Getter methods for the 3 instance variables
	public double getBase() {
		return base;
	}
	public double getSide() {
		return side;
	}
	public double getHeight() {
		return height;
	}
	// Setter methods for the 3 instance variables
	public void setBase(double b) {
		base = b;
	}
	public void setHeight(double h) {
		height = h;
	}
	public void setSide(double s) {
		side = s;
	}
	// The area() and perimeter methods must be implemented because they are defined in the Shape interface, which Parallelogram implements
	// Area is just base times height
	public double area() {
		return base*height;
	}
	// Perimeter is adding up all the sides
	public double perimeter() {
		return 2*base+2*side;
	}
	// Override the default toString
	public String toString() {
		return "I am a class Parallelogram with a base of " + base + ", a height of " + height + ",and a side of " + side;
	}
}
