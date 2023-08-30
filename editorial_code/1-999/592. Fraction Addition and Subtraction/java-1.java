class Solution {
  public String fractionAddition(String expression) {
    List<Character> sign = new ArrayList<>();
    if (expression.charAt(0) != '-') sign.add('+');
    for (int i = 0; i < expression.length(); i++) {
      if (expression.charAt(i) == '+' || expression.charAt(i) == '-')
        sign.add(expression.charAt(i));
    }
    int prev_num = 0, prev_den = 1, i = 0;
    for (String sub : expression.split("(\\+)|(-)")) {
      if (sub.length() > 0) {
        String[] fraction = sub.split("/");
        int num = (Integer.parseInt(fraction[0]));
        int den = (Integer.parseInt(fraction[1]));
        int g = Math.abs(gcd(den, prev_den));
        if (sign.get(i++) == '+') prev_num = prev_num * den / g + num * prev_den / g;
        else prev_num = prev_num * den / g - num * prev_den / g;
        prev_den = den * prev_den / g;
        g = Math.abs(gcd(prev_den, prev_num));
        prev_num /= g;
        prev_den /= g;
      }
    }
    return prev_num + "/" + prev_den;
  }

  public int gcd(int a, int b) {
    while (b != 0) {
      int t = b;
      b = a % b;
      a = t;
    }
    return a;
  }
}