var PhoneDirectory = function(maxNumbers) {
    // Array to mark if a slot is available.
    this.isSlotAvailable = new Array(maxNumbers).fill(true);
};

PhoneDirectory.prototype.get = function() {
    // Find an empty slot and return the respective index.
    const index = this.isSlotAvailable.findIndex((available) => available);
    if (index !== -1) {
      this.isSlotAvailable[index] = false;
    }
    return index;
};

PhoneDirectory.prototype.check = function(number) {
    // Check if the slot at index 'number' is available or not.
    return this.isSlotAvailable[number];
};

PhoneDirectory.prototype.release = function(number) {
    // Mark the slot at index 'number' as available.
    this.isSlotAvailable[number] = true;
};