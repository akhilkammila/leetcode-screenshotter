class PhoneDirectory {
    // Queue to store all available slots.
    queue<int> slotsAvailableQueue;

    // Array to mark if a slot is available.
    vector<bool> isSlotAvailable;

public:
    PhoneDirectory(int maxNumbers) {
        // Initially, all slots are available.
        isSlotAvailable = vector<bool>(maxNumbers, true);
        for (int i = 0; i < maxNumbers; ++i) {
            slotsAvailableQueue.push(i);
        }
    }
    
    int get() {
        // If the queue is empty it means no slot is available.
        if (slotsAvailableQueue.size() == 0) {
            return -1;
        }

        // Otherwise, pop the first element from the queue, 
        // mark that slot as not available and return the slot.
        int slot = slotsAvailableQueue.front();
        slotsAvailableQueue.pop();
        isSlotAvailable[slot] = false;
        return slot;
    }
    
    bool check(int number) {
        // Check if the slot at index 'number' is available or not.
        return isSlotAvailable[number];
    }
    
    void release(int number) {
        // If the slot is already present in the queue, we don't do anything.
        if (isSlotAvailable[number]) {
            return;
        }

        // Otherwise, mark the slot 'number' as available.
        slotsAvailableQueue.push(number);
        isSlotAvailable[number] = true;
    }
};