public class StringIterator {
    StringBuilder res=new StringBuilder();
    int ptr=0;
    public StringIterator(String s) {
        int i = 0;
        while (i < s.length()) {
                char ch = s.charAt(i++);
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                for (int j = 0; j < num; j++)
                    res.append(ch);
        }
    }
    public char next() {
        if (!hasNext())
            return ' ';
        return res.charAt(ptr++);
    }
    public boolean hasNext() {
        return ptr!=res.length();
    }
}