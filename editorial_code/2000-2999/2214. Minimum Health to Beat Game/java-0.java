class Solution {
    public long minimumHealth(int[] damage, int armor) {
        int maxDamage = 0;
        long totalDamage = 0;

        for (int d : damage) {
            totalDamage += d;
            maxDamage = Math.max(maxDamage, d);
        }

        return totalDamage - Math.min(armor, maxDamage) + 1;
    }
}