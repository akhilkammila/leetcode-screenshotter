class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        
        int a = x == 1 ? bound : (int) (Math.log(bound) / Math.log(x));
        int b = y == 1 ? bound : (int) (Math.log(bound) / Math.log(y));
        
        HashSet<Integer> powerfulIntegers = new HashSet<Integer>();
        
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                
                int value = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                
                if (value <= bound) {
                    powerfulIntegers.add(value);
                }
                
                // No point in considering other powers of "1".
                if (y == 1) {
                    break;
                }
            }
            
            if (x == 1) {
                break;
            }
        }
        
        return new ArrayList<Integer>(powerfulIntegers);
    }
}