class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        int N = S.length();
        for (int i = 0; i < Math.min(10, N); ++i) {
            if (S.charAt(0) == '0' && i > 0) break;
            long a = Long.valueOf(S.substring(0, i+1));
            if (a >= Integer.MAX_VALUE) break;

            search: for (int j = i+1; j < Math.min(i+10, N); ++j) {
                if (S.charAt(i+1) == '0' && j > i+1) break;
                long b = Long.valueOf(S.substring(i+1, j+1));
                if (b >= Integer.MAX_VALUE) break;

                List<Integer> fib = new ArrayList();
                fib.add((int) a);
                fib.add((int) b);

                int k = j + 1;
                while (k < N) {
                    long nxt = fib.get(fib.size() - 2) + fib.get(fib.size() - 1);
                    String nxtS = String.valueOf(nxt);

                    if (nxt <= Integer.MAX_VALUE && S.substring(k).startsWith(nxtS)) {
                        k += nxtS.length();
                        fib.add((int) nxt);
                    }
                    else continue search;
                }
                if (fib.size() >= 3) return fib;
            }
        }

        return new ArrayList<Integer>();
    }
}