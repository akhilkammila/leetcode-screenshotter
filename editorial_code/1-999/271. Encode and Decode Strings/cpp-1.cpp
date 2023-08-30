class Codec {
public:
    // Encodes a list of strings to a single string.
    string encode(vector<string>& strs) {
        // Initialize a string to hold the encoded strings
        string encodedString;

        // Iterate over each string in the input list
        for (const auto& s : strs) {
            // For each string, iterate over each character
            for (const char c : s) {
                // If the character is a slash, append an additional slash to 'encodedString'
                if (c == '/') {
                    encodedString += "//";
                }
                // Otherwise, simply append the character to 'encodedString'
                else {
                    encodedString += c;
                }
            }
            // After encoding each string, append the delimiter "/:"
            encodedString += "/:";
        }

        // Return the final encoded string
        return encodedString;
    }

    // Decodes a single string to a list of strings.
    vector<string> decode(string s) {
        // Initialize a vector to hold the decoded strings
        vector<string> decodedStrings;

        // Initialize a string to hold the current string being decoded
        string currentString;

        // Iterate over the characters in the input string
        for (size_t i = 0; i < s.size(); i++) {
            // If we encounter the delimiter "/:"
            if (i < s.size()-1 && s[i] == '/' && s[i+1] == ':') {
                // Add the current string to 'decodedStrings'
                decodedStrings.push_back(currentString);

                // Clear 'currentString' for the next string
                currentString.clear();

                // Move the index 1 step forward to skip the delimiter
                i += 1;
            }
            // If we encounter an escaped slash "//"
            else if (i < s.size()-1 && s[i] == '/' && s[i+1] == '/') {
                // Add a single slash to the 'currentString'
                currentString += '/';

                // Move the index 1 step forward to skip the escaped slash
                i += 1;
            }
            // Otherwise, just add the character to 'currentString'
            else {
                currentString += s[i];
            }
        }

        // Return the list of decoded strings
        return decodedStrings;
    }
};