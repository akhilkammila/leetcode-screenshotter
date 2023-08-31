class Solution {
    public String predictPartyVictory(String senate) {
        
        // Number of Senators of each party
        int rCount = 0, dCount = 0;
       
        // Floating Ban Count
        int dFloatingBan = 0, rFloatingBan = 0;

        // Queue of Senators
        Queue<Character> q = new LinkedList<>();
        for (char c : senate.toCharArray()) {
            q.add(c);
            if (c == 'R') rCount++;
            else dCount++;
        }

        // While any party has eligible Senators
        while (rCount > 0 && dCount > 0) {

            // Pop the senator with turn
            char curr = q.poll();

            // If eligible, float the ban on the other party, enqueue again.
            // If not, decrement the floating ban and count of the party.
            if (curr == 'D') {
                if (dFloatingBan > 0) {
                    dFloatingBan--;
                    dCount--;
                } else {
                    rFloatingBan++;
                    q.add('D');
                }
            } else {
                if (rFloatingBan > 0) {
                    rFloatingBan--;
                    rCount--;
                } else {
                    dFloatingBan++;
                    q.add('R');
                }
            }
        }

        // Return the party with eligible Senators
        return rCount > 0 ? "Radiant" : "Dire";
    }
}