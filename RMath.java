import java.awt.Color;
import java.util.ArrayList;
public class RMath {
    public static Vector sphereReflect(Vector ray, Sphere s) {
        double[] collision = IMath.RaySpherePoint(ray,s);
        Vector normal = s.normalToPoint(collision);
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
    public static int[] traceRay(Vector ray, ArrayList<Sphere> world, ArrayList<PointLight> lights, int traces, int[] last, Sphere lasts) {
        if (traces == 5){
            return last;
        }
        for(Sphere s : world) {
            if (IMath.RaySphereHit(ray, s) && lasts != s) {
                Vector reflect = sphereReflect(ray,s);
                return VMath.average(s.getColorInt(),traceRay(reflect,world,lights,traces+1,s.getColorInt(),s));
            }
        }
        return new int[3];
    }
    public static double[] traceRayLight(Vector ray, ArrayList<Sphere> world, ArrayList<PointLight> lights, int traces, double[] last, Sphere lasts) {
        if (traces == 5) {
            return last;
        }
        for(Sphere s : world) {
            if (IMath.RaySphereHit(ray,s) && lasts != s) {
                Vector reflect = sphereReflect(ray,s);
                double[] lightValue = new double[3];
                for(PointLight light : lights) {
                    double[] lcenter = light.getCenter();
                    double[] raycenter = reflect.getA();
                    Vector lightRay = new Vector(lcenter,raycenter);
                    boolean intersect = false;
                    for(Sphere s2 : world) {
                        if (IMath.RaySphereHit(lightRay, s2)) {
                            intersect = true;
                            break;
                        }
                    }
                    if (!intersect) {
                        double distance = VMath.distance(reflect.getA(),light.getCenter());
                        lightValue = VMath.add(lightValue, light.getValueAtDist(distance));
                    }
                }
                return VMath.add(lightValue,traceRayLight(reflect,world,lights,traces+1,lightValue,s));
            }
        }
        return new double[3];
    }
}