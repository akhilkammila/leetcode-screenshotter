class Solution(object):
    def movesToStamp(self, stamp, target):
        M, N = len(stamp), len(target)

        queue = collections.deque()
        done = [False] * N
        ans = []
        A = []
        for i in xrange(N - M + 1):
            # For each window [i, i+M),
            # A[i] will contain info on what needs to change
            # before we can reverse stamp at i.

            made, todo = set(), set()
            for j, c in enumerate(stamp):
                a = target[i+j]
                if a == c:
                    made.add(i+j)
                else:
                    todo.add(i+j)
            A.append((made, todo))

            # If we can reverse stamp at i immediately,
            # enqueue letters from this window.
            if not todo:
                ans.append(i)
                for j in xrange(i, i + len(stamp)):
                    if not done[j]:
                        queue.append(j)
                        done[j] = True

        # For each enqueued letter,
        while queue:
            i = queue.popleft()

            # For each window that is potentially affected,
            # j: start of window
            for j in xrange(max(0, i-M+1), min(N-M, i)+1):
                if i in A[j][1]:  # This window is affected
                    A[j][1].discard(i) # Remove it from todo list of this window
                    if not A[j][1]:  # Todo list of this window is empty
                        ans.append(j)
                        for m in A[j][0]: # For each letter to potentially enqueue,
                            if not done[m]:
                                queue.append(m)
                                done[m] = True

        return ans[::-1] if all(done) else []