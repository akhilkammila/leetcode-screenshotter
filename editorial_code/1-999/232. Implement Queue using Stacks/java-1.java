public int pop() {
    int res = s1.pop();
    if (!s1.empty())
        front = s1.peek();
    return res;
}