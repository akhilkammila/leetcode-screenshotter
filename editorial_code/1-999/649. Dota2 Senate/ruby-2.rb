# @param {String} senate
# @return {String}
def predict_party_victory(senate)

    # Number of Senators
    n = senate.size

    # To mark Banned Senators
    banned = Array.new(n, false)

    # List of indices of Eligible Radiant and Dire Senators
    rIndices = []
    dIndices = []
    for i in 0...n
        if senate[i] == 'R'
            rIndices.push(i)
        else
            dIndices.push(i)
        end
    end

    # Ban the senator of "indices" immediate next to "startAt"
    ban = lambda do |indices, startAt|
        # Find the index of "index of senator to ban" using Binary Search
        temp = indices.bsearch_index { |x| x >= startAt }

        # If startAt is more than the last index,
        # then start from the beginning. Ban the first senator
        if temp.nil?
            banned[indices[0]] = true
            indices.shift
        # Else, Ban the senator at the index
        else
            banned[indices[temp]] = true
            indices.delete_at(temp)
        end
    end

    # Turn of Senator at this Index
    turn = 0

    # While both parties have at least one senator
    while !rIndices.empty? && !dIndices.empty?
        if !banned[turn]
            if senate[turn] == 'R'
                ban.call(dIndices, turn)
            else
                ban.call(rIndices, turn)
            end
        end

        turn = (turn + 1) % n
    end

    # Return the party with at least one senator
    return dIndices.empty? ? "Radiant" : "Dire"
end