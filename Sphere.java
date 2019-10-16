public class Sphere {
    double[] center;
    double rad;
    public Sphere(double[] center, double rad) {
        this.center=center;
        this.rad=rad;
    }
    public double[] getCenter() {
        return center;
    }
    public double getRadius() {
        return rad;
    }
}