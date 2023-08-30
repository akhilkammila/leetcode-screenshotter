class Solution {
public:
    unordered_set<string> visited;
    unordered_map<string, vector<string>> adjacent;
    
    void DFS(vector<string>& mergedAccount, string& email) {
        visited.insert(email);
        // Add the email vector that contains the current component's emails
        mergedAccount.push_back(email);
        
        for (string& neighbor : adjacent[email]) {
            if (visited.find(neighbor) == visited.end()) {
                DFS(mergedAccount, neighbor);
            }
        }
    }
    
    vector<vector<string>> accountsMerge(vector<vector<string>>& accountList) {
        int accountListSize = accountList.size();
        
         for (vector<string>& account : accountList) {
            int accountSize = account.size();
            
            // Building adjacency list
            // Adding edge between first email to all other emails in the account
            string accountFirstEmail = account[1];
            for (int j = 2; j < accountSize; j++) {
                string email = account[j];
                adjacent[accountFirstEmail].push_back(email);
                adjacent[email].push_back(accountFirstEmail);
            }
        }
        
        // Traverse over all th accounts to store components
        vector<vector<string>> mergedAccounts;
        for (vector<string>& account : accountList) {
            string accountName = account[0];
            string accountFirstEmail = account[1];
            
            // If email is visited, then it's a part of different component
            // Hence perform DFS only if email is not visited yet
            if (visited.find(accountFirstEmail) == visited.end()) {
                vector<string> mergedAccount;
                // Adding account name at the 0th index
                mergedAccount.push_back(accountName);
                DFS(mergedAccount, accountFirstEmail);
                // Skip the first element (name)
                // Name should be the first element, we only need to sort the emails
                sort(mergedAccount.begin() + 1, mergedAccount.end());
                mergedAccounts.push_back(mergedAccount);
            }
        }
        
        return mergedAccounts;
    }
};