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
        frame.setBackground(Color.BLUE);
        Display d = new Display(width,height);
        frame.add(d);
        d.setVisible(true);
        Sphere s1 = new Sphere(new double[]{-2.1,0,10},2);
        Sphere s2 = new Sphere(new double[]{2.1,0,6},2);
        Sphere light = new Sphere(new double[]{0,2.1,8},1.5,Color.WHITE);
        //Sphere sun = new Sphere(new double[]{5,5,11},5,Color.WHITE);
        PointLight sun = new PointLight(new double[]{5,5,11},1,.15);
        d.addSphere(s1);
        d.addSphere(s2);
        //d.addSphere(light);
        //d.addLight(light);
        //d.addSphere(sun); 
        //d.addLight(sun);
        d.addLight(sun);
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
        //d.addSphere(light);
        //d.addLight(light);
        //d.addLight(sun);
        
        d.frame();
    }
}