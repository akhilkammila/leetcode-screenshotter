class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();

        boolean match1 = true, match2 = true, match3 = true;

        // case 1: All capital
        for (int i = 0; i < n; i++) {
            if (!Character.isUpperCase(word.charAt(i))) {
                match1 = false;
                break;
            }
        }
        if (match1) {
            return true;
        }

        // case 2: All not capital
        for (int i = 0; i < n; i++) {
            if (!Character.isLowerCase(word.charAt(i))) {
                match2 = false;
                break;
            }
        }
        if (match2) {
            return true;
        }

        // case 3: All not capital except first
        if (!Character.isUpperCase(word.charAt(0))) {
            match3 = false;
        }
        if (match3) {
            for (int i = 1; i < n; i++) {
                if (!Character.isLowerCase(word.charAt(i))) {
                    match3 = false;
                    break;
                }
            }
        }
        if (match3) {
            return true;
        }

        // if not matching
        return false;
    }
}