public int partition(int left, int right, int pivot_index) {
    int pivot_frequency = count.get(unique[pivot_index]);
    // 1. move pivot to end
    swap(pivot_index, right);
    int store_index = left;

    // 2. move all less frequent elements to the left
    for (int i = left; i <= right; i++) {
        if (count.get(unique[i]) < pivot_frequency) {
            swap(store_index, i);
            store_index++;
        }
    }

    // 3. move pivot to its final place
    swap(store_index, right);

    return store_index;
}