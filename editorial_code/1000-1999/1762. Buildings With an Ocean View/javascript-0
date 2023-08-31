let findBuildings = function(heights) {
    let n = heights.length;
    let answer = [];

    for (let current = 0; current < n; ++current) {
        // If the current building is taller, 
        // it will block the shorter building's ocean view to its left.
        // So we pop all the shorter buildings that have been added before.
        while (answer.length && heights[answer[answer.length - 1]] <= heights[current]) {
            answer.pop();
        }
        answer.push(current);
    }

    return answer;
};