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
    public static int[] add(int[] v1, int[] v2) {
        int[] ret = new int[v1.length];
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
    public static double dotProd(Vector v1, Vector v2) {
        Vector v1normalized = v1.getNormalized();
        Vector v2normalized = v2.getNormalized();
        double[] nv1 = subtract(v1normalized.getB(),v1normalized.getA());
        double[] nv2 = subtract(v2normalized.getB(),v2normalized.getA());
        return dotProd(nv1,nv2);
    }
    public static double[] crossProdPoly(double[] v1, double[] v2) {
        double s1 = (v1[1]*v2[2])-(v1[2]*v2[1]);
        double s2 = (v1[2]*v2[0])-(v1[0]*v2[2]);
        double s3 = (v1[0]*v2[1])-(v1[1]*v2[0]);
        double[] ret = new double[]{s1,s2,s3};
        return null;
    }
    public static double[] multiplyScalar(double[] v, double d) {
        double[] ret = new double[v.length];
        for(int i=0;i<ret.length;i++) {
            ret[i]=v[i]*d;
        }
        return ret;
    }
    public static Vector multiplyScalar(Vector v, double d) {
        double[] start = v.getA();
        double[] newend = new double[start.length];
        double[] end = v.getB(); 
        for(int i=0;i<start.length;i++) {
            newend[i] = ((end[i]-start[i])*d)+start[i];
        }
        double[] newstart = new double[start.length];
        for(int i=0;i<start.length;i++) {
            newstart[i]=start[i];
        }
        Vector ret = new Vector(newstart,newend);
        return ret;
    }
    public static double[] average(double[] v1, double[] v2) {
        double[] ret = new double[v1.length];
        for(int i=0;i<ret.length;i++) {
            ret[i]=(v1[i]+v2[i])/2;
        }
        return ret;
    }
    public static int[] average(int[] v1, int[] v2) {
        int[] ret = new int[v1.length];
        for(int i=0;i<ret.length;i++) {
            ret[i]=(int)(((v1[i]+v2[i])/2)+.5);
        }
        return ret;
    }
    public static void print(int[] v) {
        for(int n : v) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
    public static void print(double[] v) {
        for(double n : v) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
    public static boolean equals(double[] v1, double[] v2) {
        if (v1.length != v2.length) {
            return false;
        }
        for(int i=0;i<v1.length;i++) {
            if (v1[i]!=v2[i]) {
                return false;
            }
        }
        return true;
    }
    public static boolean equals(int[] v1, int[] v2) {
        if (v1.length != v2.length) {
            return false;
        }
        for(int i=0;i<v1.length;i++) {
            if (v1[i]!=v2[i]) {
                return false;
            }
        }
        return true;
    }
    public static double[] clone(double[] v1) {
        double[] ret = new double[v1.length];
        for(int i=0;i<v1.length;i++ ) {
            ret[i]=v1[i];
        }
        return ret;
    }
    public static double distance(double[] v1, double[] v2) {
        double total = 0;
        for(int i=0;i<v1.length;i++) {
            total += Math.pow((v2[i]-v1[i]),2);
        }
        return Math.sqrt(total);
    }
}