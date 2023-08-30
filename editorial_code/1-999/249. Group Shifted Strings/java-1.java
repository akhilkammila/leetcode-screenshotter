class Solution {
    // Create a hash value
    String getHash(String s) {
        char[] chars = s.toCharArray();
        StringBuilder hashKey = new StringBuilder();
        
        for (int i = 1; i < chars.length; i++) {
            hashKey.append((char) ((chars[i] - chars[i - 1] + 26) % 26 + 'a'));
        }
        
        return hashKey.toString();
    }
    
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> mapHashToList = new HashMap<>();
        
        // Create a hash_value (hashKey) for each string and append the string
        // to the list of hash values i.e. mapHashToList["cd"] = ["acf", "gil", "xzc"]
        for (String str : strings ) {
            String hashKey = getHash(str);
            if (mapHashToList.get(hashKey) == null) {
                mapHashToList.put(hashKey, new ArrayList<>());
            } 
            mapHashToList.get(hashKey).add(str);
        }
        
        // Iterate over the map, and add the values to groups
        List<List<String>> groups = new ArrayList<>();
        for (List<String> group : mapHashToList.values()) {
            groups.add(group);
        }
        
        // Return a list of all of the grouped strings
        return groups;
    }
}