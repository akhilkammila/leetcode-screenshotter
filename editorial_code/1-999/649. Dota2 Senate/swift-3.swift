class Solution {
    func predictPartyVictory(_ senate: String) -> String {
        
        // Number of Senator
        let n = senate.count

        // Queues with Senator's Index.
        // Index will be used to find the next turn of Senator
        var rQueue = [Int]()
        var dQueue = [Int]()

        // Populate the Queues
        for i in 0..<n {
            if senate[senate.index(senate.startIndex, offsetBy: i)] == "R" {
                rQueue.append(i)
            } else {
                dQueue.append(i)
            }
        }

        // While both parties have at least one Senator
        while rQueue.count > 0 && dQueue.count > 0 {
            
            // Pop the Next-Turn Senate from both Q.
            let rTurn = rQueue.removeFirst()
            let dTurn = dQueue.removeFirst()

            // ONE having a larger index will be banned by a lower index
            // Lower index will again get Turn, so EN-Queue again
            // But ensure its turn comes in the next round only
            if dTurn < rTurn {
                dQueue.append(dTurn + n)
            } else {
                rQueue.append(rTurn + n)
            }
        }

        // One's which Empty is not winner
        return rQueue.count == 0 ? "Dire" : "Radiant"
    }
}