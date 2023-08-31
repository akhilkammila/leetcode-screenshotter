function predictPartyVictory(senate: string): string {
    
    // Number of Senator
    const n = senate.length;

    // Queues with Senator's Index.
    // Index will be used to find the next turn of Senator
    const rQueue: number[] = [];
    const dQueue: number[] = [];

    // Populate the Queues
    for (let i = 0; i < n; i++) {
        if (senate[i] === 'R') {
            rQueue.push(i);
        } else {
            dQueue.push(i);
        }
    }

    // While both parties have at least one Senator
    while (rQueue.length > 0 && dQueue.length > 0) {
        
        // Pop the Next-Turn Senate from both Q.
        const rTurn = rQueue.shift()!;
        const dTurn = dQueue.shift()!;

        // ONE having a larger index will be banned by a lower index
        // Lower index will again get Turn, so EN-Queue again
        // But ensure its turn comes in the next round only
        if (dTurn < rTurn) {
            dQueue.push(dTurn + n);
        } else {
            rQueue.push(rTurn + n);
        }
    }

    // One's which Empty is not winner
    if (rQueue.length === 0) {
        return "Dire";
    } else {
        return "Radiant";
    }
};