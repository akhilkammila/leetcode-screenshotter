function computeArea(
    ax1: number,
    ay1: number,
    ax2: number,
    ay2: number,
    bx1: number,
    by1: number,
    bx2: number,
    by2: number
): number {
    const areaOfA: number = (ay2 - ay1) * (ax2 - ax1);
    const areaOfB: number = (by2 - by1) * (bx2 - bx1);

    // calculate x overlap
    const left: number = Math.max(ax1, bx1);
    const right: number = Math.min(ax2, bx2);
    const xOverlap: number = right - left;

    // calculate y overlap
    const top: number = Math.min(ay2, by2);
    const bottom: number = Math.max(ay1, by1);
    const yOverlap: number = top - bottom;

    let areaOfOverlap: number = 0;
    // if the rectangles overlap each other, then calculate
    // the area of the overlap
    if (xOverlap > 0 && yOverlap > 0) {
        areaOfOverlap = xOverlap * yOverlap;
    }

    // areaOfOverlap is counted twice when in the summation of
    // areaOfA and areaOfB, so we need to subtract it from the
    // total, to get the toal area covered by both the rectangles
    const totalArea: number = areaOfA + areaOfB - areaOfOverlap;
    return totalArea;
}