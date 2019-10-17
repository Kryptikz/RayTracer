public class VectorTest {
    public static void main(String[] args) {
        double[] p1 = new double[]{3,3,3};
        double[] p2 = new double[]{5,5,5};
        Vector v = new Vector(p1,p2);
        v.normalize();
        v.print();
    }
}