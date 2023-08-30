public class Solution {
    public int shoppingOffers(List < Integer > price, List < List < Integer >> special, List < Integer > needs) {
        return shopping(price, special, needs);
    }
    public int shopping(List < Integer > price, List < List < Integer >> special, List < Integer > needs) {
        int j = 0, res = dot(needs, price);
        for (List < Integer > s: special) {
            ArrayList < Integer > clone = new ArrayList < > (needs);
            for (j = 0; j < needs.size(); j++) {
                int diff = clone.get(j) - s.get(j);
                if (diff < 0)
                    break;
                clone.set(j, diff);
            }
            if (j == needs.size())
                res = Math.min(res, s.get(j) + shopping(price, special, clone));
        }
        return res;
    }
    public int dot(List < Integer > a, List < Integer > b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }

}