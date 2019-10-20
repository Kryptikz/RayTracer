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
    public static void testReflect() {
        double[] origin = new double[2];
        double[] rayd = new double[]{-1,-1};
        Vector ray = new Vector(origin,rayd);
        double[] normald = new double[]{1,0};
        Vector normal = new Vector(origin,normald);
        Vector reflected = RMath.reflectRayOverNormal(ray, normal, new double[2]);
        System.out.println("Ray:");
        ray.print();
        System.out.println("Normal:");
        normal.print();
        System.out.println("Reflected:");
        reflected.print();
    }
}