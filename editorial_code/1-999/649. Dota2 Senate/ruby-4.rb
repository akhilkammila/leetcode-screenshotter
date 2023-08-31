# @param {String} senate
# @return {String}
def predict_party_victory(senate)
    
    # Number of Senators of each party
    r_count = 0
    d_count = 0

    # Floating Ban Count
    d_floating_ban = 0
    r_floating_ban = 0

    # Queue of Senators
    q = []
    senate.each_char do |c|
        q.push(c)
        if c == 'R'
            r_count += 1
        else
            d_count += 1
        end
    end

    # While any party has eligible Senators
    while r_count > 0 && d_count > 0

        # Pop the senator with turn
        curr = q.shift

        # If eligible, float the ban on the other party, enqueue again.
        # If not, decrement the floating ban and count of the party.
        if curr == 'D'
            if d_floating_ban > 0
                d_floating_ban -= 1
                d_count -= 1
            else
                r_floating_ban += 1
                q.push('D')
            end
        else
            if r_floating_ban > 0
                r_floating_ban -= 1
                r_count -= 1
            else
                d_floating_ban += 1
                q.push('R')
            end
        end
    end

    # Return the party with eligible Senators
    return r_count > 0 ? "Radiant" : "Dire"
end