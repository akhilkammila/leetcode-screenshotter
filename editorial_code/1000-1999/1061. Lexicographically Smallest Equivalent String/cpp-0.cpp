class Solution {
public:
    void DFS(int src, array<array<int, 26>, 26>& adjMatrix, array<int, 26>& visited, vector<int>& component, int& minChar) {
        // Mark the character as visited.
        visited[src] = 1;
        // Add it to the list.
        component.push_back(src);
        // Update the minimum character in the component.
        minChar = min(minChar, src);
        
        for (int i = 0; i < 26; i++) {
            // Perform DFS, if the edge exists and the node isn't visited yet.
            if (adjMatrix[src][i] && !visited[i]) {
                DFS(i, adjMatrix, visited, component, minChar);
            }
        }
    }
    
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        // Adjacency matrix to store edges.
        array<array<int, 26>, 26> adjMatrix = {0};
        for (int i = 0; i < s1.size(); i++) {
            adjMatrix[s1[i] - 'a'][s2[i] - 'a'] = 1;
            adjMatrix[s2[i] - 'a'][s1[i] - 'a'] = 1;
        }
        
        // Array to store the final character mappings.
        array<int, 26> mappingChar = {0};
        for (int i = 0; i < 26; i++) {
            mappingChar[i] = i;
        }
        
        // Array to keep visited nodes during DFS.
        array<int, 26> visited = {0};
        for (int c = 0; c < 26; c++) {
            if (!visited[c]) {
                // Store the characters in the current component.
                vector<int> component;
                // Variable to store the minimum character in the component.
                int minChar = 27;

                DFS(c, adjMatrix, visited, component, minChar);
 
                // Map the characters in the component to the minimum character.
                for (int vertex : component) {
                    mappingChar[vertex] = minChar;
                }
            }
        }
        
        string ans;
        // Create the answer string.
        for (char c : baseStr) {
            ans += (char)(mappingChar[c - 'a'] + 'a');
        }
        
        return ans;
    }
};