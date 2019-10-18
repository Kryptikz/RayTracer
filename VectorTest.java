public class VectorTest {
    public static void main(String[] args) {
        double[] p1 = new double[]{0,0,0};
        double[] p2 = new double[]{0,50,50};
        Vector v = new Vector(p1,p2);
        double[] p = v.getCollisionPointFromT(5);
        for(double d : p) {
            System.out.println(d);
        }
        v.print();
    }
}