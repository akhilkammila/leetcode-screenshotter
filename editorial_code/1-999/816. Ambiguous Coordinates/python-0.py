class Solution(object):
    def ambiguousCoordinates(self, S):
        def make(frag):
            N = len(frag)
            for d in xrange(1, N+1):
                left = frag[:d]
                right = frag[d:]
                if ((not left.startswith('0') or left == '0')
                        and (not right.endswith('0'))):
                    yield left + ('.' if d != N else '') + right

        S = S[1:-1]
        return ["({}, {})".format(*cand)
                for i in xrange(1, len(S))
                for cand in itertools.product(make(S[:i]), make(S[i:]))]