class Solution {
public:
    bool checkIfPangram(string sentence) {
        // Array 'seen' of size 26.
        array<bool, 26> seen{};

        // For every letter 'currChar', we find its ASCII code, 
        // and update value at the mapped index as true.
        for (auto currChar : sentence)
            seen[currChar - 'a'] = true;
        
        // Once we finish iterating, check if 'seen' contains false.
        for (auto status : seen)
            if (!status)
                return false;
        return true;
    }
};