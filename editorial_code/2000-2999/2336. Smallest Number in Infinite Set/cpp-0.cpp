class SmallestInfiniteSet {
    unordered_set<int> isPresent;
    priority_queue<int, vector<int>, greater<int>> addedIntegers;
    int currentInteger;

public:
    SmallestInfiniteSet() {
        // The positive integer set's first element will be 1.
        currentInteger = 1;
    }

    int popSmallest() {
        int answer;
        // If there are numbers in the min-heap, 
        // top element is lowest among all the available numbers.
        if (!addedIntegers.empty()) {
            answer = addedIntegers.top();
            isPresent.erase(answer);
            addedIntegers.pop();
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
            isPresent.find(num) != isPresent.end()) {
            return;
        }
        // We push 'num' in the min-heap if it isn't already present.
        addedIntegers.push(num);
        isPresent.insert(num);
    }
};