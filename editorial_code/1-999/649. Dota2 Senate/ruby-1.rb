# @param {String} senate
# @return {String}

def predict_party_victory(senate)
    
    # Count of Each Type of Senator to check for Winner
    r_count = senate.count('R')
    d_count = senate.length - r_count

    # To mark Banned Senators
    banned = Array.new(senate.length, false)

    # Ban the candidate "toBan", immediate next to "startAt"
    ban = -> (to_ban, start_at) do
        # Find the next eligible senator of "toBan" type
        # On found, mark him as banned
        while true
            if senate[start_at] == to_ban && !banned[start_at]
                banned[start_at] = true
                break
            end
            start_at = (start_at + 1) % senate.length
        end
    end

    # Turn of Senator at this Index
    turn = 0

    # While both parties have at least one senator
    while r_count > 0 && d_count > 0

        if !banned[turn]
            if senate[turn] == 'R'
                ban.call('D', (turn + 1) % senate.length)
                d_count -= 1
            else
                ban.call('R', (turn + 1) % senate.length)
                r_count -= 1
            end
        end

        turn = (turn + 1) % senate.length
    end

    # Return Winner depending on the count of each party
    d_count == 0 ? "Radiant" : "Dire"
end