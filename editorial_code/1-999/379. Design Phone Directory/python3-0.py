class PhoneDirectory:
    def __init__(self, maxNumbers):
        # List to mark if a slot is available.
        self.is_slot_available = [True] * maxNumbers

    def get(self):
        # Find an empty slot and return the respective index.
        index = next((i for i, available in enumerate(self.is_slot_available) if available), -1)
        if index != -1:
            self.is_slot_available[index] = False
        return index

    def check(self, number):
        # Check if the slot at index 'number' is available.
        return self.is_slot_available[number]

    def release(self, number):
        # Mark the slot at index 'number' as available.
        self.is_slot_available[number] = True