import java.awt.*;
import javax.swing.*;
public class SphereTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sphere Testing Window");
        frame.setVisible(true);
        int width = 500;
        int height = 500;
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Display d = new Display(width,height);
        frame.add(d);
        d.setVisible(true);
        Sphere s1 = new Sphere(new double[]{0,0,5},2);
        d.addSphere(s1);
        d.frame();
        for(int i=0;i<500;i++) {
            s1.move('z', .1);
            d.frame();
            try {
                Thread.sleep(16);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}