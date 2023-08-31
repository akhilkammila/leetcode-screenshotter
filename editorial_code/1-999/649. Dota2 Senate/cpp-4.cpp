class Solution {
public:
    string predictPartyVictory(string senate) {
        
        // Number of Senators of each party
        int rCount = 0, dCount = 0;

        // Floating Ban Count
        int dFloatingBan = 0, rFloatingBan = 0;

        // Queue of Senators
        queue<char> q;
        for (char c : senate) {
            q.push(c);
            if (c == 'R') rCount++;
            else dCount++;
        }

        // While any party has eligible Senators
        while (rCount && dCount) {

            // Pop the senator with turn
            char curr = q.front();
            q.pop();

            // If eligible, float the ban on the other party, enqueue again.
            // If not, decrement the floating ban and count of the party.
            if (curr == 'D') {
                if (dFloatingBan) {
                    dFloatingBan--;
                    dCount--;
                } else {
                    rFloatingBan++;
                    q.push('D');
                }
            } else {
                if (rFloatingBan) {
                    rFloatingBan--;
                    rCount--;
                } else {
                    dFloatingBan++;
                    q.push('R');
                }
            }
        }

        // Return the party with eligible Senators
        return rCount ? "Radiant" : "Dire";
    }
};