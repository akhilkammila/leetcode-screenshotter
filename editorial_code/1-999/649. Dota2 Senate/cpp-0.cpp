class Solution {
public:
  string predictPartyVictory(string senate) {

    // Count of Each Type of Senator to check for Winner
    int rCount = count(senate.begin(), senate.end(), 'R');
    int dCount = senate.size() - rCount;

    // Ban the candidate "toBan", immediate next to "startAt"
    // If have to loop around, then it means next turn will be of
    // senator at same index. Returns loop around boolean
    auto ban = [&](char toBan, int startAt) {
      bool loopAround = false;
      int pointer = startAt;

      while (true) {
        if (pointer == 0) {
          loopAround = true;
        }
        if (senate[pointer] == toBan) {
          senate.erase(senate.begin() + pointer);
          break;
        }
        pointer = (pointer + 1) % senate.size();
      }

      return loopAround;
    };

    // Turn of Senator at this index
    int turn = 0;

    // While No Winner
    while (rCount > 0 && dCount > 0) {

      // Ban the next opponent, starting at one index ahead
      // Taking MOD to loop around.
      // If index of banned senator is before current index,
      // then we need to decrement turn by 1, as we have removed
      // a senator from list
      if (senate[turn] == 'R') {
        bool bannedSenatorBefore = ban('D', (turn + 1) % senate.size());
        dCount--;
        if (bannedSenatorBefore) {
          turn--;
        }
      } else {
        bool bannedSenatorBefore = ban('R', (turn + 1) % senate.size());
        rCount--;
        if (bannedSenatorBefore) {
          turn--;
        }
      }

      // Increment turn by 1
      turn = (turn + 1) % senate.size();
    }

    // Return Winner depending on count
    return dCount == 0 ? "Radiant" : "Dire";
  }
};