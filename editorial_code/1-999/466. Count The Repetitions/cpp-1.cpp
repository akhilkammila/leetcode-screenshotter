int getMaxRepetitions(string s1, int n1, string s2, int n2)
{
    if (n1 == 0)
        return 0;
    int indexr[s2.size() + 1] = { 0 }; // index at start of each s1 block
    int countr[s2.size() + 1] = { 0 }; // count of repititions till the present s1 block
    int index = 0, count = 0;
    for (int i = 0; i < n1; i++) {
        for (int j = 0; j < s1.size(); j++) {
            if (s1[j] == s2[index])
                ++index;
            if (index == s2.size()) {
                index = 0;
                ++count;
            }
        }
        countr[i] = count;
        indexr[i] = index;
        for (int k = 0; k < i; k++) {
            if (indexr[k] == index) {
                int prev_count = countr[k];
                int pattern_count = (countr[i] - countr[k]) * (n1 - 1 - k) / (i - k);
                int remain_count = countr[k + (n1 - 1 - k) % (i - k)] - countr[k];
                return (prev_count + pattern_count + remain_count) / n2;
            }
        }
    }
    return countr[n1 - 1] / n2;
}