class Solution {
public:
    // Create a hash value
    string getHash(string &s) {
        string hashKey;
        for (int i = 1; i < s.length(); i++) {
            hashKey += (s[i] - s[i - 1] + 26) % 26 + 'a';
        }
        
        return hashKey;
    }
    
    vector<vector<string>> groupStrings(vector<string>& strings) {
        unordered_map<string, vector<string>> mapHashToList;
        
        // Create a hash_value (hashKey) for each string and append the string
        // to the list of hash values i.e. mapHashToList["cd"] = ["acf", "gil", "xzc"]
        for (string str : strings) {
            string hashKey = getHash(str);
            mapHashToList[hashKey].push_back(str);
        }
        
        // Iterate over the map, and add the values to groups
        vector<vector<string>> groups;
        for (auto it : mapHashToList) {
            groups.push_back(it.second);
        }
        
        // Return a list of all of the grouped strings
        return groups;
    }
};