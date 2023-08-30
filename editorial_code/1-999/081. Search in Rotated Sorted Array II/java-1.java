// returns true if we can reduce the search space in current binary search space
private boolean isBinarySearchHelpful(int[] arr, int left, int element) {
    return arr[left] != element;
}