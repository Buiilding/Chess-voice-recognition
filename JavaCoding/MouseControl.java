import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;

public class MouseControl{
    public static void main(String[] args) {
       try {
        // Create a Robot instance
        Robot robot = new Robot();

        // Define the coordinates to move the mouse to 
        int x = 960; //Tryout
        int y = 540; //Tryout

        //Move the mouse
        robot.mouseMove(x,y);
        
    } catch (AWTException e){
        e.printStackTrace();
    } 
    }
    
}