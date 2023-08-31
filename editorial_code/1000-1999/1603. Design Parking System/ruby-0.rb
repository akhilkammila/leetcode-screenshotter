class ParkingSystem

    # Number of empty slots for each type of car
    attr_accessor :empty

    def initialize(big, medium, small)
        @empty = [big, medium, small]
    end

    def add_car(car_type)
        # If space is available, allocate and return True
        if @empty[car_type - 1] > 0
            @empty[car_type - 1] -= 1
            return true
        end

        # Else, return False
        return false
    end
end