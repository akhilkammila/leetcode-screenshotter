class Solution {
    func successfulPairs(_ spells: [Int], _ potions: [Int], _ success: Int) -> [Int] {
        var sortedSpells = [(spell: Int, index: Int)]()
        for (index, spell) in spells.enumerated() {
            sortedSpells.append((spell, index))
        }
        
        // Sort the 'spells with index' and 'potions' array in increasing order.
        sortedSpells.sort { $0.spell < $1.spell }
        let sortedPotions = potions.sorted()

        var answer = Array(repeating: 0, count: spells.count)
        var potionIndex = sortedPotions.count - 1
        
        // For each 'spell' find the respective 'minPotion' index.
        for (spell, index) in sortedSpells {
            while potionIndex >= 0 && spell * sortedPotions[potionIndex] >= success {
                potionIndex -= 1
            }
            answer[index] = sortedPotions.count - (potionIndex + 1)
        }
        
        return answer
    }
}