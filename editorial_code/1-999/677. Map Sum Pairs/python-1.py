class MapSum(object):
    def __init__(self):
        self.map = {}
        self.score = collections.Counter()

    def insert(self, key, val):
        delta = val - self.map.get(key, 0)
        self.map[key] = val
        for i in xrange(len(key) + 1):
            prefix = key[:i]
            self.score[prefix] += delta

    def sum(self, prefix):
        return self.score[prefix]