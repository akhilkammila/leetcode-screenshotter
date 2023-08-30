int getMaxRepetitions(string s1, int n1, string s2, int n2)
{
    int index = 0, repeat_count = 0;
    int s1_size = s1.size(), s2_size = s2.size();
    for (int i = 0; i < n1; i++) {
        for (int j = 0; j < s1_size; j++) {
            if (s1[j] == s2[index])
                ++index;
            if (index == s2_size) {
                index = 0;
                ++repeat_count;
            }
        }
    }
    return repeat_count / n2;
}