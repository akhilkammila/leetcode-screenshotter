class Solution {
    func successfulPairs(_ spells: [Int], _ potions: [Int], _ success: Int) -> [Int] {
        // Sort the potions array in increasing order.
        let sortedPotions = potions.sorted()
        var answer = [Int]()

        let m = sortedPotions.count
        let maxPotion = sortedPotions[m - 1]

        for spell in spells {
            // Minimum value of potion whose product with current spell
            // will be at least success or more.
            let minPotion = Int(ceil(Double(success) / Double(spell)))
            // Check if we don't have any potion which can be used.
            if minPotion > maxPotion {
                answer.append(0)
                continue
            }
            // We can use the found potion, and all potion in its right
            // (as the right potions are greater than the found potion).
            let index = lowerBound(in: sortedPotions, forValue: minPotion)
            answer.append(m - index)
        }

        return answer
    }
    
    // Returns the lower bound of 'key' in the sorted array 'arr'.
    private func lowerBound(in arr: [Int], forValue key: Int) -> Int {
        var low = 0, high = arr.count
        while low < high {
            let mid = (low + high) / 2
            if arr[mid] < key {
                low = mid + 1
            } else {
                high = mid
            }
        }
        return low
    }
}