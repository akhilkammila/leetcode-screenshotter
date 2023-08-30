class Solution {
public:
    bool validWordSquare(vector<string>& words) {
        int cols = 0;
        int rows = words.size();
        vector<string> newWords;
        
        for (auto& word : words) {
            cols = max(cols, (int)word.size());
        }

        // If the first row doesn't have maximum number of characters, or
        // the number of rows is not equal to columns it can't form a square.
        if (cols != words[0].size() || rows != cols) {
            return false;
        }

        for (int col = 0; col < cols; ++col) {
            string newWord;
            // Iterate on each character of column 'col'.
            for (int row = 0; row < rows; ++row) {
                // If the current row's word's size is less than the column number it means this column is empty,
                // or, if there is a character present then use it to make the new word.
                if (col < words[row].size()) {
                    newWord += words[row][col];
                }
            }
            // Push the new word of column 'col' in the list.
            newWords.push_back(newWord);
        }

        // Check if all row's words match with the respective column's words.
        return words == newWords;
    }
};