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
            double num = (-b)-(Math.sqrt(discriminant)); 
            if (num <= 0) {
                num = (-b)+(Math.sqrt(discriminant));  
                if (num <= 0) {
                    return false;
                }
            }
            return true;
        }
    }
    public static double[] RaySpherePoint(Vector v, Sphere s) {
        double[] C = s.getCenter();
        double[] A = v.getA();
        double[] B = v.getB();
        double r = s.getRadius();
        double a = VMath.dotProd(B,B);
        double b = 2*VMath.dotProd(B,VMath.subtract(A, C));
        double c = VMath.dotProd(VMath.subtract(A,C),VMath.subtract(A,C)) - Math.pow(r,2);
        double discriminant = (b*b)-(4*(a*c));
        if (discriminant < 0) {
            return new double[0];
        }
        double num = (-b)-(Math.sqrt(discriminant));
        double t = 0;
        if (num > 0) {
            t=num/(2*a);
        } else {
            num = (-b)+(Math.sqrt(discriminant));   
            if (num > 0) {
                t=num/(2*a);
            } else {
                return new double[0];
            }
        }
        //System.out.println("t: " + t);
        double[] collision = v.getCollisionPointFromT(t);
        return collision;
    }
}