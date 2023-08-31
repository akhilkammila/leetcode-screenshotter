function computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2) {
    const areaOfA = (ay2 - ay1) * (ax2 - ax1);
    const areaOfB = (by2 - by1) * (bx2 - bx1);

    // calculate x overlap
    const left = Math.max(ax1, bx1);
    const right = Math.min(ax2, bx2);
    const xOverlap = right - left;

    // calculate y overlap
    const top = Math.min(ay2, by2);
    const bottom = Math.max(ay1, by1);
    const yOverlap = top - bottom;

    let areaOfOverlap = 0;
    // if the rectangles overlap each other, then calculate
    // the area of the overlap
    if (xOverlap > 0 && yOverlap > 0) {
        areaOfOverlap = xOverlap * yOverlap;
    }

    // areaOfOverlap is counted twice when in the summation of
    // areaOfA and areaOfB, so we need to subtract it from the
    // total, to get the toal area covered by both the rectangles
    const totalArea = areaOfA + areaOfB - areaOfOverlap;

    return totalArea;
};