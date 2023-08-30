class Solution:
    def crawl(self, startUrl: str, htmlParser: 'HtmlParser') -> List[str]:
        def get_hostname(url):
            # split url by slashes
            # for instance, "http://example.org/foo/bar" will be split into
            # "http:", "", "example.org", "foo", "bar"
            # the hostname is the 2-nd (0-indexed) element
            return url.split('/')[2]

        start_hostname = get_hostname(startUrl)
        q = collections.deque([startUrl])
        visited = set([startUrl])
        while q:
            url = q.popleft()
            for next_url in htmlParser.getUrls(url):
                if get_hostname(next_url) == start_hostname and next_url not in visited:
                    q.append(next_url)
                    visited.add(next_url)
        return visited