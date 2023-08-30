class Solution {
    int minChar;

    void DFS(int src, Integer[][] adjMatrix, Integer visited[], List<Integer> component) {
        // Mark the character as visited.
        visited[src] = 1;
        // Add it to the list.
        component.add(src);
        // Update the minimum character in the component.
        minChar = Math.min(minChar, src);

        for (int i = 0; i < 26; i++) {
            // Perform DFS if the edge exists and the node isn't visited yet.
            if (adjMatrix[src][i] != null && visited[i] == null) {
                DFS(i, adjMatrix, visited, component);
            }
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Adjacency matrix to store edges.
        Integer adjMatrix[][] = new Integer[26][26];
        for (int i = 0; i < s1.length(); i++) {
            adjMatrix[s1.charAt(i) - 'a'][s2.charAt(i) - 'a'] = 1;
            adjMatrix[s2.charAt(i) - 'a'][s1.charAt(i) - 'a'] = 1;
        }

        // Array to store the final character mappings.
        int mappingChar[] = new int[26];
        for (int i = 0; i < 26; i++) {
            mappingChar[i] = i;
        }

        // Array to keep visited nodes during DFS.
        Integer visited[] = new Integer[26];
        for (int c = 0; c < 26; c++) {
            if (visited[c] == null) {
                // Store the characters in the current component.
                List<Integer> component = new ArrayList<>();
                // Variable to store the minimum character in the component.
                minChar = 27;

                DFS(c, adjMatrix, visited, component);

                // Map the characters in the component to the minimum character.
                for (int vertex : component) {
                    mappingChar[vertex] = minChar;
                }
            }
        }

        String ans = "";
        // Create the answer string.
        for (char c : baseStr.toCharArray()) {
            ans += (char)(mappingChar[c - 'a'] + 'a');
        }

        return ans;
    }
}