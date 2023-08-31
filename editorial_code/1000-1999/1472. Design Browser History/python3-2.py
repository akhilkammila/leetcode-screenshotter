class BrowserHistory:
    def __init__(self, homepage: str):
        # 'homepage' is the first visited URL.
        self.visited_URLs = [homepage]
        self.curr_URL, self.last_URL = 0, 0

    def visit(self, url: str) -> None:
        self.curr_URL += 1
        if len(self.visited_URLs) > self.curr_URL:
            # We have enough space in our array to overwrite an old 'url' entry with new one.
            self.visited_URLs[self.curr_URL] = url
        else:
            # We have to insert a new 'url' entry at the end.
            self.visited_URLs.append(url)
        # This 'url' will be last URL if we try to go forward.
        self.last_URL = self.curr_URL

    def back(self, steps: int) -> str:
        # Move 'curr_URL' pointer in left direction.
        self.curr_URL = max(0, self.curr_URL - steps)
        return self.visited_URLs[self.curr_URL]

    def forward(self, steps: int) -> str:
        # Move 'curr_URL' pointer in right direction.
        self.curr_URL = min(self.last_URL, self.curr_URL + steps)
        return self.visited_URLs[self.curr_URL]