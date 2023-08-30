class Solution {
    int cntEqual = 1, cntDiffer = 0, indexDiffer = -1;

    private void f(boolean equal, int i) {
        if (equal) {
            cntEqual++;
        } else {
            cntDiffer++;
            indexDiffer = i;
        }
    }

    public int guessMajority(ArrayReader reader) {
        int n = reader.length(), query0123 = reader.query(0, 1, 2, 3), query1234 = reader.query(1, 2, 3, 4);
        f(query1234 == query0123, 4);
        for (int i = 5; i < n; i++) {
            f(reader.query(1, 2, 3, i) == query0123, i);
        }
        f(reader.query(0, 2, 3, 4) == query1234, 1);
        f(reader.query(0, 1, 3, 4) == query1234, 2);
        f(reader.query(0, 1, 2, 4) == query1234, 3);
        return cntEqual > cntDiffer ? 0 : cntDiffer > cntEqual ? indexDiffer : -1;
    }
}