class SummaryRanges {
    set<int> values;

public:
    SummaryRanges() {}

    void addNum(int value) { values.insert(value); }

    vector<vector<int>> getIntervals() {
        if (values.empty()) {
            return {};
        }
        vector<vector<int>> intervals;
        int left = -1, right = -1;
        for (int value : values) {
            if (left < 0) {
                left = right = value;
            } else if (value == right + 1) {
                right = value;
            } else {
                intervals.push_back({left, right});
                left = right = value;
            }
        }
        intervals.push_back({left, right});
        return intervals;
    }
};