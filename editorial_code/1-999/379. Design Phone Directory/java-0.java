class PhoneDirectory {
    // Array to mark if a slot is available.
    private boolean[] isSlotAvailable;

    public PhoneDirectory(int maxNumbers) {
        isSlotAvailable = new boolean[maxNumbers];
        Arrays.fill(isSlotAvailable, true);
    }

    public int get() {
        // Traverse the 'isSlotAvailable' array to find an empty slot.
        // If found then return the respective index.
        for (int i = 0; i < isSlotAvailable.length; ++i) {
            if (isSlotAvailable[i]) {
                isSlotAvailable[i] = false;
                return i;
            }
        }
        
        // Otherwise, return -1 when all slots are occupied.
        return -1;
    }

    public boolean check(int number) {
        // Check if the slot at index 'number' is available.
        return isSlotAvailable[number];
    }

    public void release(int number) {
        // Mark the slot at index 'number' as available.
        isSlotAvailable[number] = true;
    }
}