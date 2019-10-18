public class RMath {
    public static double[] sphereReflect(Vector v, Sphere s) {
        //calculate Normal to Sphere at Intersection
        //calculate reflection vector
        double[] collision = IMath.RaySpherePoint(v, s);
        Vector normal = s.normalToPoint(collision);
        //Vector reflected = VMath.subtract(v,2*VMath.dotProd(v, normal));
        
        return null;
    }
    
    
}