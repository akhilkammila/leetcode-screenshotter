class Codec:
    def encode(self, strs):
        # Initialize an empty string to hold the encoded string.
        encoded_string = ''
        for s in strs:
            # Append the length, the delimiter, and the string itself.
            encoded_string += str(len(s)) + '/:' + s
        return encoded_string

    def decode(self, s):
        # Initialize a list to hold the decoded strings.
        decoded_strings = []
        i = 0
        while i < len(s):
            # Find the delimiter.
            delim = s.find('/:', i)
            # Get the length, which is before the delimiter.
            length = int(s[i:delim])
            # Get the string, which is of 'length' length after the delimiter.
            str_ = s[delim+2 : delim+2+length]
            # Add the string to the list.
            decoded_strings.append(str_)
            # Move the index to the start of the next length.
            i = delim + 2 + length
        return decoded_strings