class ParkingSystem {

    // Number of empty slots for each type of car
    var empty: [Int]

    init(_ big: Int, _ medium: Int, _ small: Int) {
        self.empty = [big, medium, small]
    }

    func addCar(_ carType: Int) -> Bool {

        // If space is available, allocate and return True
        if self.empty[carType - 1] > 0 {
            self.empty[carType - 1] -= 1
            return true
        }

        // Else, return False
        return false
    }
}