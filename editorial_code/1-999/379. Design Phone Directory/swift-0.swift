
class PhoneDirectory {
    // Array to mark if a slot is available.
    private var isSlotAvailable: [Bool]

    init(_ maxNumbers: Int) {
        isSlotAvailable = [Bool](repeating: true, count: maxNumbers)
    }

    func get() -> Int {
        // Traverse the 'isSlotAvailable' array to find an empty slot.
        // If found then return the respective index.
        if let index = isSlotAvailable.firstIndex(where: { $0 }) {
            isSlotAvailable[index] = false
            return index
        }

        // Otherwise, return -1 when all slots are occupied.
        return -1
    }

    func check(_ number: Int) -> Bool {
        // Check if the slot at index 'number' is available.
        return isSlotAvailable[number]
    }

    func release(_ number: Int) {
        // Mark the slot at index 'number' as available.
        isSlotAvailable[number] = true
    }
}