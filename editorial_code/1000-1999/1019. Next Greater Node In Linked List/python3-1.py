# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def nextLargerNodes(self, head: ListNode) -> List[int]:
        answer, stack = [], []
        # We use an integer 'cnt' to represent the index.
        cnt = 0
        
        while head:
        # Set the next greate value of the current value 'head.val' as 0 by default.
            answer.append(0)
            while stack and head.val > stack[-1][1]:
                curr_id, val = stack.pop()
                answer[curr_id] = head.val

            # Add both the index and the value to stack.
            stack.append([cnt, head.val])
            cnt += 1
            head = head.next
        
        return answer
