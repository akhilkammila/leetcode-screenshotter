class Solution {
    func predictPartyVictory(_ senate: String) -> String {

        // Number of Senators
        let n = senate.count

        // To mark Banned Senators
        var banned = Array(repeating: false, count: n)

        // List of indices of Eligible Radiant and Dire Senators
        var rIndices = [Int]()
        var dIndices = [Int]()
        for i in 0..<n {
            if senate[senate.index(senate.startIndex, offsetBy: i)] == "R" {
                rIndices.append(i)
            } else {
                dIndices.append(i)
            }
        }

        // Ban the senator of "indices" immediate next to "startAt"
        func ban(_ indices: inout [Int], _ startAt: Int) {
            // Find the index of "index of senator to ban" using Binary Search
            var temp = indices.firstIndex(where: { $0 >= startAt })

            // If startAt is more than the last index,
            // then start from the beginning. Ban the first senator
            if temp == nil {
                banned[indices[0]] = true
                indices.removeFirst()
            }

            // Else, Ban the senator at the index
            else {
                banned[indices[temp!]] = true
                indices.remove(at: temp!)
            }
        }

        // Turn of Senator at this Index
        var turn = 0

        // While both parties have at least one senator
        while !rIndices.isEmpty && !dIndices.isEmpty {
            if !banned[turn] {
                if senate[senate.index(senate.startIndex, offsetBy: turn)] == "R" {
                    ban(&dIndices, turn)
                } else {
                    ban(&rIndices, turn)
                }
            }

            turn = (turn + 1) % n
        }

        // Return the party with at least one senator
        return dIndices.isEmpty ? "Radiant" : "Dire"
    }
}