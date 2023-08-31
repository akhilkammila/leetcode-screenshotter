class SmallestInfiniteSet {
    set<int> addedIntegers;
    int currentInteger;
public:
    SmallestInfiniteSet() {
        // The positive integer set's first element will be 1.
        currentInteger = 1;
    }
    int popSmallest() {
        int answer;
        // If there are numbers in the sorted-set, 
        // first element is lowest among all the available numbers.
        if (!addedIntegers.empty()) {
            answer = *addedIntegers.begin();
            addedIntegers.erase(addedIntegers.begin());
        } 
        // Otherwise, the smallest number of large positive set 
        // denoted by 'currentInteger' is the answer.
        else {
            answer = currentInteger;
            currentInteger += 1;
        }
        return answer;
    }
    void addBack(int num) {
        if (currentInteger <= num || 
            addedIntegers.find(num) != addedIntegers.end()) {
            return;
        }
        // We push 'num' in the sorted-set if it isn't already present.
        addedIntegers.insert(num);
    }
};