int countDigitOne(int n)
{
    int countr = 0;
    for (int i = 1; i <= n; i++) {
        string str = to_string(i);
        countr += count(str.begin(), str.end(), '1');
    }
    return countr;
}