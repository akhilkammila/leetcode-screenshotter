class Codec {
public:
    string encode(vector<string>& strs) {
        // Initialize an empty string to hold the encoded string.
        string encodedString;
        for (string &s : strs) {
            // Append the length, the delimiter, and the string itself.
            encodedString += to_string(s.size()) + "/:" + s;
        }
        return encodedString;
    }

    vector<string> decode(string s) {
        // Initialize a list to hold the decoded strings.
        vector<string> decodedStrings;
        size_t i = 0;
        while (i < s.size()) {
            // Find the delimiter.
            size_t delim = s.find("/:", i);
            // Get the length, which is before the delimiter.
            int length = stoi(s.substr(i, delim - i));
            // Get the string, which is of 'length' length after the delimiter.
            string str = s.substr(delim + 2, length);
            // Add the string to the list.
            decodedStrings.push_back(str);
            // Move the index to the start of the next length.
            i = delim + 2 + length;
        }
        return decodedStrings;
    }
};