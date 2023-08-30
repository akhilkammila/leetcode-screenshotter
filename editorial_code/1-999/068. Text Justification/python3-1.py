def create_line(line, i):
    base_length = -1
    for word in line:
        base_length += len(word) + 1
    
    extra_spaces = maxWidth - base_length
    
    if len(line) == 1 or i == len(words):
        return " ".join(line) + " " * extra_spaces
    
    word_count = len(line) - 1
    spaces_per_word = extra_spaces // word_count
    needs_extra_space = extra_spaces % word_count
    
    for j in range(needs_extra_space):
        line[j] += " "
    
    for j in range(word_count):
        line[j] += " " * spaces_per_word
    
    return " ".join(line)