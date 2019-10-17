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
    public void move(char dir, double amount) {
        if (dir=='x') {
            center[0]+=amount;
        } else if (dir=='z') {
            center[2]+=amount;
        } else if (dir=='y') {
            center[1]+=amount;
        }
    }
}