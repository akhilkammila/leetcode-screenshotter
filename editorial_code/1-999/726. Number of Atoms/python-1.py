class Solution(object):
    def countOfAtoms(self, formula):
        N = len(formula)
        stack = [collections.Counter()]
        i = 0
        while i < N:
            if formula[i] == '(':
                stack.append(collections.Counter())
                i += 1
            elif formula[i] == ')':
                top = stack.pop()
                i += 1
                i_start = i
                while i < N and formula[i].isdigit(): i += 1
                multiplicity = int(formula[i_start: i] or 1)
                for name, v in top.items():
                    stack[-1][name] += v * multiplicity
            else:
                i_start = i
                i += 1
                while i < N and formula[i].islower(): i += 1
                name = formula[i_start: i]
                i_start = i
                while i < N and formula[i].isdigit(): i += 1
                multiplicity = int(formula[i_start: i] or 1)
                stack[-1][name] += multiplicity

        return "".join(name + (str(stack[-1][name]) if stack[-1][name] > 1 else '')
                       for name in sorted(stack[-1]))