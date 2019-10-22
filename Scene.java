import java.awt.*;
import javax.swing.*;
public class Scene {
    JFrame frame;
    int WIDTH;
    int HEIGHT;
    public Scene(int height, int width, String title) {
        this.WIDTH = width;
        this.HEIGHT = height;
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setBackground(Color.BLUE);
        frame.setResizable(false);
        Display d = new Display(WIDTH,HEIGHT);
        frame.add(d);
        d.setVisible(true);
    }
    
}