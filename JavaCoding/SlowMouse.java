import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;

public class SlowMouse {
    public static void main(String[] args){
        try{ //use this to help with debugging whenever there is an exception
            // Create a Robot instance
            Robot robot = new Robot();
            int x = 10;
            int y = 0;
            for (int i = 0; i <=500; i = i + 1){
                int xr = x + i;
                int yr = y + i;
                System.out.println("x" + "(" + x + ")" + " +" + "i" +"(" + i + ")" + " = " + xr);
                robot.mouseMove(xr,yr);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (AWTException e){
            e.printStackTrace();
        }

    }



}
