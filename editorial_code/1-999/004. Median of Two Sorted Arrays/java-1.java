class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int na = A.length, nb = B.length;
        int n = na + nb;
        if ((na + nb) % 2 == 1) {
            return solve(A, B, n / 2, 0, na - 1, 0, nb - 1);
        } else {
            return (double)(solve(A, B, n / 2, 0, na - 1, 0, nb - 1) + solve(A, B, n / 2 - 1, 0, na - 1, 0, nb - 1)) / 2;
        }
    }
    
    public int solve(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {
        // If the segment of on array is empty, it means we have passed all
        // its element, just return the corresponding element in the other array.
        if (aEnd < aStart) {
            return B[k - aStart];
        }
        if (bEnd < bStart) {
            return A[k - bStart];
        }
        
        // Get the middle indexes and middle values of A and B.
        int aIndex = (aStart + aEnd) / 2, bIndex = (bStart + bEnd) / 2;
        int aValue = A[aIndex], bValue = B[bIndex];
        
        // If k is in the right half of A + B, remove the larger right half.
        if (aIndex + bIndex < k) { 
            if (aValue > bValue) {
                return solve(A, B, k, aStart, aEnd, bIndex + 1, bEnd);
            } else {
                return solve(A, B, k, aIndex + 1, aEnd, bStart, bEnd);
            }
        }
        // Otherwise, remove the smaller left half. 
        else { 
            if (aValue > bValue) {
                return solve(A, B, k, aStart, aIndex - 1, bStart, bEnd);
            } else {
                return solve(A, B, k, aStart, aEnd, bStart, bIndex - 1);       
            }
        }
    }
}