class MyCalendarThree {
    private Map<Integer, Integer> diff;

    public MyCalendarThree() {
        diff = new TreeMap<>();
    }

    public int book(int start, int end) {
        diff.put(start, diff.getOrDefault(start, 0) + 1);
        diff.put(end, diff.getOrDefault(end, 0) - 1);
        int res = 0, cur = 0;
        for (int delta : diff.values()) {
            cur += delta;
            res = Math.max(res, cur);
        }
        return res;
    }
}