import java.awt.Color;
public class Sphere {
    double[] center;
    double rad;
    Color color;
    public Sphere(double[] center, double rad) {
        this.center = center;
        this.rad = rad;
        color = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
    }
    public Sphere(double[] center, double rad, Color color) {
        this.center = center;
        this.rad = rad;
        this.color = color;
    }
    public double[] getCenter() {
        return center;
    }
    public double getRadius() {
        return rad;
    }
    public void move(char dir, double amount) {
        if (dir=='x') {
            center[0]+=amount;
        } else if (dir=='z') {
            center[2]+=amount;
        } else if (dir=='y') {
            center[1]+=amount;
        }
    }
    public Vector normalToPoint(double[] outside) {
        Vector v = new Vector(center,outside);
        //v.normalize();
        return v;
    }
    public Color getColor() {
        return color;
    }
    public int[] getColorInt() {
        return new int[]{color.getRed(),color.getGreen(),color.getBlue()};
    }
}