class Solution {
    func predictPartyVictory(_ senate: String) -> String {
        
        // Number of Senators of each party
        var rCount = 0, dCount = 0

        // Floating Ban Count
        var dFloatingBan = 0, rFloatingBan = 0

        // Queue of Senators
        var q = [Character]()
        for c in senate {
            q.append(c)
            if c == "R" {
                rCount += 1
            } else {
                dCount += 1
            }
        }

        // While any party has eligible Senators
        while rCount > 0 && dCount > 0 {

            // Pop the senator with turn
            let curr = q.removeFirst()

            // If eligible, float the ban on the other party, enqueue again.
            // If not, decrement the floating ban and count of the party.
            if curr == "D" {
                if dFloatingBan > 0 {
                    dFloatingBan -= 1
                    dCount -= 1
                } else {
                    rFloatingBan += 1
                    q.append("D")
                }
            } else {
                if rFloatingBan > 0 {
                    rFloatingBan -= 1
                    rCount -= 1
                } else {
                    dFloatingBan += 1
                    q.append("R")
                }
            }
        }

        // Return the party with eligible Senators
        return rCount > 0 ? "Radiant" : "Dire"
    }
}