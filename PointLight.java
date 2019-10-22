import java.awt.Color;
public class PointLight {
    double[] center;
    double intensity;
    double falloff;
    Color color;
    public PointLight(double[] center, double intensity, double falloff) {
        this.center = center;
        this.intensity = intensity;
        this.falloff = falloff;
        this.color = new Color(255,255,255);
    }
    public PointLight(double[] center, double intensity, double falloff, Color color) {
        this.center = center;
        this.intensity = intensity;
        this.falloff = falloff;
        this.color = color;
    }
    public double[] getCenter() {
        return center;
    }
    public double getIntensity() {
        return intensity;
    }
    public double getFalloff() {
        return falloff;
    }
    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }
    public void setFalloff(double falloff) {
        this.falloff = falloff;
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
    public Color getColor() {
        return color;
    }
    public int[] getColorInt() {
        return new int[]{color.getRed(),color.getGreen(),color.getBlue()};
    }
    public double[] getValueAtDist(double dist) {
        double brightness = (intensity)/Math.pow((falloff*dist),2);
        //int val = (int)((brightness*255)+.5);
        double val = brightness*255;
        /*if (val > 255) {
            val = 255;
        }*/
        double[] ret = new double[]{val,val,val};
        return ret;
    }
}