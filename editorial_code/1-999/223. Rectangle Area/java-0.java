class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaOfA = (ay2 - ay1) * (ax2 - ax1);
        int areaOfB = (by2 - by1) * (bx2 - bx1);

        // calculate x overlap
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int xOverlap = right - left;

        // calculate y overlap
        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);
        int yOverlap = top - bottom;

        int areaOfOverlap = 0;
        // if the rectangles overlap each other, then calculate
        // the area of the overlap
        if (xOverlap > 0 && yOverlap > 0) {
            areaOfOverlap = xOverlap * yOverlap;
        }

        // areaOfOverlap is counted twice when in the summation of
        // areaOfA and areaOfB, so we need to subtract it from the
        // total, to get the toal area covered by both the rectangles
        int totalArea = areaOfA + areaOfB - areaOfOverlap;

        return totalArea;
    }
}