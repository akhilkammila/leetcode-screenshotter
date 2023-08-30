class RecentCounter:

    def __init__(self):
        self.slide_window = deque()

    def ping(self, t: int) -> int:
        # step 1). append the current call
        self.slide_window.append(t)

        # step 2). invalidate the outdated pings
        while self.slide_window[0] < t - 3000:
            self.slide_window.popleft()

        return len(self.slide_window)