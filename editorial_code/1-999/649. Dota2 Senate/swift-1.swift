class Solution {
    func predictPartyVictory(_ senate: String) -> String {
        
        // Count of Each Type of Senator to check for Winner
        var rCount = senate.filter({$0 == "R"}).count
        var dCount = senate.count - rCount

        // To mark Banned Senators
        var banned = Array(repeating: false, count: senate.count)

        // Ban the candidate "toBan", immediate next to "startAt"
        func ban(_ toBan: Character, _ startAt: Int) {
            // Find the next eligible senator of "toBan" type
            // On found, mark him as banned
            var startAt = startAt
            while true {
                if senate[senate.index(senate.startIndex, offsetBy: startAt)] == toBan && !banned[startAt] {
                    banned[startAt] = true
                    break
                }
                startAt = (startAt + 1) % senate.count
            }
        }

        // Turn of Senator at this Index
        var turn = 0

        // While both parties have at least one senator
        while rCount > 0 && dCount > 0 {

            if !banned[turn] {
                if senate[senate.index(senate.startIndex, offsetBy: turn)] == "R" {
                    ban("D", (turn + 1) % senate.count)
                    dCount -= 1
                } else {
                    ban("R", (turn + 1) % senate.count)
                    rCount -= 1
                }
            }

            turn = (turn + 1) % senate.count
        }

        // Return Winner depending on the count of each party
        return dCount == 0 ? "Radiant" : "Dire"
    }
}