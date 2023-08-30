class Solution {
public:
    vector<string> crawl(string startUrl, HtmlParser htmlParser) {
        function<string(string)> getHostname = [](string url) -> string {
            // find the next slash in the url after "http://"
            // that is after the 7-th position inclusively
            // if there is no such slash, pos will be equal to url.size()
            int pos = min(url.size(), url.find('/', 7));
            // return the substring that starts after "http://" and ends
            // before the next slash of at the end of the string
            return url.substr(7, pos - 7);
        };

        string startHostname = getHostname(startUrl);
        unordered_set<string> visited;

        function<void(string)> dfs = [&](string url) -> void {
            visited.insert(url);
            for (string nextUrl : htmlParser.getUrls(url)) {
                if (getHostname(nextUrl) == startHostname && !visited.count(nextUrl)) {
                    dfs(nextUrl);
                }
            }
        };

        dfs(startUrl);
        return vector<string>(visited.begin(), visited.end());
    }
};