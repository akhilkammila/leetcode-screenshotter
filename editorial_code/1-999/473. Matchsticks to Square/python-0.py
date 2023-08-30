def makesquare(self, nums):
    """
    :type nums: List[int]
    :rtype: bool
    """

    # If there are no matchsticks, then we can't form any square
    if not nums:
        return False

    # Number of matchsticks we have
    L = len(nums)

    # Perimeter of our square (if one can be formed)
    perimeter = sum(nums)

    # Possible side of our square.
    possible_side =  perimeter // 4

    # If the perimeter can be equally split into 4 parts (and hence 4 sides, then we move on).
    if possible_side * 4 != perimeter:
        return False

    # Reverse sort the matchsticks because we want to consider the biggest one first.
    nums.sort(reverse=True)

    # This array represents the 4 sides and their current lengths
    sums = [0 for _ in range(4)]

    # Our recursive dfs function.
    def dfs(index):

        # If we reach the end of matchsticks array, we check if the square was formed or not
        if index == L:
            # If 3 equal sides were formed, 4th will be the same as these three and answer should be True in that case.
            return sums[0] == sums[1] == sums[2] == possible_side

        # The current matchstick can belong to any of the 4 sides (provided their remaining lenghts are >= the size of the current matchstick)
        for i in range(4):
            # If this matchstick can fir in the space left for the current side
            if sums[i] + nums[index] <= possible_side:
                # Recurse
                sums[i] += nums[index]
                if dfs(index + 1):
                    return True
                # Revert the effects of recursion because we no longer need them for other recursions.
                sums[i] -= nums[index]
        return False        
    return dfs(0)