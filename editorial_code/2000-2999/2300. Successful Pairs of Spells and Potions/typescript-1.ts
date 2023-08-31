function successfulPairs(spells: number[], potions: number[], success: number): number[] {
    const sortedSpells: [number, number][] = spells.map((spell, i) => [spell, i]);

    // Sort the 'spells with index' and 'potions' array in increasing order.
    sortedSpells.sort((a, b) => a[0] - b[0]);
    potions.sort((a, b) => a - b);

    const answer: number[] = new Array(spells.length);
    let m = potions.length;
    let potionIndex = m - 1;

    // For each 'spell' find the respective 'minPotion' index.
    for (const [spell, index] of sortedSpells) {
        while (potionIndex >= 0 && spell * potions[potionIndex] >= success) {
            potionIndex -= 1;
        }
        answer[index] = m - (potionIndex + 1);
    }

    return answer;
};