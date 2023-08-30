class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:

        # Function to serialize Tree
        def serialize(node, tree_str):
            if node is None:
                tree_str.append('#')
                return

            tree_str.append("^")
            tree_str.append(str(node.val))
            serialize(node.left, tree_str)
            serialize(node.right, tree_str)

        # Knuth-Morris-Pratt algorithm to check if `needle` is in `haystack`
        def kmp(needle, haystack):
            m = len(needle)
            n = len(haystack)

            if n < m:
                return False

            # longest proper prefix which is also suffix
            lps = [0]*m
            # Length of Longest Border for prefix before it.
            prev = 0
            # Iterating from index-1. lps[0] will always be 0
            i = 1

            while i < m:
                if needle[i] == needle[prev]:
                    # Length of Longest Border Increased
                    prev += 1
                    lps[i] = prev
                    i += 1
                else:
                    # Only empty border exist
                    if prev == 0:
                        lps[i] = 0
                        i += 1
                    # Try finding longest border for this i with reduced prev
                    else:
                        prev = lps[prev-1]

            # Pointer for haystack
            haystack_pointer = 0
            # Pointer for needle.
            # Also indicates number of characters matched in current window.
            needle_pointer = 0

            while haystack_pointer < n:
                if haystack[haystack_pointer] == needle[needle_pointer]:
                    # Matched Increment Both
                    needle_pointer += 1
                    haystack_pointer += 1
                    # All characters matched
                    if needle_pointer == m:
                        return True
                else:
                    if needle_pointer == 0:
                        # Zero Matched
                        haystack_pointer += 1
                    else:
                        # Optimally shift left needle_pointer. 
                        # Don't change haystack_pointer
                        needle_pointer = lps[needle_pointer-1]
            
            return False

        # Serialize given Nodes
        root_list = []
        serialize(root, root_list)
        r = "".join(root_list)

        subroot_list = []
        serialize(subRoot, subroot_list)
        s = "".join(subroot_list)

        # Check if s is in r
        return kmp(s, r)