class Solution:
    def powerfulIntegers(self, x: int, y: int, bound: int) -> List[int]:
        
        a = bound if x == 1 else int(log(bound, x))
        b = bound if y == 1 else int(log(bound, y))
        
        powerful_integers = set([])
        
        for i in range(a + 1):
            for j in range(b + 1):
                
                value = x**i + y**j
                
                if value <= bound:
                    powerful_integers.add(value)
                    
                if y == 1:
                    break
            
            if x == 1:
                break
                
        return list(powerful_integers)