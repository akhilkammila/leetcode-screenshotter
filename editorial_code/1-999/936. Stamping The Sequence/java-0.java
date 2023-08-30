class Solution {
    public int[] movesToStamp(String stamp, String target) {
        int M = stamp.length(), N = target.length();
        Queue<Integer> queue = new ArrayDeque();
        boolean[] done = new boolean[N];
        Stack<Integer> ans = new Stack();
        List<Node> A = new ArrayList();

        for (int i = 0; i <= N-M; ++i) {
            // For each window [i, i+M), A[i] will contain
            // info on what needs to change before we can
            // reverse stamp at this window.

            Set<Integer> made = new HashSet();
            Set<Integer> todo = new HashSet();
            for (int j = 0; j < M; ++j) {
                if (target.charAt(i+j) == stamp.charAt(j))
                    made.add(i+j);
                else
                    todo.add(i+j);
            }

            A.add(new Node(made, todo));

            // If we can reverse stamp at i immediately,
            // enqueue letters from this window.
            if (todo.isEmpty()) {
                ans.push(i);
                for (int j = i; j < i + M; ++j) if (!done[j]) {
                    queue.add(j);
                    done[j] = true;
                }
            }
        }

        // For each enqueued letter (position),
        while (!queue.isEmpty()) {
            int i = queue.poll();

            // For each window that is potentially affected,
            // j: start of window
            for (int j = Math.max(0, i-M+1); j <= Math.min(N-M, i); ++j) {
                if (A.get(j).todo.contains(i)) {  // This window is affected
                    A.get(j).todo.remove(i);
                    if (A.get(j).todo.isEmpty()) {
                        ans.push(j);
                        for (int m: A.get(j).made) if (!done[m]) {
                            queue.add(m);
                            done[m] = true;
                        }
                    }
                }
            }
        }

        for (boolean b: done)
            if (!b) return new int[0];

        int[] ret = new int[ans.size()];
        int t = 0;
        while (!ans.isEmpty())
            ret[t++] = ans.pop();

        return ret;
    }
}

class Node {
    Set<Integer> made, todo;
    Node(Set<Integer> m, Set<Integer> t) {
        made = m;
        todo = t;
    }
}