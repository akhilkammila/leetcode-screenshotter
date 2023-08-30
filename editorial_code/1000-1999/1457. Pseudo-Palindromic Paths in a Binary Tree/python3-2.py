# if it's a leaf, 
# check that at most one digit has an odd frequency
if path & (path - 1) == 0:
    count += 1