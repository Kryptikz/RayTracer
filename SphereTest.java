import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.util.*;
import java.io.*;
public class SphereTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sphere Testing Window");
        frame.setVisible(true);
        int width = 800;
        int height = 800;
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
        PointLight sun = new PointLight(new double[]{5,5,-35},5,.2);
        d.addSphere(s1);
        d.addSphere(s2);
        //d.addSphere(light);
        //d.addLight(light);
        //d.addSphere(sun); 
        //d.addLight(sun);
        d.addLight(sun);
        d.frame();
        for(int i=0;i<1000;i++) {
            //sun.move('z', .001);
            //s1.move('y',.001);
            //s2.move('x',.001);
            sun.move('z',.075);
            
            //int n = d.frame();
            BufferedImage img = d.generatePNG();
            try {
                ImageIO.write(img,"png", new File("export/" + i + ".png"));
            } catch (Exception e) {
                System.out.println("failed to export frame");
                e.printStackTrace();
            }
            
            /*try {
                Thread.sleep(16);
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        }
        //d.addSphere(light);
        //d.addLight(light);
        //d.addLight(sun);
        
        d.frame();
    }
}