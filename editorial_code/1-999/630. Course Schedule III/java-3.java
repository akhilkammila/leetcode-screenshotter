public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        List< Integer > valid_list = new ArrayList < > ();
        int time = 0;
        for (int[] c: courses) {
            if (time + c[0] <= c[1]) {
                valid_list.add(c[0]);
                time += c[0];
            } else {
                int max_i=0;
                for(int i=1; i < valid_list.size(); i++) {
                    if(valid_list.get(i) > valid_list.get(max_i))
                        max_i = i;
                }
                if (valid_list.get(max_i) > c[0]) {
                    time += c[0] - valid_list.get(max_i);
                    valid_list.set(max_i, c[0]);
                }
            }
        }
        return valid_list.size();
    }
}