class ParkingSystem:

    def __init__(self, big: int, medium: int, small: int):

        # Number of empty slots for each type of car
        self.empty = [big, medium, small]

    def addCar(self, carType: int) -> bool:

        # If space is available, allocate and return True
        if self.empty[carType - 1] > 0:
            self.empty[carType - 1] -= 1
            return True

        # Else, return False
        return False