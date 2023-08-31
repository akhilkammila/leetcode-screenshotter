class Solution {
  public String predictPartyVictory(String senate) {

    // Number of Senators
    int n = senate.length();

    // To mark Banned Senators
    boolean[] banned = new boolean[n];

    // List of indices of Eligible Radiant and Dire Senators
    List<Integer> rIndices = new ArrayList<>();
    List<Integer> dIndices = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (senate.charAt(i) == 'R')
        rIndices.add(i);
      else
        dIndices.add(i);
    }

    // Ban the senator of "indices" array next to "startAt"
    BiConsumer<List<Integer>, Integer> ban = (indices, start_at) -> {
      // Find the index of "index of senator to ban" using Binary Search
      int temp = Collections.binarySearch(indices, start_at);

      // If start_at is more than the last index,
      // then start from the beginning. Ban the first senator
      if (temp < 0) {
        temp = -temp - 1;
        if (temp == indices.size()) {
          banned[indices.get(0)] = true;
          indices.remove(0);
        }

        // Else, Ban the senator at the index
        else {
          banned[indices.get(temp)] = true;
          indices.remove(temp);
        }
      }
    };

    // Turn of Senator at this Index
    int turn = 0;

    // While both parties have at least one senator
    while (!rIndices.isEmpty() && !dIndices.isEmpty()) {

      if (!banned[turn]) {
        if (senate.charAt(turn) == 'R')
          ban.accept(dIndices, turn);
        else
          ban.accept(rIndices, turn);
      }

      turn = (turn + 1) % n;
    }

    return dIndices.isEmpty() ? "Radiant" : "Dire";
  }
}