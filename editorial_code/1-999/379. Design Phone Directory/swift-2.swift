class PhoneDirectory {
    // Hash set to store all available slots.
    private var slotsAvailable: Set<Int>

    init(_ maxNumbers: Int) {
        // Initially, all slots are available.
        slotsAvailable = Set(0..<maxNumbers)
    }

    func get() -> Int {
        // If the hash set is empty, it means no slot is available.
        if slotsAvailable.isEmpty {
            return -1
        }

        // Otherwise, remove and return the first element from the hash set.
        let slot = slotsAvailable.removeFirst()
        return slot
    }

    func check(_ number: Int) -> Bool {
        // Check if the slot at index 'number' is available or not.
        return slotsAvailable.contains(number)
    }

    func release(_ number: Int) {
        // Mark the slot 'number' as available.
        slotsAvailable.insert(number)
    }
}