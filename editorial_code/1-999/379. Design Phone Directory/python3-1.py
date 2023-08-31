class PhoneDirectory:
    def __init__(self, max_numbers):
        # Queue to store all available slots.
        self.slots_available_queue = deque(range(max_numbers))

        # List to mark if a slot is available.
        self.is_slot_available = [True] * max_numbers
    
    def get(self):
        # If the queue is empty, it means no slot is available.
        if not self.slots_available_queue:
            return -1

        # Otherwise, get the first available slot from the queue,
        # mark that slot as not available and return the slot.
        slot = self.slots_available_queue.popleft()
        self.is_slot_available[slot] = False
        return slot
    
    def check(self, number):
        # Check if the slot at index 'number' is available or not.
        return self.is_slot_available[number]
    
    def release(self, number):
        # If the slot is already present in the queue, we don't do anything.
        if self.is_slot_available[number]:
            return

        # Otherwise, mark the slot 'number' as available.
        self.slots_available_queue.append(number)
        self.is_slot_available[number] = True