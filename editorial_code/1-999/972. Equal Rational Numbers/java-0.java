class Solution {
    public boolean isRationalEqual(String S, String T) {
        Fraction f1 = convert(S);
        Fraction f2 = convert(T);
        return f1.n == f2.n && f1.d == f2.d;
    }

    public Fraction convert(String S) {
        int state = 0; //whole, decimal, repeating
        Fraction ans = new Fraction(0, 1);
        int decimal_size = 0;

        for (String part: S.split("[.()]")) {
            state++;
            if (part.isEmpty()) continue;
            long x = Long.valueOf(part);
            int sz = part.length();

            if (state == 1) { // whole
                 ans.iadd(new Fraction(x, 1));
            } else if (state == 2) { // decimal
                 ans.iadd(new Fraction(x, (long) Math.pow(10, sz)));
                 decimal_size = sz;
            } else { // repeating
                 long denom = (long) Math.pow(10, decimal_size);
                 denom *= (long) (Math.pow(10, sz) - 1);
                 ans.iadd(new Fraction(x, denom));
            }
        }
        return ans;
    }
}

class Fraction {
    long n, d;
    Fraction(long n, long d) {
        long g = gcd(n, d);
        this.n = n / g;
        this.d = d / g;
    }

    public void iadd(Fraction other) {
        long numerator = this.n * other.d + this.d * other.n;
        long denominator = this.d * other.d;
        long g = Fraction.gcd(numerator, denominator);
        this.n = numerator / g;
        this.d = denominator / g;
    }

    static long gcd(long x, long y) {
        return x != 0 ? gcd(y % x, x) : y;
    }
}