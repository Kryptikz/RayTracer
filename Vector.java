public class Vector {
    double[] A; //start
    double[] B; //target
    public Vector(double[] A, double[] B) {
        this.A = A;
        this.B = B;
    }
    public double[] getA() {
        return A;
    }
    public double[] getB() {
        return B;
    }
    public void normalize() {
        double mag = this.magnitude();
        for(int i=0;i<A.length;i++) {
            //A[i]=A[i]/mag;
            B[i]=((B[i]-A[i])/mag)+A[i];
        }
    }
    public Vector getNormalized() {
        double[] a = VMath.clone(A);
        double[] b = VMath.clone(B);
        Vector cloned = new Vector(a,b);
        cloned.normalize();
        return cloned;
    }
    public Vector getNormalizedAtZero() {
        double[] a = new double[3];
        double[] b = VMath.subtract(B,A);
        return (new Vector(a,b)).getNormalized();
    }
    public double magnitude() {
        if (A.length != B.length) {
            this.print();
            return 0;
        }
        double powsum = 0;
        for(int i=0;i<A.length;i++) {
            powsum += Math.pow(B[i]-A[i],2);
        }
        return Math.sqrt(powsum);
    }
    public double[] getCollisionPointFromT(double t) {
        double[] point = new double[A.length];
        double mag = this.magnitude();
        for(int i=0;i<A.length;i++) {
           point[i] = ((B[i]-A[i])/(mag/t))+A[i]; //this works if the function is not normalized
           //point[i] = ((B[i]-A[i])*t)+A[i]; //only works with a normalized function
        }
        return point;
    }
    public void print() {
        System.out.print("(");
        int inc=0;
        for(double d : A) {
            if (inc<A.length-1) {
                System.out.print(d + ",");
            } else {
                System.out.print(d);
            }
            inc++;
        }
        System.out.print(") (");
        inc=0;
        for(double d : B) {
            if (inc<B.length-1) {
                System.out.print(d + ",");
            } else {
                System.out.print(d);
            }
            inc++;
        }
        System.out.print(")\n");
    }
}