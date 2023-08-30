public class Solution {
    public int[] exclusiveTime(int n, List < String > logs) {
        Stack < Integer > stack = new Stack < > ();
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1, time = Integer.parseInt(s[2]);
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            while (time < Integer.parseInt(s[2])) {
                res[stack.peek()]++;
                time++;
            }
            if (s[1].equals("start"))
                stack.push(Integer.parseInt(s[0]));
            else {
                res[stack.peek()]++;
                time++;
                stack.pop();
            }
            i++;
        }
        return res;
    }
}
