class Solution {
public:
    long long minimumHealth(vector<int>& damage, int armor) {
        int maxDamage = 0;
        long long totalDamage = 0;

        for (auto& d : damage) {
            totalDamage += d;
            maxDamage = max(maxDamage, d);
        }

        return totalDamage - min(armor, maxDamage) + 1;
    }
};