public class VMath {
    public static double[] subtract(double[] v1, double[] v2) {
        double[] ret = new double[v1.length];
        for(int i=0;i<ret.length;i++) {
            ret[i]=v1[i]-v2[i];
        }
        return ret;
    }
    public static double[] add(double[] v1, double[] v2) {
        double[] ret = new double[v1.length];
        for(int i=0;i<ret.length;i++) {
            ret[i]=v1[i]+v2[i];
        }
        return ret;
    }
    public static double dotProd(double[] v1, double[] v2) {
        double sum=0;
        for(int i=0;i<v1.length;i++) {
            sum+=(v1[i]*v2[i]);
        }
        return sum;
    }
    public static double[] crossProdPoly(double[] v1, double[] v2) {
        double s1 = (v1[1]*v2[2])-(v1[2]*v2[1]);
        double s2 = (v1[2]*v2[0])-(v1[0]*v2[2]);
        double s3 = (v1[0]*v2[1])-(v1[1]*v2[0]);
        double[] ret = new double[]{s1,s2,s3};
        return null;
    }
    public static double magnitude(double[] v1) {
        double powsum = 0;
        for(double d : v1) {
            powsum += Math.pow(d,2);
        }
        
        return null;
    }
}