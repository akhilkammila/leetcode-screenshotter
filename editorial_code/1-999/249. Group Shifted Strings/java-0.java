class Solution {
    char shiftLetter(char letter, int shift) {
        return (char) ((letter - shift + 26) % 26 + 'a');
    }
    
    // Create a hash value
    String getHash(String s) {
        char[] chars = s.toCharArray();
        
        // Calculate the number of shifts to make the first character to be 'a'
        int shift = chars[0];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = shiftLetter(chars[i], shift);
        }
        
        String hashKey = String.valueOf(chars);
        return hashKey;
    }
    
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> mapHashToList = new HashMap<>();
        
        // Create a hash_value (hashKey) for each string and append the string
        // to the list of hash values i.e. mapHashToList["abc"] = ["abc", "bcd"]
        for (String str : strings) {
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
        
        return groups;
    }
}