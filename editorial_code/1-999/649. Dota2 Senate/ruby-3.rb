# @param {String} senate
# @return {String}
def predict_party_victory(senate)
    
    # Number of Senator
    n = senate.size

    # Queues with Senator's Index.
    # Index will be used to find the next turn of Senator
    rQueue = []
    dQueue = []

    # Populate the Queues
    for i in 0...n
        if senate[i] == 'R'
            rQueue.push(i)
        else
            dQueue.push(i)
        end
    end

    # While both parties have at least one Senator
    while rQueue.size > 0 && dQueue.size > 0
        
        # Pop the Next-Turn Senate from both Q.
        rTurn = rQueue.shift
        dTurn = dQueue.shift

        # ONE having a larger index will be banned by a lower index
        # Lower index will again get Turn, so EN-Queue again
        # But ensure its turn comes in the next round only
        if dTurn < rTurn
            dQueue.push(dTurn + n)
        else
            rQueue.push(rTurn + n)
        end
    end

    # One's which Empty is not winner
    return rQueue.size == 0 ? "Dire" : "Radiant"
end