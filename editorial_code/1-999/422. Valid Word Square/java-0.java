class Solution {
    public boolean validWordSquare(List<String> words) {
        int cols = 0;
        int rows = words.size();
        List<String> newWords = new ArrayList<String>();
        
        for (String word : words) {
            cols = Math.max(cols, word.length());
        }

        // If the first row doesn't have maximum number of characters, or
        // the number of rows is not equal to columns it can't form a square.
        if (cols != words.get(0).length() ||rows != cols) {
            return false;
        }

        for (int col = 0; col < cols; ++col) {
            StringBuilder newWord = new StringBuilder();
            // Iterate on each character of column 'col'.
            for (int row = 0; row < rows; ++row) {
                // If the current row's word's size is less than the column number it means this column is empty,
                // or, if there is a character present then use it to make the new word.
                if (col < words.get(row).length()) {
                    newWord.append(words.get(row).charAt(col));
                }
            }
            // Push the new word of column 'col' in the list.
            newWords.add(newWord.toString());
        }

        // Check if all row's words match with the respective column's words.
        for (int index = 0; index < rows; ++index) {
            if (words.get(index).compareTo(newWords.get(index)) != 0) {
                return false;
            }
        }
        return true;
    }
}