class Solution {
    func buddyStrings(_ s: String, _ goal: String) -> Bool {
        guard s.count == goal.count else {
            return false
        }

        if s == goal {
            // If we have 2 same characters in string 's',
            // we can swap them and still the strings will remain equal.
            var frequency = Array(repeating: 0, count: 26)
            for ch in s {
                frequency[Int(ch.asciiValue! - Character("a").asciiValue!)] += 1
                if frequency[Int(ch.asciiValue! - Character("a").asciiValue!)] == 2 {
                    return true
                }
            }
            // Otherwise, if we swap any two characters, it will make the strings unequal.
            return false
        }

        var firstIndex = -1
        var secondIndex = -1

        for (i, ch) in s.enumerated() {
            if ch != goal[String.Index(utf16Offset: i, in: goal)] {
                if firstIndex == -1 {
                    firstIndex = i
                } else if secondIndex == -1 {
                    secondIndex = i
                } else {
                    // We have at least 3 indices with different characters,
                    // thus, we can never make the strings equal with only one swap.
                    return false
                }
            }
        }

        if secondIndex == -1 {
            // We can't swap if the character at only one index is different.
            return false
        }

        // All characters of both strings are the same except two indices.
        return (s[String.Index(utf16Offset: firstIndex, in: s)] == goal[goal.index(goal.startIndex, offsetBy: secondIndex)] && 
                s[String.Index(utf16Offset: secondIndex, in: s)] == goal[goal.index(goal.startIndex, offsetBy: firstIndex)])
          
    }
}