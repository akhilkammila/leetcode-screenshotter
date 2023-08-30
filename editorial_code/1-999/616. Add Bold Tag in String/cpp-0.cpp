int n = s.size();
vector<bool> bold(n);

for (string word: words) {
    if (word.size() > n) {
        continue;
    }
    
    for (int i = 0; i <= n - word.size(); i++) {
        if (s.substr(i, word.size()) == word) {
            for (int j = i; j < i + word.size(); j++) {
                bold[j] = true;
            }
        }
    }
}