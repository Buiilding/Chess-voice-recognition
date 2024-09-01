import java.awt.AWTException; // used to handle exceptions thrown by AWT (Abstract Window Tooolkit)
import java.awt.Rectangle; // the "rectangle" class, which represents a rectangular area and is used to define the screen area to capture
import java.awt.Robot; // the "Robot" class, which provides the methods to control the mouse,keyboard, capture screen images 
import java.awt.Toolkit; // the "Toolkit" class, which provides the methods to interact with the system, like getting screen size
import java.awt.image.BufferedImage; // the "Buffered Image" class, which is used to store the captured screen image
import javax.swing.ImageIcon;// the "ImageIcon" class, which is used to create an icon from an image and display it in a "Jlabel"
import javax.swing.JFrame; // the "JFrame" class, which is used to create a window for displaying the image
import javax.swing.JLabel; // the "JLabel" class, which is used to display text or images in a "JFrame"
import javax.swing.JPanel; // the "JPanel" class, which is used to create a container for other GUI components


public class Display{
    public static void main(String[] args){
        try{ // block of code that exceptions can be thrown
            //Create a robot instance
            Robot robot = new Robot();

            // Get screen size 
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); // call the area of the screen to capture, the elements in the parantheses output the size of the screen
            // Capture the screen
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect); // stores in the BufferedImage object, capture the screen with full size display
            //Display the captured image
            displayImage(screenFullImage);
        } catch (AWTException e){ // catch any exception within the try block 
            e.printStackTrace(); //print the stack trace of exception for help debugging
        }
    }

    private static void displayImage(BufferedImage image){
        // create a new Frame 
        JFrame frame = new JFrame(); // create new window to display the image, for now the window is blank as it is not yet parsed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit the application(process) when the window is closed (default stuff) 
        frame.setSize(image.getWidth(), image.getHeight()); // sets the size of the above window tab to match the dimensions and width of the captured image
        JLabel label = new JLabel(new ImageIcon(image)); // create a Jlabel containg the captured image wrapped in an "ImageIcon"
        JPanel panel = new JPanel(); // create a panel to contain label
        panel.add(label);// add label to panel
        frame.add(panel); // add panel(this time with an image because label has the image) to JFrame
        frame.setVisible(true);
    }
}
    