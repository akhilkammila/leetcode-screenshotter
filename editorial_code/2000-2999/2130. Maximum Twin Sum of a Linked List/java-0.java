class Solution {
    public int pairSum(ListNode head) {
        ListNode current = head;
        List<Integer> values = new ArrayList<>();

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        int i = 0, j = values.size() - 1;
        int maximumSum = 0;
        while (i < j) {
            maximumSum = Math.max(maximumSum, values.get(i) + values.get(j));
            i++;
            j--;
        }

        return maximumSum;
    }
}