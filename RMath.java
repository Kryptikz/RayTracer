import java.awt.Color;
import java.util.ArrayList;
public class RMath {
    public static Vector sphereReflect(Vector ray, Sphere s) {
        double[] collision = IMath.RaySpherePoint(ray,s);
        Vector normal = s.normalToPoint(collision);
        //normal.print();
        //System.out.println(IMath.RaySphereHit(ray, s));
        Vector ret = reflectRayOverNormal(ray,normal,collision);
        return ret;
    }
    public static Vector reflectRayOverNormal(Vector ray, Vector normal, double[] collision) {
        Vector normalUnit = normal.getNormalizedAtZero();
        Vector rayUnit = ray.getNormalizedAtZero();
        double[] rightside = VMath.multiplyScalar(normalUnit.getB(),(2*VMath.dotProd(normalUnit,rayUnit)));
        double[] reflected = VMath.subtract(rayUnit.getB(),rightside);
        double[] start = collision;
        double[] end = VMath.add(collision, reflected);
        Vector ret = new Vector(start,end);
        return ret;
    }
    public static int[] traceRay(Vector ray, ArrayList<Sphere> world, ArrayList<Sphere> lights, int traces, int[] last, Sphere lasts) {
        //returns int[] which contains RGB values
        if (traces == 5){
            return last;
        }
        for(Sphere s : world) {
            if (IMath.RaySphereHit(ray, s) && lasts != s) {
                Vector reflect = sphereReflect(ray,s);
                /*if (lasts != s && !VMath.equals(last, new int[3])) {
                    System.out.print("this color: ");
                    VMath.print(s.getColorInt());
                    System.out.print("last color: ");
                    VMath.print(last);
                }*/
                return VMath.average(s.getColorInt(),traceRay(reflect,world,lights,traces+1,s.getColorInt(),s));
            }
        }
        if (traces != 0) {
            for(Sphere light : lights) {
                double[] lcenter = light.getCenter();
                double[] raycenter = ray.getA();
                Vector lightRay = new Vector(lcenter,raycenter);
                boolean intersect = false;
                for(Sphere s2 : world) {
                    if (IMath.RaySphereHit(lightRay, s2)) {
                        intersect = true;
                        System.out.println("Collision occured with light");
                        return new int[]{255,255,255};
                    }
                }
            }
        }
        return new int[3];
    }
}