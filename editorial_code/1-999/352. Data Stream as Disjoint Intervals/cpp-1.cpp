class SummaryRanges {
    map<int, int> intervals;

public:
    SummaryRanges() {}

    void addNum(int value) {
        int left = value, right = value;
        auto small_entry = intervals.upper_bound(value);
        if (small_entry != intervals.begin()) {
            auto max_entry = small_entry;
            --max_entry;
            if (max_entry->second >= value) {
                return;
            }
            if (max_entry->second == value - 1) {
                left = max_entry->first;
            }
        }
        if (small_entry != intervals.end() && small_entry->first == value + 1) {
            right = small_entry->second;
            intervals.erase(small_entry);
        }
        intervals[left] = right;
    }

    vector<vector<int>> getIntervals() {
        vector<vector<int>> answer;
        for (const auto& p : intervals) {
            answer.push_back({p.first, p.second});
        }
        return answer;
    }
};