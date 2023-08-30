class MyCalendarThree {
private:
    unordered_map<int, int> vals;
    unordered_map<int, int> lazy;

public:
    MyCalendarThree() {}

    void update(int start, int end, int left, int right, int idx) {
        if (start > right || end < left) return;
        if (left >= start && right <= end) {
            lazy[idx]++;
            vals[idx]++;
        } else {
            int mid = (left + right) / 2;
            update(start, end, left, mid, idx * 2);
            update(start, end, mid + 1, right, idx * 2 + 1);
            vals[idx] = lazy[idx] + max(vals[idx * 2], vals[idx * 2 + 1]);
        }
    }

    int book(int start, int end) {
        update(start, end - 1, 1, 1000000000, 1);
        return vals[1];
    }
};