class Solution(object):
    def isRectangleOverlap(self, rec1, rec2):
        # check if either rectangle is actually a line
        if (rec1[0] == rec1[2] or rec1[1] == rec1[3] or \
            rec2[0] == rec2[2] or rec2[1] == rec2[3]):
            # the line cannot have positive overlap
            return False

        return not (rec1[2] <= rec2[0] or  # left
                    rec1[3] <= rec2[1] or  # bottom
                    rec1[0] >= rec2[2] or  # right
                    rec1[1] >= rec2[3])    # top