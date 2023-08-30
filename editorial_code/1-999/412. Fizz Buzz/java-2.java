class Solution {
    public List<String> fizzBuzz(int n) {

        // ans list
        List<String> ans = new ArrayList<String>();

        // Hash map to store all fizzbuzz mappings.
        HashMap<Integer, String> fizzBuzzDict =
                new HashMap<Integer, String>() {
                    {
                        put(3, "Fizz");
                        put(5, "Buzz");
                    }
                };
            
        // List of divisors which we will iterate over.
        List<Integer> divisors = new ArrayList<>(Arrays.asList(3, 5));

        for (int num = 1; num <= n; num++) {

            String numAnsStr = "";

            for (Integer key : divisors) {

                // If the num is divisible by key,
                // then add the corresponding string mapping to current numAnsStr
                if (num % key == 0) {
                    numAnsStr += fizzBuzzDict.get(key);
                }
            }

            if (numAnsStr.equals("")) {
                // Not divisible by 3 or 5, add the number
                numAnsStr += Integer.toString(num);
            }

            // Append the current answer str to the ans list
            ans.add(numAnsStr);
        }

        return ans;
    }
}