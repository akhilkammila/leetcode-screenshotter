class Solution {

    // Ban the candidate "toBan", immediate next to "startAt"
    // If have to loop around, then it means next turn will be of
    // senator at same index. Returns loop around boolean
    public boolean ban(StringBuilder senateArray, char toBan, int startAt) {

        boolean loopAround = false;
        int pointer = startAt;

        while (true) {
            if (pointer == 0) {
                loopAround = true;
            }
            if (senateArray.charAt(pointer) == toBan) {
                senateArray.deleteCharAt(pointer);
                break;
            }
            pointer = (pointer + 1) % senateArray.length();
        }

        return loopAround;
    }

    public String predictPartyVictory(String senate) {

        // Convert to StringBuilder for easy deletion
        StringBuilder senateArray = new StringBuilder(senate);

        // Count of Each Type of Senator to check for Winner
        int rCount = 0;
        int dCount = 0;
        for (int i = 0; i < senateArray.length(); i++) {
            if (senateArray.charAt(i) == 'R') {
                rCount++;
            } else {
                dCount++;
            }
        }

        // Turn of Senator at this index
        int turn = 0;

        // While No Winner
        while (rCount > 0 && dCount > 0) {

            // Ban the next opponent, starting at one index ahead
            // Taking MOD to loop around.
            // If index of banned senator is before current index,
            // then we need to decrement turn by 1, as we have removed
            // a senator from list
            if (senateArray.charAt(turn) == 'R') {
                boolean bannedSenatorBefore = ban(senateArray, 'D', (turn + 1) % senateArray.length());
                if (bannedSenatorBefore) {
                    turn--;
                }
                dCount--;
            } else {
                boolean bannedSenatorBefore = ban(senateArray, 'R', (turn + 1) % senateArray.length());
                if (bannedSenatorBefore) {
                    turn--;
                }
                rCount--;
            }

            // Increment Turn
            turn = (turn + 1) % senateArray.length();
        }

        // Return Winner
        if (rCount > 0) {
            return "Radiant";
        } else {
            return "Dire";
        }
    }
}