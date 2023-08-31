class SmallestInfiniteSet {
    var isPresent: Set<Int>
    var addedIntegers: MinHeapPQ<Int>
    var currentInteger: Int
    
    init() {
        isPresent = Set<Int>()
        addedIntegers = MinHeapPQ<Int>()
        currentInteger = 1
    }
    
    func popSmallest() -> Int {
        // If there are numbers in the min-heap,
        // top element is lowest among all the available numbers.
        var answer: Int
        if !addedIntegers.isEmpty() {
            answer = addedIntegers.popMin()!
            isPresent.remove(answer)
        } 
        // Otherwise, the smallest number of large positive set
        // denoted by 'current_integer' is the answer.
        else {
            answer = currentInteger
            currentInteger += 1
        }
        return answer
    }
    
    func addBack(_ num: Int) {
        if currentInteger <= num || isPresent.contains(num) {
            return
        }
        // We push 'num' in the min-heap if it isn't already present.
        addedIntegers.insert(value: num)
        isPresent.insert(num)
    }
}


// === MIN HEAP PRIORITY QUEUE CLASS === //
class MinHeapPQ<T: Comparable> {
    var heap: [T] = []
    
    // Helper methods to get parent, left and right child indices
    func getParentIndex(_ index: Int) -> Int {
        return (index - 1) / 2
    }
    func getLeftChildIndex(_ index: Int) -> Int {
        return 2 * index + 1
    }
    func getRightChildIndex(_ index: Int) -> Int {
        return 2 * index + 2
    }
    
    // Helper method to swap two elements in the heap
    func swap(_ index1: Int, _ index2: Int) {
        (self.heap[index1], self.heap[index2]) = (self.heap[index2], self.heap[index1])
    }
    
    // Helper method to get the minimum element in the heap
    func peek() -> T? {
        if self.heap.count == 0 {
            return nil
        }
        return self.heap[0]
    }
    
    // Helper method to insert an element into the heap
    func insert(value: T) {
        self.heap.append(value)
        var currentIndex = self.heap.count - 1
        var parentIndex = self.getParentIndex(currentIndex)
        while currentIndex > 0 && self.heap[currentIndex] < self.heap[parentIndex] {
            swap(currentIndex, parentIndex)
            currentIndex = parentIndex
            parentIndex = self.getParentIndex(currentIndex)
        }
    }
    
    // Helper method to remove the minimum element from the heap
    func popMin() -> T? {
        if heap.isEmpty {
            return nil
        }
        let min = heap[0]
        let last = heap.removeLast()
        if !heap.isEmpty {
            heap[0] = last
            var currentIndex = 0
            var leftChildIndex = getLeftChildIndex(currentIndex)
            var rightChildIndex = getRightChildIndex(currentIndex)
            while leftChildIndex < heap.count && 
                  (heap[leftChildIndex] < heap[currentIndex] || 
                   (rightChildIndex < heap.count && heap[rightChildIndex] < heap[currentIndex]
                  )
            ) {
                let smallerChildIndex = rightChildIndex < heap.count && 
                      heap[rightChildIndex] < heap[leftChildIndex] ? rightChildIndex : leftChildIndex

                swap(currentIndex, smallerChildIndex)
                currentIndex = smallerChildIndex
                leftChildIndex = getLeftChildIndex(currentIndex)
                rightChildIndex = getRightChildIndex(currentIndex)
            }
        }
        return min
    }
    
    func size() -> Int {
        return heap.count
    }
    
    func isEmpty() -> Bool {
        return heap.isEmpty
    }
}