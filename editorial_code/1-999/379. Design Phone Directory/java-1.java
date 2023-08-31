class PhoneDirectory {
    // Queue to store all available slots.
    private Queue<Integer> slotsAvailableQueue;

    // Array to mark if a slot is available.
    private boolean[] isSlotAvailable;

    public PhoneDirectory(int maxNumbers) {
        // Initially, all slots are available.
        isSlotAvailable = new boolean[maxNumbers];
        for (int i = 0; i < maxNumbers; ++i) {
            isSlotAvailable[i] = true;
        }
        slotsAvailableQueue = new ArrayDeque<>(maxNumbers);
        for (int i = 0; i < maxNumbers; ++i) {
            slotsAvailableQueue.offer(i);
        }
    }

    public int get() {
        // If the queue is empty it means no slot is available.
        if (slotsAvailableQueue.isEmpty()) {
            return -1;
        }

        // Otherwise, poll the first element from the queue,
        // mark that slot as not available and return the slot.
        int slot = slotsAvailableQueue.poll();
        isSlotAvailable[slot] = false;
        return slot;
    }

    public boolean check(int number) {
        // Check if the slot at index 'number' is available or not.
        return isSlotAvailable[number];
    }

    public void release(int number) {
        // If the slot is already present in the queue, we don't do anything.
        if (isSlotAvailable[number]) {
            return;
        }

        // Otherwise, mark the slot 'number' as available.
        slotsAvailableQueue.offer(number);
        isSlotAvailable[number] = true;
    }
}