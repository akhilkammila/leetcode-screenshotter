class Solution {

    int nr, nc, rem, b_size;
    List<Set<Integer>> buckets = new ArrayList<>();
    Random rand = new Random();

    public Solution(int n_rows, int n_cols) {
        nr = n_rows;
        nc = n_cols;
        rem = nr * nc;
        b_size = (int) Math.sqrt(nr * nc);
        for (int i = 0; i < nr * nc; i+= b_size)
            buckets.add(new HashSet<Integer>());
    }

    public int[] flip() {
        int c = 0;
        int c0 = 0;
        int k = rand.nextInt(rem);
        for (Set<Integer> b1 : buckets) {
            if (c0 + b_size - b1.size() > k) {
                while (true) {
                    if (!b1.contains(c)) {
                        if (c0 == k) {
                            b1.add(c);
                            rem--;
                            return new int[]{c / nc, c % nc};
                        }
                        c0++;
                    }
                    c++;
                }
            }
            c += b_size;
            c0 += b_size - b1.size();
        }
        return null;
    }

    public void reset() {
        for (Set<Integer> b1 : buckets)
            b1.clear();
        rem = nr * nc;
    }
}