int n = s.length();
boolean[] bold = new boolean[n];

for (String word: words) {
    for (int i = 0; i <= n - word.length(); i++) {
        if (s.substring(i, i + word.length()).equals(word)) {
            for (int j = i; j < i + word.length(); j++) {
                bold[j] = true;
            }
        }
    }
}