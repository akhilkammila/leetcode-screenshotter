class PhoneDirectory:
    def __init__(self, max_numbers):
        # Hash set to store all available slots.
        self.slots_available = set(range(max_numbers))

    def get(self):
        # If the hash set is empty it means no slot is available.
        if not self.slots_available:
            return -1

        # Otherwise, pop and return the first element from the hash set.
        return self.slots_available.pop()

    def check(self, number):
        # Check if the slot at index 'number' is available or not.
        return number in self.slots_available

    def release(self, number):
        # Mark the slot 'number' as available.
        self.slots_available.add(number)