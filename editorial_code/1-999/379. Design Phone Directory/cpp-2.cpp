class PhoneDirectory {
    // Hash set to store all available slots.
    unordered_set<int> slotsAvailable;

public:
    PhoneDirectory(int maxNumbers) {
        // Initially, all slots are available.
        for (int i = 0; i < maxNumbers; ++i) {
            slotsAvailable.insert(i);
        }
    }
    
    int get() {
        // If the hash set is empty it means no slot is available.
        if (slotsAvailable.size() == 0) {
            return -1;
        }

        // Otherwise, pop the first element from the hash set and return the slot. 
        int slot = *(slotsAvailable.begin());
        slotsAvailable.erase(slot);
        return slot;
    }
    
    bool check(int number) {
        // Check if the slot at index 'number' is available or not.
        return slotsAvailable.find(number) != slotsAvailable.end();
    }
    
    void release(int number) {
        // Mark the slot 'number' as available.
        slotsAvailable.insert(number);
    }
};