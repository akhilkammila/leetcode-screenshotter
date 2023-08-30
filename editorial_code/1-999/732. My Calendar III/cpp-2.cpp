class MyCalendarThree {
private:
    map<int, int> starts;
    int res;

public:
    MyCalendarThree() {
        starts[0] = 0, starts[1e9 + 1] = 0;
        res = 0;
    }
    void split(int x) { starts[x] = (--starts.upper_bound(x))->second; }
    int book(int start, int end) {
        split(start), split(end);
        for (auto it = starts.find(start); it->first < end; it++) {
            res = max(res, ++(it->second));
        }
        return res;
    }
};