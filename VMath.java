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
}