import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
public class Display extends JComponent {
    ArrayList<Sphere> spheres;
    ArrayList<PointLight> lights;
    int width;
    int height;
    double[] camerapos;
    double[] camerarot;
    public Display(int width, int height) {
        spheres = new ArrayList<Sphere>();
        lights = new ArrayList<PointLight>();
        camerapos = new double[3];
        camerarot = new double[3];
        this.width = width;
        this.height = height;
    }
    public void addSphere(Sphere s) {
        spheres.add(s);
    }
    public void addLight(PointLight s) {
        lights.add(s);
    }
    public int frame() {
        try {
            this.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int r=0;r<height;r++) {
            for(int c=0;c<width;c++) {
                double x = ((double)r/(double)height)-.5;
                double y = ((double)c/(double)width)-.5;
                
                
                Vector ray = new Vector(camerapos,new double[]{x,y,1});
                int[] pixelval = RMath.traceRay(ray, spheres, lights, 0, new int[3],null);
                if (pixelval[0]>255) {
                    pixelval[0]=255;
                }
                if (pixelval[1]>255) {
                    pixelval[1]=255;
                }
                if (pixelval[2]>255) {
                    pixelval[2]=255;
                }
                Color pixelcolor = new Color(pixelval[0],pixelval[1],pixelval[2]);
                g.setColor(pixelcolor);
                g.fillRect(c,r,1,1);
            }
        }
    }
    public Color[][] generatePixelBuffer() {
        Color[][] pixelBuffer = new Color[height][width];
        for(int r=0;r<height;r++) {
            for(int c=0;c<width;c++) {
                double x = ((double)r/(double)height)-.5;
                double y = ((double)c/(double)width)-.5;
                Vector ray = new Vector(camerapos,new double[]{x,y,1});
                int[] pixelval = RMath.traceRay(ray,spheres,lights,0,new int[3],null);
                if (pixelval[0]>255) {
                    pixelval[0]=255;
                }
                if (pixelval[1]>255) {
                    pixelval[1]=255;
                }
                if (pixelval[2]>255) {
                    pixelval[2]=255;
                }
                Color pixelcolor = new Color(pixelval[0],pixelval[1],pixelval[2]);
                pixelBuffer[r][c] = pixelcolor;
            }
        }
        return pixelBuffer;
    }
    public BufferedImage generatePNG() {
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        this.paint(image.getGraphics());
        return image;
    }
}