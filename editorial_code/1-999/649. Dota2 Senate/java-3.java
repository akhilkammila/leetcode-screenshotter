class Solution {
    public String predictPartyVictory(String senate) {
        
        // Number of Senator
        int n = senate.length();

        // Queues with Senator's Index.
        // Index will be used to find the next turn of Senator
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        // Populate the Queues
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.add(i);
            } else {
                dQueue.add(i);
            }
        }

        // While both parties have at least one Senator
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            
            // Pop the Next-Turn Senate from both Q.
            int rTurn = rQueue.poll();
            int dTurn = dQueue.poll();

            // ONE having a larger index will be banned by a lower index
            // Lower index will again get Turn, so EN-Queue again
            // But ensure its turn comes in the next round only
            if (dTurn < rTurn) {
                dQueue.add(dTurn + n);
            } else {
                rQueue.add(rTurn + n);
            }
        }

        // One's which Empty is not winner
        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}