class Solution:
    def guessMajority(self, reader: 'ArrayReader') -> int:
        n = reader.length()
        cnt_equal = 1
        cnt_differ = 0
        index_differ = -1

        def f(equal, i):
            nonlocal cnt_equal, cnt_differ, index_differ
            if equal:
                cnt_equal += 1
            else:
                cnt_differ += 1
                index_differ = i

        query0123 = reader.query(0, 1, 2, 3)
        query1234 = reader.query(1, 2, 3, 4)
        f(reader.query(1, 2, 3, 4) == query0123, 4)
        for i in range(5, n):
            f(reader.query(1, 2, 3, i) == query0123, i)
        f(reader.query(0, 2, 3, 4) == query1234, 1)
        f(reader.query(0, 1, 3, 4) == query1234, 2)
        f(reader.query(0, 1, 2, 4) == query1234, 3)
        return (0 if cnt_equal > cnt_differ else index_differ
                if cnt_differ > cnt_equal else -1)