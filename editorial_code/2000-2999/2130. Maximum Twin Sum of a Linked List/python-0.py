class Solution(object):
    def pairSum(self, head):
        current = head
        values = []

        while current:
            values.append(current.val)
            current = current.next
        
        i = 0
        j = len(values) - 1
        maximumSum = 0
        while(i < j):
            maximumSum = max(maximumSum, values[i] + values[j])
            i = i + 1
            j = j - 1
        
        return maximumSum