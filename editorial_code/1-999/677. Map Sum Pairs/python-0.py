class MapSum(object):
    def __init__(self):
        self.map = {}

    def insert(self, key, val):
        self.map[key] = val

    def sum(self, prefix):
        return sum(val for key, val in self.map.items()
                   if key.startswith(prefix))