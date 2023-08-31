class SmallestInfiniteSet {
    private SortedSet<Integer> addedIntegers;
    private Integer currentInteger;
    
    public SmallestInfiniteSet() {
        addedIntegers = new TreeSet<>();
        currentInteger = 1;
    }
    
    public int popSmallest() {
        int answer;
        // If there are numbers in the sorted-set, 
        // top element is lowest among all the available numbers.
        if (!addedIntegers.isEmpty()) {
            answer = addedIntegers.first();
            addedIntegers.remove(answer);
        } 
        // Otherwise, the smallest number of large positive set 
        // denoted by 'currentInteger' is the answer.
        else {
            answer = currentInteger;
            currentInteger += 1;
        }
        return answer;
    }
    
    public void addBack(int num) {
        if (currentInteger <= num || addedIntegers.contains(num)) {
            return;
        }
        // We push 'num' in the sorted-set if it isn't already present.
        addedIntegers.add(num);
    }
}