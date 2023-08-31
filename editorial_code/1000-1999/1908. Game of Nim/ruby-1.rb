
def nim_game(piles)
    nim_sum = 0
    piles.each do |p|
        nim_sum ^= p
    end
    return nim_sum != 0
end