class Solution {

    // Ban the candidate "toBan", immediate next to "startAt"
    public void ban(String senate, boolean[] banned, char toBan, int startAt) {
        // Find the next eligible candidate to ban
        int pointer = startAt;
        while (true) {
            if (senate.charAt(pointer) == toBan && !banned[pointer]) {
                banned[pointer] = true;
                break;
            }
            pointer = (pointer + 1) % senate.length();
        }
    }

    public String predictPartyVictory(String senate) {

        // To mark Banned Senators
        boolean[] banned = new boolean[senate.length()];

        // Count of Each Type of Senator who are not-banned
        int rCount = 0, dCount = 0;
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rCount++;
            } else {
                dCount++;
            }
        }

        // Turn of Senator at this Index
        int turn = 0;

        // While both parties have at least one senator
        while (rCount > 0 && dCount > 0) {

            if (!banned[turn]) {
                if (senate.charAt(turn) == 'R') {
                    ban(senate, banned, 'D', (turn + 1) % senate.length());
                    dCount--;
                } else {
                    ban(senate, banned, 'R', (turn + 1) % senate.length());
                    rCount--;
                }
            }

            turn = (turn + 1) % senate.length();
        }

        return dCount == 0 ? "Radiant" : "Dire";
    }
}