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
    public double magnitude() {
        double powsum = 0;
        for(int i=0;i<A.length;i++) {
            powsum += Math.pow(B[i]-A[i],2);
        }
        return Math.sqrt(powsum);
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