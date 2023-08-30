class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        ImmutableListNode curr;
        ImmutableListNode end = null;

        while (head != end) {
            curr = head;
            while (curr.getNext() != end) {
                curr = curr.getNext();
            }
            curr.printValue();
            end = curr;
        }
    }
}