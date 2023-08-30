class MapSum {
    HashMap<String, Integer> map;
    public MapSum() {
        map = new HashMap<>();
    }
    public void insert(String key, int val) {
        map.put(key, val);
    }
    public int sum(String prefix) {
        int ans = 0;
        for (String key: map.keySet()) {
            if (key.startsWith(prefix)) {
                ans += map.get(key);
            }
        }
        return ans;
    }
}