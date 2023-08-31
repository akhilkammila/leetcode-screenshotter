def compute_area(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2)
    areaOfA = (ay2 - ay1) * (ax2 - ax1)
    areaOfB = (by2 - by1) * (bx2 - bx1)

    # calculate x overlap
    left = [ax1, bx1].max
    right = [ax2, bx2].min
    xOverlap = right - left

    # calculate y overlap
    top = [ay2, by2].min
    bottom = [ay1, by1].max
    yOverlap = top - bottom

    areaOfOverlap = 0
    # if the rectangles overlap each other, then calculate
    # the area of the overlap
    if xOverlap > 0 and yOverlap > 0
        areaOfOverlap = xOverlap * yOverlap
    end

    # areaOfOverlap is counted twice when in the summation of
    # areaOfA and areaOfB, so we need to subtract it from the
    # total, to get the toal area covered by both the rectangles
    totalArea = areaOfA + areaOfB - areaOfOverlap

    return totalArea
end