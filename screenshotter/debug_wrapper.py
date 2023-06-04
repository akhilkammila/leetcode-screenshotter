import time
import traceback

class DebugWrapper:
    def __init__(self, wrapped_class):
        self.wrapped = wrapped_class
        self.counter = 0

    # Instead of getting the actual method, we wrap the method with our own
    def __getattr__(self, attr):
        original_method = getattr(self.wrapped, attr)

        if callable(original_method):
            wrap1 = self.time_screenshot_wrap(original_method)
            wrap2 = self.debug_error_wrap(wrap1)
            wrap3 = self.retry_wrap(wrap2)
            return wrap3
        
        return original_method
    
    # We don't want to wrap screenshot and save_html
    def screenshot(self, filename):
        self.wrapped.screenshot(filename)
    def save_html(self, filename):
        self.wrapped.save_html(filename)
    
    # Wrappers
    def time_screenshot_wrap(self, method):
        def wrapper(*args, **kwards):
            # Run and print time elapsed
            print("Running method: {}".format(method.__name__), flush=True)
            start = time.time()
            result = method(*args, **kwards)
            end = time.time()
            print("Method complete. Time elapsed: {}".format(end - start) + "\n", flush=True)

            # Take screenshot
            self.screenshot("{}_{}.png".format(str(self.counter).zfill(3), method.__name__))
            self.counter+=1
            return result
        return wrapper
    
    def debug_error_wrap(self, method):
        def wrapper(*args, **kwards):
            try:
                return method(*args, **kwards)
            except Exception as e:
                print("Errored on method: {}".format(method.__name__), flush=True)
                print(e, flush=True)
                self.save_html("{}_html.html".format(str(self.counter).zfill(3)))
                self.screenshot("{}_error.png".format(str(self.counter).zfill(3)))
                self.counter += 1
                raise
        return wrapper
    
    def retry_wrap(self, method):
        def wrapper(*args, **kwards):
            try:
                return method(*args, **kwards)
            except Exception as e:
                time.sleep(2)
                return method(*args, **kwards)
        
        return wrapper