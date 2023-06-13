package shape_lab;
import java.util.ArrayList;
/**
 * InheritanceRunner.java  
 *
 * @author Chinmay Devadhar
 * @author Period 3
 * @author id: 10022320
 * @since 03/2022
 *
 * This is the lab for unit 9 to practice inheritance.
 * 
 *                                Shape (interface)
 *                +--------------------+------------------+                     
 *                |                    |                  |
 *          Parallelogram            Triangle          Ellipse
 *           /        \                                   |    
 *    Rhombus      Rectangle                           Circle
 *                     |     
 *                   Square
 *                  
 *                  
 * This runner program test inheritance (PIVs, constructors, and methods).
 */
public class InheritanceRunner
{
    public static void main(String[] args)
    {
        /**
         * Test Parallelogram
         */ 
        System.out.println("Test Parallelogram");
        System.out.println("==================");

        System.out.println("[1. a default parallelogram 3x1x2 (base x height x side)]");
        Parallelogram p1 = new Parallelogram(); // See expected output for constructor         

        // This is an error. (question #1 in the report)
        // Uncomment to see the compiler's error message.
        // System.out.println(p1.base);
        // System.out.println(p1.height);
        // System.out.println(p1.side);

        // Test case for a default parallelogram
        System.out.println(p1.getBase());     // Prints out 3.0
        System.out.println(p1.getHeight());   // Prints out 1.0       
        System.out.println(p1.getSide());     // Prints out 2.0
        System.out.println(p1.perimeter());   // Prints out 10.0
        System.out.println(p1.area());        // Prints out 3.0
        System.out.println();

        // Test case when parallelogram's base/height/side is changed
        System.out.println("[2. change base to 5 (5x1x2)]");
        p1.setBase(5);                       // No output
        System.out.println(p1.perimeter());  // Prints out 14.0
        System.out.println(p1.area());       // Prints out 5.0        
        System.out.println();

        System.out.println("[3. change height to 1.2 (5x1.2x2)]");
        p1.setHeight(1.2);                   // No output
        System.out.println(p1.perimeter());  // Prints out 14.0
        System.out.println(p1.area());       // Prints out 6.0      
        System.out.println();

        System.out.println("[4. change side to 1.5 (5x1.2x1.5)]");
        p1.setSide(1.5);                     // No output
        System.out.println(p1.perimeter());  // Prints out 13.0
        System.out.println(p1.area());       // Prints out 6.0      
        System.out.println();

        // Test for toString() 
        System.out.println("[5. toString() ]");
        System.out.println(p1.toString());   // See expected output     
        System.out.println();

        // Test overloaded constructor
        System.out.println("[6. a new parallelogram 9x4x5]");
        Parallelogram p2 = new Parallelogram(9, 4, 5); // See expected output for constructor
        System.out.println(p2.perimeter());            // Prints out 28.0
        System.out.println(p2.area());                 // Prints out 36.0      
        System.out.println(p2.toString());             // See expected output
        System.out.println();

        /**
         * Test Rhombus
         */ 
        System.out.println("Test Rhombus");
        System.out.println("============");

        // Test case for a default rhombus
        System.out.println("[7. a default rhombus 2x1 (side x height)]");
        Rhombus rm1 = new Rhombus();           // See expected output for constructor         
        System.out.println(rm1.getSide());     // Prints out 2.0
        System.out.println(rm1.getHeight());   // Prints out 1.0
        System.out.println(rm1.perimeter());   // Prints out 8.0
        System.out.println(rm1.area());        // Prints out 2.0
        System.out.println();

        // Test case when rhombus's side is changed
        System.out.println("[8. change rhombus base to 3 and height to 2 (3x2)]");
        rm1.setSide(3);                        // No output
        rm1.setHeight(2);                      // No output
        System.out.println(rm1.perimeter());   // Prints out 12.0
        System.out.println(rm1.area());        // Prints out 6.0       
        System.out.println();

        // Test overloaded constructor
        System.out.println("[9. a new rhombus 5x4]");
        Rhombus rm2 = new Rhombus(5, 4);       // See expected output for constructor
        System.out.println(rm2.perimeter());   // Prints out 20.0
        System.out.println(rm2.area());        // Prints out 20.0      
        System.out.println(rm2.toString());    // See expected output
        System.out.println();

        /**
         * Test Rectangle
         */ 
        System.out.println("Test Rectangle");
        System.out.println("==============");

        // Test case for a default rectangle
        System.out.println("[10. a default rectangle 2x1 (length x width)]");
        Rectangle r1 = new Rectangle();         // See expected output for constructor         
        System.out.println(r1.getLength());     // Prints out 2.0
        System.out.println(r1.getWidth());      // Prints out 1.0       
        System.out.println(r1.perimeter());     // Prints out 6.0
        System.out.println(r1.area());          // Prints out 2.0
        System.out.println();

        // Test case when rectangle's length/width is changed
        System.out.println("[11. change length to 3 and width to 2 (3x2)]");
        r1.setLength(3);                       // No output
        r1.setWidth(2);                        // No output
        System.out.println(r1.perimeter());    // Prints out 10.0
        System.out.println(r1.area());         // Prints out 6.0        
        System.out.println();

        // Test overloaded constructor
        System.out.println("[12. a new rectangle 3x4]");
        Rectangle r2 = new Rectangle(3, 4);    // See expected output for constructor
        System.out.println(r2.perimeter());    // Prints out 14.0
        System.out.println(r2.area());         // Prints out 12.0      
        System.out.println(r2.toString());     // See expected output
        System.out.println();

        /**
         * Test Square
         */
        System.out.println("Test Square");
        System.out.println("===========");

        // Test case for a default square 1x1
        System.out.println("[13. a default square 1x1]");
        Square s1 = new Square();               // See expected output for constructor        
        System.out.println(s1.getSide());       // 1.0
        System.out.println(s1.perimeter());     // 4.0
        System.out.println(s1.area());          // 1.0
        System.out.println();

        // Test case - change the square side to 2.0
        System.out.println("[14. change square's side to 2.0]");
        s1.setSide(2.0);                        // No output
        System.out.println(s1.getSide());       // Prints out 2.0
        System.out.println(s1.perimeter());     // Prints out 8.0
        System.out.println(s1.area());          // Prints out 4.0
        System.out.println(s1.toString());      // See expected output
        System.out.println();

        // Test overloaded constructor
        System.out.println("[15. a new square 3x3]");
        Square s2 = new Square(3);              // See expected output for constructor
        System.out.println(s2.perimeter());     // Prints out 12.0
        System.out.println(s2.area());          // Prints out 9.0      
        System.out.println(s2.toString());      // See expected output
        System.out.println();

        /**
         * Test Triangle
         */
        System.out.println("Test Triangle");
        System.out.println("=============");

        // Test case for a default triangle 1x1x1
        System.out.println("[16. a default triangle 1x1x1 (side x side x side)]");
        Triangle t1 = new Triangle();                           // See expected output for constructor        
        System.out.println(t1.getA());                          // Prints out 1.0
        System.out.println(t1.getB());                          // Prints out 1.0
        System.out.println(t1.getC());                          // Prints out 1.0
        System.out.println(t1.perimeter());                     // Prints out 3.0
        System.out.println(String.format("%.02f", t1.area()));  // Prints out 0.43
        System.out.println();

        // Test case - change the triangle side to 3x4x5
        System.out.println("[17. change triangle to 3x4x5]");
        t1.setA(3.0);                           // No output
        t1.setB(4.0);                           // No output
        t1.setC(5.0);                           // No output
        System.out.println(t1.perimeter());     // Prints out 12.0
        System.out.println(t1.area());          // Prints out 6.0
        System.out.println(t1.toString());      // See expected output
        System.out.println();

        // Test overloaded constructor
        System.out.println("[18. a new triangle 3x3x3]");
        Triangle t2 = new Triangle(3, 3, 3);                   // See expected output for constructor
        System.out.println(t2.perimeter());                    // Prints out 9.0
        System.out.println(String.format("%.02f", t2.area())); // Prints out 3.90      
        System.out.println(t2.toString());                     // See expected output
        System.out.println();

        /**
         * Test Ellipse
         */
        System.out.println("Test Ellipse");
        System.out.println("===========");

        // Test case for a default ellipse 1x1
        System.out.println("[19. a default ellipse 2x1 (a-axis x b-axis)]");
        Ellipse e1 = new Ellipse();                                // See expected output for constructor        
        System.out.println(e1.getA());                             // Prints out 2.0
        System.out.println(e1.getB());                             // Prints out 1.0
        System.out.println(String.format("%.02f", e1.perimeter()));// Prints out 9.93
        System.out.println(String.format("%.02f", e1.area()));     // Prints out 6.28
        System.out.println();

        // Test case - change the ellipse to 3x2
        System.out.println("[20. change ellipse to 3x2]");
        e1.setA(3.0);                                               // No output
        e1.setB(2.0);                                               // No output
        System.out.println(String.format("%.02f", e1.perimeter())); // Prints out 16.02
        System.out.println(String.format("%.02f", e1.area()));      // Prints out 18.85
        System.out.println(e1.toString());                          // See expected output
        System.out.println();

        // Test overloaded constructor
        System.out.println("[21. a new ellipse 2x3]");
        Ellipse e2 = new Ellipse(2, 3);                             // See expected output for constructor
        System.out.println(String.format("%.02f", e2.perimeter())); // Prints out 16.02
        System.out.println(String.format("%.02f", e2.area()));      // Prints out 18.85
        System.out.println(e2.toString());                          // See expected output
        System.out.println();

        /**
         * Test Circle
         */
        System.out.println("Test Circle");
        System.out.println("===========");

        // Test case for a default circle with radius of 1
        System.out.println("[22. a default circle of radius 1]");
        Circle c1 = new Circle();                                  // See expected output for constructor        
        System.out.println(c1.getRadius());                        // Prints out 1.0
        System.out.println(String.format("%.02f", c1.perimeter()));// Prints out 6.28
        System.out.println(String.format("%.02f", c1.area()));     // Prints out 3.14
        System.out.println();

        // Test case - change the circle's radius to 2
        System.out.println("[23. change circle's radius to 2]");
        c1.setRadius(2.0);                                            // No output
        System.out.println(String.format("%.02f", c1.perimeter()));   // Prints out 12.57
        System.out.println(String.format("%.02f", c1.area()));        // Prints out 12.57
        System.out.println(c1.toString());                            // See expected output
        System.out.println();

        // Test overloaded constructor
        System.out.println("[24. a new circle of 3]");
        Circle c2 = new Circle(3);                                  // See expected output for constructor
        System.out.println(String.format("%.02f", c2.perimeter())); // Prints out 18.85
        System.out.println(String.format("%.02f", c2.area()));      // Prints out 28.27
        System.out.println(c2.toString());                          // See expected output
        System.out.println();

        /**
         * Test polymorphism
         */
        System.out.println("Test polymorphism");
        System.out.println("=================");

        // Add 7 different shape objects (p2, rm2, r2, s2, t2, e2, c2) to the list of type Shape.
        // The list type is parent class and it can add all child class objects in the list.
        System.out.println("[25. add existing objects to the list]");
        ArrayList<Shape> list1 = new ArrayList<Shape>();
        
        // Add different shape objects to the list.
        // The first one is done for you as an example.
        list1.add(p2);
        list1.add(rm2);
        list1.add(r2);
        list1.add(s2);
        list1.add(t2);
        list1.add(e2);
        list1.add(c2);
        // Print out the list
        System.out.println("The list has " + list1.size() + " objects.");
        for (Shape obj: list1)
        {
            System.out.println(obj + 
                " perimeter: " + String.format("%.02f", obj.perimeter()) + 
                " area: " + String.format("%.02f", obj.area()));
        }
        System.out.println();

        /**
         * Polymorphism when the variable type is not the same as the object type.
         * The variable type (left side) is checked in compile-time 
         * while the object type (right side) is used in runtime.
         * The variable type can be the parent's type.
         * So the variable type in the left hand side should be more general 
         * than the object type in the right hand size.
         * Please look carefully and see how polymorphism is used.
         */

        // Make 7 new objects with the default constructors and add them to a new list.
        // See how the variable type (left - parent) is different from the object type (right - child).
        System.out.println("[26. add new objects to the list]");
        ArrayList<Shape> list2 = new ArrayList<Shape>();
        
        // Declare new variables in Shape datatype.
        // Make new objects in child class.
        // Then add them to the list of Shape type.
        // The first one is done for you as an example.
        Shape p3 = new Parallelogram();
        Shape r3 = new Rhombus();
        Shape re3 = new Rectangle();
        Shape s3 = new Square();
        Shape t3 = new Triangle();
        Shape e3 = new Ellipse();
        Shape c3 = new Circle();
        list2.add(p3);
        list2.add(r3);
        list2.add(re3);
        list2.add(s3);
        list2.add(t3);
        list2.add(e3);
        list2.add(c3);
        System.out.println("\nThe list has " + list2.size() + " objects.");
        for (Shape obj: list2)
        {
            System.out.println(obj + 
                " perimeter: " + String.format("%.02f", obj.perimeter()) + 
                " area: " + String.format("%.02f", obj.area()));
        }
    }
}
