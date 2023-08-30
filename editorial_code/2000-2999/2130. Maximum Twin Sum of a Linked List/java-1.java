class Solution {
    public int pairSum(ListNode head) {
        ListNode current = head;
        Stack<Integer> st = new Stack<Integer>();

        while (current != null) {
            st.push(current.val);
            current = current.next;
        }

        current = head;
        int size = st.size(), count = 1;
        int maximumSum = 0;
        while (count <= size / 2) {
            maximumSum = Math.max(maximumSum, current.val + st.peek());
            current = current.next;
            st.pop();
            count++;
        }

        return maximumSum;
    }
}