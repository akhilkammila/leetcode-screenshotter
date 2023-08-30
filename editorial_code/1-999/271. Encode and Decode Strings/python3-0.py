class Codec:
    def encode(self, strs):
        """Encodes a list of strings to a single string."""
        return 'π'.join(strs)
        
    def decode(self, s):
        """Decodes a single string to a list of strings."""
        return s.split('π')