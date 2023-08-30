class Codec:
    def encode(self, strs):
        """
        Encodes a list of strings to a single string.

        :param strs: List of strings to encode.
        :return: Encoded string.
        """
        # Initialize an empty string to hold the encoded strings
        encoded_string = ''

        # Iterate over each string in the input list
        for s in strs:
            # Replace each occurrence of '/' with '//'
            # This is our way of "escaping" the slash character
            # Then add our delimiter '/:' to the end
            encoded_string += s.replace('/', '//') + '/:'

        # Return the final encoded string
        return encoded_string

    def decode(self, s):
        """
        Decodes a single string to a list of strings.

        :param s: String to decode.
        :return: List of decoded strings.
        """
        # Initialize an empty list to hold the decoded strings
        decoded_strings = []

        # Initialize a string to hold the current string being built
        current_string = ""

        # Initialize an index 'i' to start of the string
        i = 0

        # Iterate while 'i' is less than the length of the encoded string
        while i < len(s):
            # If we encounter the delimiter '/:'
            if s[i:i+2] == '/:':
                # Add the current_string to the list of decoded_strings
                decoded_strings.append(current_string)

                # Clear current_string for the next string
                current_string = ""

                # Move the index 2 steps forward to skip the delimiter
                i += 2

            # If we encounter an escaped slash '//'
            elif s[i:i+2] == '//':
                # Add a single slash to the current_string
                current_string += '/'

                # Move the index 2 steps forward to skip the escaped slash
                i += 2

            # Otherwise, just add the character to current_string
            else:
                current_string += s[i]
                i += 1

        # Return the list of decoded strings
        return decoded_strings