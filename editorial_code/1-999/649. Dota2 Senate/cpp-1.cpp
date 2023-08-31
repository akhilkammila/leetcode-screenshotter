class Solution {
public:
  string predictPartyVictory(string senate) {

    // Count of Each Type of Senator to check for Winner
    int rCount = count(senate.begin(), senate.end(), 'R');
    int dCount = senate.size() - rCount;

    // To mark Banned Senators
    vector<bool> banned(senate.size(), false);

    // Ban the candidate "toBan", immediate next to "startAt"
    auto ban = [&](char toBan, int startAt) {
      // Find the next eligible senator of "toBan" type
      // On found, mark him as banned
      while (true) {
        if (senate[startAt] == toBan && !banned[startAt]) {
          banned[startAt] = true;
          break;
        }
        startAt = (startAt + 1) % senate.size();
      }
    };

    // Turn of Senator at this Index
    int turn = 0;

    // While both parties have at least one senator
    while (rCount > 0 && dCount > 0) {

      if (!banned[turn]) {
        if (senate[turn] == 'R') {
          ban('D', (turn + 1) % senate.size());
          dCount--;
        } else {
          ban('R', (turn + 1) % senate.size());
          rCount--;
        }
      }

      turn = (turn + 1) % senate.size();
    }

    return dCount == 0 ? "Radiant" : "Dire";
  }
};