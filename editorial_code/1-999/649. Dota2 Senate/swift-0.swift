class Solution {
    func predictPartyVictory(_ senate: String) -> String {

        var senate = Array(senate)
        
        // Count of Each Type of Senator to check for Winner
        var rCount = senate.filter({$0 == "R"}).count
        var dCount = senate.count - rCount

        // Ban the candidate "toBan", immediate next to "startAt"
        // If have to loop around, then it means next turn will be of
        // senator at same index. Returns loop around boolean
        func ban(_ toBan: Character, _ startAt: Int) -> Bool {
            var loopAround = false
            var pointer = startAt

            while true {
                if pointer == 0 {
                    loopAround = true
                }
                if senate[senate.index(senate.startIndex, offsetBy: pointer)] == toBan {
                    senate.remove(at: senate.index(senate.startIndex, offsetBy: pointer))
                    break
                }
                pointer = (pointer + 1) % senate.count
            }

            return loopAround
        }

        // Turn of Senator at this index
        var turn = 0

        // While No Winner
        while rCount > 0 && dCount > 0 {

            // Ban the next opponent, starting at one index ahead
            // Taking MOD to loop around.
            // If index of banned senator is before current index,
            // then we need to decrement turn by 1, as we have removed
            // a senator from list
            if senate[senate.index(senate.startIndex, offsetBy: turn)] == "R" {
                let bannedSenatorBefore = ban("D", (turn + 1) % senate.count)
                dCount -= 1
                if bannedSenatorBefore {
                    turn -= 1
                }
            } else {
                let bannedSenatorBefore = ban("R", (turn + 1) % senate.count)
                rCount -= 1
                if bannedSenatorBefore {
                    turn -= 1
                }
            }

            // Increment turn by 1
            turn = (turn + 1) % senate.count
        }

        // Return Winner depending on count
        return dCount == 0 ? "Radiant" : "Dire"
    }
}