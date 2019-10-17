public class IMath {
    public static boolean RaySphereHit(Vector v, Sphere s) {
         double[] C = s.getCenter();
         double[] A = v.getA();
         double[] B = v.getB();
         double r = s.getRadius();
         double a = VMath.dotProd(B,B);
         double b = 2*VMath.dotProd(B,VMath.subtract(A, C));
         double c = VMath.dotProd(VMath.subtract(A,C),VMath.subtract(A,C)) - Math.pow(r,2);
         double discriminant = (b*b)-(4*(a*c));
         if (discriminant < 0) {
             return false;
         } else {
             return true;
         }
    }
    public static double[] RaySpherePoint(Vector v, Sphere s) {
        return null;
        
    }
}