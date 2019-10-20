import java.awt.*;
import javax.swing.*;
public class SphereTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sphere Testing Window");
        frame.setVisible(true);
        int width = 1000;
        int height = 1000;
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLUE);
        Display d = new Display(width,height);
        frame.add(d);
        d.setVisible(true);
        Sphere s1 = new Sphere(new double[]{-2.1,0,10},2);
        Sphere s2 = new Sphere(new double[]{2.1,0,6},2);
        Sphere sun = new Sphere(new double[]{5,5,11},5,Color.WHITE);
        d.addSphere(s1);
        d.addSphere(s2);
        //d.addSphere(sun); 
        d.addSphere(sun);
        d.frame();
        for(int i=0;i<500;i++) {
            //sun.move('z', .001);
            //s1.move('y',.001);
            s2.move('x',.001);
            d.frame();
            try {
                Thread.sleep(16);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}