class TreeNode(object):
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

def is_valid_BST(root):
    def is_valid(node, min_val, max_val):
        #Base Case
        if not node:
            return True
        # If root val is less or equal than min
        # If root val is larger or equal than max
        # Then is not valid BST
        if not (min_val < node.val < max_val):
            return False

        #Recursively call left and right tree
        return (is_valid(node.left, min_val, node.val) and
                is_valid(node.right, node.val, max_val))

    # min and max bound for comparison
    return is_valid(root, float('-inf'), float('inf'))

#Test Case
root = TreeNode(2)
root.left = TreeNode(1)
root.right = TreeNode(3)

print(is_valid_BST(root))