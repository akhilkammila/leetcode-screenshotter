public class Solution {
    public string PredictPartyVictory(string senate) {
        
        // Count of Each Type of Senator to check for Winner
        int rCount = senate.Count(x => x == 'R');
        int dCount = senate.Length - rCount;

        // To mark Banned Senators
        bool[] banned = new bool[senate.Length];

        // Ban the candidate "toBan", immediate next to "startAt"
        Action<char, int> ban = (toBan, startAt) => {
            // Find the next eligible senator of "toBan" type
            // On found, mark him as banned
            while (true) {
                if (senate[startAt] == toBan && !banned[startAt]) {
                    banned[startAt] = true;
                    break;
                }
                startAt = (startAt + 1) % senate.Length;
            }
        };

        // Turn of Senator at this Index
        int turn = 0;

        // While both parties have at least one senator
        while (rCount > 0 && dCount > 0) {

            if (!banned[turn]) {
                if (senate[turn] == 'R') {
                    ban('D', (turn + 1) % senate.Length);
                    dCount--;
                } else {
                    ban('R', (turn + 1) % senate.Length);
                    rCount--;
                }
            }

            turn = (turn + 1) % senate.Length;
        }

        // Return Winner
        return dCount == 0 ? "Radiant" : "Dire";
    }
}