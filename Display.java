import java.util.*;
import java.awt.*;
import javax.swing.*;
public class Display extends JComponent {
    ArrayList<Sphere> spheres;
    ArrayList<Sphere> lights;
    int width;
    int height;
    double[] camerapos;
    double[] camerarot;
    public Display(int width, int height) {
        spheres = new ArrayList<Sphere>();
        lights = new ArrayList<Sphere>();
        camerapos = new double[3];
        camerarot = new double[3];
        this.width = width;
        this.height = height;
    }
    public void addSphere(Sphere s) {
        spheres.add(s);
    }
    public void addLight(Sphere s) {
        lights.add(s);
    }
    public void frame() {
        this.repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int r=0;r<height;r++) {
            for(int c=0;c<width;c++) {
                double x = ((double)r/(double)height)-.5;
                double y = ((double)c/(double)width)-.5;
                
                
                Vector ray = new Vector(camerapos,new double[]{x,y,1});
                int[] pixelval = RMath.traceRay(ray, spheres, lights, 0, new int[3],null);
                Color pixelcolor = new Color(pixelval[0],pixelval[1],pixelval[2]);
                g.setColor(pixelcolor);
                g.fillRect(c,r,1,1);
            }
        }
    }
}