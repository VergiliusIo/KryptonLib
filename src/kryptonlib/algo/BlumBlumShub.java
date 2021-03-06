package kryptonlib.algo;

/**
 * Created by lophtpicker on 09.05.2017.
 */
public class BlumBlumShub {
    private double p, q, M, seed, actual;
    public BlumBlumShub(double p, double q, double seed) {
        this.p = p;
        this.q = q;
        this.M = p*q;
        this.seed = seed;
        this.actual = seed;
    }

    public double getrandom() {

        double r = actual*actual%M;
        actual = r;
        return r/M;
    }

    private double gcd(double a, double b) {

        if(b == 0) return a;
        return gcd(b, a%b);

    }

    public double getirandom(int i) {
        double g = gcd(p, q);
        double l = (p-1)*(q-1)/g;

        double exp = 1;
        for(int j = 1; j <= i; ++j) exp = exp*2%l;

        double x0 = seed*seed;
        double r = x0;
        for(double j = 2; j<=exp; ++j ) {
            r = r*x0%M;
        }
        return r/M;
    }
}
