let SmallestInfiniteSet = function() {
    this.isPresent = new HashSet();
    this.addedIntegers = new MinHeapPQ();
    this.currentInteger = 1;
};

SmallestInfiniteSet.prototype.popSmallest = function() {
    // If there are numbers in the min-heap, 
    // top element is lowest among all the available numbers.
    if (!this.addedIntegers.isEmpty()) {
        answer = this.addedIntegers.popMin();
        this.isPresent.remove(answer);
    }
    // Otherwise, the smallest number of large positive set 
    // denoted by 'current_integer' is the answer.
    else {
        answer = this.currentInteger;
        this.currentInteger += 1;
    }
    return answer;
};

SmallestInfiniteSet.prototype.addBack = function(num) {
    if (this.currentInteger <= num || this.isPresent.contains(num)) {
        return;
    }
    // We push 'num' in the min-heap if it isn't already present.
    this.addedIntegers.insert(num);
    this.isPresent.add(num);
};


// === MIN HEAP PRIORITY QUEUE CLASS === //
class MinHeapPQ {
    constructor() {
        this.heap = [];
    }

    // Helper methods to get parent, left and right child indices
    getParentIndex(index) {
        return Math.floor((index - 1) / 2);
    }
    getLeftChildIndex(index) {
        return 2 * index + 1;
    }
    getRightChildIndex(index) {
        return 2 * index + 2;
    }
    
    // Helper method to swap two elements in the heap
    swap(index1, index2) {
        [this.heap[index1], this.heap[index2]] = [this.heap[index2], this.heap[index1]];
    }

    // Helper method to get the minimum element in the heap
    peek() {
        if (this.heap.length === 0) {
            throw new Error("Heap is empty");
        }
        return this.heap[0];
    }

    // Helper method to insert an element into the heap
    insert(value) {
        this.heap.push(value);
        let currentIndex = this.heap.length - 1;
        let parentIndex = this.getParentIndex(currentIndex);
        while (currentIndex > 0 && this.heap[currentIndex] < this.heap[parentIndex]) {
            this.swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = this.getParentIndex(currentIndex);
        }
    }

    // Helper method to remove the minimum element from the heap
    popMin() {
        if (this.heap.length === 0) {
            throw new Error("Heap is empty");
        }
        const min = this.heap[0];
        const last = this.heap.pop();
        if (this.heap.length > 0) {
            this.heap[0] = last;
            let currentIndex = 0;
            let leftChildIndex = this.getLeftChildIndex(currentIndex);
            let rightChildIndex = this.getRightChildIndex(currentIndex);
            while (
                (leftChildIndex < this.heap.length && this.heap[leftChildIndex] < this.heap[currentIndex]) || 
                (rightChildIndex < this.heap.length && this.heap[rightChildIndex] < this.heap[currentIndex])
            ) {
                const smallerChildIndex = (rightChildIndex >= this.heap.length || 
                    this.heap[leftChildIndex] < this.heap[rightChildIndex]) ? leftChildIndex : rightChildIndex;

                this.swap(currentIndex, smallerChildIndex);
                currentIndex = smallerChildIndex;
                leftChildIndex = this.getLeftChildIndex(currentIndex);
                rightChildIndex = this.getRightChildIndex(currentIndex);
            }
        }
        return min;
    }

    // Helper method to get the size of the heap
    size() {
        return this.heap.length;
    }
    // Helper method to check if the heap is empty
    isEmpty() {
        return this.heap.length === 0;
    }
}


// === HASH SET CLASS === //
class HashSet {
  constructor() {
    this.hash = {};
    this.size = 0;
  }

  add(value) {
    if (!this.contains(value)) {
      this.hash[value] = true;
      this.size++;
    }
  }

  remove(value) {
    if (this.contains(value)) {
      delete this.hash[value];
      this.size--;
    }
  }

  contains(value) {
    return this.hash.hasOwnProperty(value);
  }

  getSize() {
    return this.size;
  }

  isEmpty() {
    return this.size === 0;
  }

  clear() {
    this.hash = {};
    this.size = 0;
  }
}