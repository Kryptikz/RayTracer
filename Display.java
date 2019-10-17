import java.util.*;
import java.awt.*;
import javax.swing.*;
public class Display extends JComponent {
    ArrayList<Sphere> spheres;
    int width;
    int height;
    public Display(int width, int height) {
        spheres = new ArrayList<Sphere>();
        this.width = width;
        this.height = height;
    }
    public void addSphere(Sphere s) {
        spheres.add(s);
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
                Vector ray = new Vector(new double[]{0,0,0},new double[]{x,y,1});
                for(Sphere s : spheres) {
                    if (IMath.RaySphereHit(ray,s)) {
                        g.fillRect(c,r,1,1);
                    }
                }
            }
        }
    }
}