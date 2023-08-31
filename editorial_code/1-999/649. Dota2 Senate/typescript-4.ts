function predictPartyVictory(senate: string): string {
    
    // Number of Senators of each party
    let rCount = 0;
    let dCount = 0;

    // Floating Ban Count
    let dFloatingBan = 0;
    let rFloatingBan = 0;

    // Queue of Senators.
    let q = [];
    for (let i = 0; i < senate.length; i++) {
        q.push(senate[i]);
        if (senate[i] == 'R') {
            rCount += 1;
        } else {
            dCount += 1;
        }
    }

    // While any party has eligible Senators
    while (rCount > 0 && dCount > 0) {

        // Pop the senator with turn
        let curr = q.shift();

        // If eligible, float the ban on the other party, enqueue again.
        // If not, decrement the floating ban and count of the party.
        if (curr == 'D') {
            if (dFloatingBan > 0) {
                dFloatingBan -= 1;
                dCount -= 1;
            } else {
                rFloatingBan += 1;
                q.push('D');
            }
        } else {
            if (rFloatingBan > 0) {
                rFloatingBan -= 1;
                rCount -= 1;
            } else {
                dFloatingBan += 1;
                q.push('R');
            }
        }
    }

    // Return the party with eligible Senators
    if (rCount > 0) {
        return "Radiant";
    } else {
        return "Dire";
    }
};