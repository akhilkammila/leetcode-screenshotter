class PhoneDirectory {
    // Queue to store all available slots.
    private var slotsAvailableQueue: Queue<Int>

    // Array to mark if a slot is available.
    private var isSlotAvailable: [Bool]

    init(_ maxNumbers: Int) {
        // Initially, all slots are available.
        isSlotAvailable = Array(repeating: true, count: maxNumbers)
        slotsAvailableQueue = Queue(array: Array(0..<maxNumbers))
    }

    func get() -> Int {
        // If the queue is empty, it means no slot is available.
        guard let slot = slotsAvailableQueue.dequeue() else {
            return -1
        }

        // Otherwise, mark that slot as not available and return the slot.
        isSlotAvailable[slot] = false
        return slot
    }

    func check(_ number: Int) -> Bool {
        // Check if the slot at index 'number' is available or not.
        return isSlotAvailable[number]
    }

    func release(_ number: Int) {
        // If the slot is already present in the queue, we don't do anything.
        if isSlotAvailable[number] {
            return
        }

        // Otherwise, mark the slot 'number' as available.
        slotsAvailableQueue.enqueue(number)
        isSlotAvailable[number] = true
    }
}

// Implementing queue, using linked list.

class Node<T> {
    var value: T
    var next: Node?
    weak var prev: Node?

    init(_ value: T) {
        self.value = value
    }
}

class Queue<T> {
    private var head: Node<T>?
    private var tail: Node<T>?

    init() {}

    init(array elements: [T]) {
        for element in elements {
            enqueue(element)
        }
    }

    func enqueue(_ item: T) {
        let newNode = Node(item)
        if head == nil {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            newNode.prev = tail
            tail = newNode
        }
    }

    func dequeue() -> T? {
        if let currentHead = head {
            head = currentHead.next
            head?.prev = nil
            return currentHead.value
        }
        return nil
    }

    func isEmpty() -> Bool {
        return head == nil
    }
}