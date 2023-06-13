package labs_projects;

/**
 * This class represents a simple picture. You can draw the picture using
 * the draw method. But wait, there's more: being an electronic picture, it
 * can be changed. You can set it to black-and-white display and back to
 * colors (only after it's been drawn, of course).
 *
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author  Michael Kslling and David J. Barnes
 * @version 2016.02.29
 * 
 * Chinmay Devadhar 10/1/21: added main and sunset methods.
 */
public class Picture
{
    private Square wall;
    private Square window;
    private Square window2;
    private Square door;
    private Triangle roof;
    private Circle sun;
    private Person person;
    private boolean drawn;

    /**
     * Constructor for objects of class Picture
     */
    public Picture()
    {
        wall = new Square();
        window = new Square();
        window2 = new Square();
        door = new Square();
        roof = new Triangle();  
        sun = new Circle();
        person = new Person();
        drawn = false;
    }

    ///////////////////////////////////////////////////////////////////////////////
    // Add main to run program
    public static void main(String[] args)
    {
        // Fill in the main method
    	Picture pic = new Picture();
    	pic.draw();
    	
    }
    //////////////////////////////////////////////////////////////////////////////
    
    // KC - add a new sunset method
    // Sun will rise from the east and go down to the west with slow motions
    public void sunset()
    {
        for(int i = 0; i < 140; i++)
        {
            sun.slowMoveDiagonallyUpLeft(1);
        }
        for(int i = 0; i < 140; i++)
        {
            sun.slowMoveDiagonallyDownLeft(1);
        }
    }
    /////////////////////////////////////////////////////////////////////////////
    
    /**
     * Draw this picture.
     */
    public void draw()
    {
        if(!drawn) {
            wall.moveHorizontal(-140);
            wall.moveVertical(20);
            wall.changeSize(120);
            wall.makeVisible();
            
            window.changeColor("black");
            window.moveHorizontal(-130);
            window.moveVertical(40);
            window.changeSize(40);
            window.makeVisible();
            
            window2.changeColor("black");
            window2.moveHorizontal(-70);
            window2.moveVertical(40);
            window2.changeSize(40);
            window2.makeVisible();
            
            door.changeColor("blue");
            door.moveHorizontal(-100);
            door.moveVertical(100);
            door.changeSize(40);
            door.makeVisible();
            
            person.changeColor("magenta");
            person.moveHorizontal(-190);
            person.moveVertical(30);
            person.changeSize(80, 20);
            person.makeVisible();
    
            roof.changeSize(60, 180);
            roof.moveHorizontal(20);
            roof.moveVertical(-60);
            roof.makeVisible();
    
            sun.changeColor("yellow");
            sun.moveHorizontal(100);
            sun.moveVertical(-40);
            sun.changeSize(80);
            sun.makeVisible();
            drawn = true;
        }
    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite()
    {
        wall.changeColor("black");
        window.changeColor("white");
        roof.changeColor("black");
        sun.changeColor("black");
    }

    /**
     * Change this picture to use color display
     */
    public void setColor()
    {
        wall.changeColor("red");
        window.changeColor("black");
        roof.changeColor("green");
        sun.changeColor("yellow");
    }
}