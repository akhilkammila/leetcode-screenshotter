/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> answer = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        // We use an integer 'cnt' to represent the index.
        int cnt = 0;

        while (head != null) {
            // Set the next greate value of the current value 'head.val' as 0 by default.
            answer.add(0);
            while (!stack.isEmpty() && head.val > stack.peek()[1]) {
                int[] curr = stack.peek();
                int id = curr[0], val = curr[1];
                stack.pop();
                answer.set(id, head.val);
            }
             // Add both the index and the value to stack.
            stack.add(new int[]{cnt++, head.val});
            head = head.next;
        }
    
        return answer.stream().mapToInt(i -> i).toArray();
    }
}