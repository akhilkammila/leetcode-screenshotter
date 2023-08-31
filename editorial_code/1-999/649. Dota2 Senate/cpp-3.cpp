class Solution {
public:
    string predictPartyVictory(string senate) {
        
        // Number of Senator
        int n = senate.size();

        // Queues with Senator's Index.
        // Index will be used to find the next turn of Senator
        queue<int> rQueue;
        queue<int> dQueue;

        // Populate the Queues
        for (int i = 0; i < n; i++) {
            if (senate[i] == 'R') {
                rQueue.push(i);
            } else {
                dQueue.push(i);
            }
        }

        // While both parties have at least one Senator
        while (!rQueue.empty() && !dQueue.empty()) {
            
            // Pop the Next-Turn Senate from both Q.
            int rTurn = rQueue.front();
            rQueue.pop();
            int dTurn = dQueue.front();
            dQueue.pop();

            // ONE having a larger index will be banned by a lower index
            // Lower index will again get Turn, so EN-Queue again
            // But ensure its turn comes in the next round only
            if (dTurn < rTurn) {
                dQueue.push(dTurn + n);
            } else {
                rQueue.push(rTurn + n);
            }
        }

        // One's which Empty is not winner
        return rQueue.empty() ? "Dire" : "Radiant";
    };
};