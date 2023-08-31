class ParkingSystem {

    // Number of empty slots for each type of car
    empty: number[];

    constructor(big: number, medium: number, small: number) {
        this.empty = [big, medium, small];
    }

    addCar(carType: number): boolean {

        // If space is available, allocate and return True
        if (this.empty[carType - 1] > 0) {
            this.empty[carType - 1]--;
            return true;
        }

        // Else, return False
        return false;
    }
}