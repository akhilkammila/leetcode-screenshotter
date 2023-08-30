class SummaryRanges {
    private TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<>(); 
    }
    
    public void addNum(int value) {
        final Map.Entry<Integer, Integer> smallEntry = intervals.floorEntry(value); 
        int left = value, right = value;
        if (smallEntry != null) {
            final int previous = smallEntry.getValue();
            if (previous >= value) {
                return;
            }
            if (previous == value - 1) {
                left = smallEntry.getKey();
            }
        }
        final Map.Entry<Integer, Integer> maxEntry = intervals.higherEntry(value); 
        if (maxEntry != null && maxEntry.getKey() == value + 1) {
            right = maxEntry.getValue();
            intervals.remove(value + 1);
        }
        intervals.put(left, right);
    }
    
    public int[][] getIntervals() {
        final int[][] answer = new int[intervals.size()][2];
        int ind = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            answer[ind][0] = entry.getKey();
            answer[ind++][1] = entry.getValue();
        }
        return answer; 
    }
}