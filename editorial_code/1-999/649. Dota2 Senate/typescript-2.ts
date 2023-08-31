function predictPartyVictory(senate: string): string {

    // Number of Senators
    const n = senate.length;

    // To mark Banned Senators
    const banned = new Array(n).fill(false);

    // List of indices of Eligible Radiant and Dire Senators
    const rIndices: number[] = [];
    const dIndices: number[] = [];
    for (let i = 0; i < n; i++) {
        if (senate[i] === 'R') {
            rIndices.push(i);
        } else {
            dIndices.push(i);
        }
    }

    // Ban the senator of "indices" immediate next to "startAt"
    function ban(indices: number[], startAt: number) {
        // Find the index of "index of senator to ban" using Binary Search
        const temp = indices.findIndex((x) => x >= startAt);

        // If startAt is more than the last index,
        // then start from the beginning. Ban the first senator
        if (temp === -1) {
            banned[indices[0]] = true;
            indices.shift();
        }

        // Else, Ban the senator at the index
        else {
            banned[indices[temp]] = true;
            indices.splice(temp, 1);
        }
    }

    // Turn of Senator at this Index
    let turn = 0;

    // While both parties have at least one senator
    while (rIndices.length > 0 && dIndices.length > 0) {
        if (!banned[turn]) {
            if (senate[turn] === 'R') {
                ban(dIndices, turn);
            } else {
                ban(rIndices, turn);
            }
        }

        turn = (turn + 1) % n;
    }

    // Return the party with at least one senator
    if (dIndices.length === 0) {
        return "Radiant";
    } else {
        return "Dire";
    }
}