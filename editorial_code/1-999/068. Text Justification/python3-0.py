def get_words(i):
    current_line = []
    curr_length = 0

    while i < len(words) and curr_length + len(words[i]) <= maxWidth:
        current_line.append(words[i])
        curr_length += len(words[i]) + 1
        i += 1
    
    return current_line