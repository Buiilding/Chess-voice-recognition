import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class DisplayCoordinates{
    public static void main(String[] args) {
        //Create a JFrame to display coordinates
        JFrame frame = new JFrame("Mouse Coordinates");
        frame.setSize(200,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Mouse coordinates:");
        frame.add(label);
        frame.setVisible(true);

        //Create a Timer to update coordinates every 100 milliseconds
        Timer timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //Get the current mouse position
                Point mousePos = MouseInfo.getPointerInfo().getLocation();
                label.setText("Coordinates: (" + mousePos.x +", " + mousePos.y + ")");
            }
        });
        timer.start();
    }
}