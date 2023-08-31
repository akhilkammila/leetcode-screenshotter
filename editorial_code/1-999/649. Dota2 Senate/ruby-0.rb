# @param {String} senate
# @return {String}
def predict_party_victory(senate)
    
    # Count of Each Type of Senator to check for Winner
    r_count = 0
    d_count = 0
    senate.each_char do |c|
        if c == 'R'
            r_count += 1
        else
            d_count += 1
        end
    end

    # Ban the candidate "toBan", immediate next to "startAt"
    # If have to loop around, then it means next turn will be of
    # senator at same index. Returns loop around boolean
    def ban(to_ban, start_at, senate)
        loop_around = false
        pointer = start_at

        while true
            if pointer == 0
                loop_around = true
            end
            if senate[pointer] == to_ban
                senate.slice!(pointer)
                break
            end
            pointer = (pointer + 1) % senate.length
        end

        return loop_around
    end

    # Turn of Senator at this index
    turn = 0

    # While No Winner
    while r_count > 0 && d_count > 0

        # Ban the next opponent, starting at one index ahead
        # Taking MOD to loop around.
        # If index of banned senator is before current index,
        # then we need to decrement turn by 1, as we have removed
        # a senator from list
        if senate[turn] == 'R'
            banned_senator_before = ban('D', (turn + 1) % senate.length, senate)
            d_count -= 1
            if banned_senator_before
                turn -= 1
            end
        else
            banned_senator_before = ban('R', (turn + 1) % senate.length, senate)
            r_count -= 1
            if banned_senator_before
                turn -= 1
            end
        end

        # Increment turn by 1
        turn = (turn + 1) % senate.length
    end

    # Return Winner depending on count
    return d_count == 0 ? "Radiant" : "Dire"
end