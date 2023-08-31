class Solution {
public:
  string predictPartyVictory(string senate) {

    // Number of Senators
    int n = senate.size();

    // To mark Banned Senators
    vector<bool> banned(n, false);

    // List of indices of Eligible Radiant and Dire Senators
    vector<int> rIndices, dIndices;
    for (int i = 0; i < n; i++) {
      if (senate[i] == 'R')
        rIndices.push_back(i);
      else
        dIndices.push_back(i);
    }

    // Ban the senator of "indices" array next to "startAt"
    auto ban = [&](vector<int> &indices, int start_at) {
      // Find the index of "index of senator to ban" using Binary Search
      auto temp = lower_bound(indices.begin(), indices.end(), start_at);

      // If start_at is more than the last index,
      // then start from the beginning. Ban the first senator
      if (temp == indices.end()) {
        banned[indices[0]] = true;
        indices.erase(indices.begin());
      }

      // Else, Ban the senator at the index
      else {
        banned[*temp] = true;
        indices.erase(temp);
      }
    };

    // Turn of Senator at this Index
    int turn = 0;

    // While both parties have at least one senator
    while (!rIndices.empty() && !dIndices.empty()) {

      if (!banned[turn]) {
        if (senate[turn] == 'R')
          ban(dIndices, turn);
        else
          ban(rIndices, turn);
      }

      turn = (turn + 1) % n;
    }

    // Return the party with at least one senator
    return dIndices.empty() ? "Radiant" : "Dire";
  }
};