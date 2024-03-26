class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def invertTree(self, root):
        #Base Case
        if not root:
            return root
        #Traverse left
        self.invertTree(root.left)
        #Traverse Right
        self.invertTree(root.right)
        #Swap
        root.left, root.right = root.right, root.left
        return root
    
def printTree(root):
    if root is not None:
        printTree(root.left)
        print(root.val, end=" ")
        printTree(root.right)

    
root = TreeNode(1)
root.left = TreeNode(2)
root.left.left = TreeNode(3)
root.left.right = TreeNode(4)
root.right = TreeNode(8)
root.right.left = TreeNode(5)
root.right.right = TreeNode(6)

s = Solution()
printTree(root)
s.invertTree(root)
print("\n")
printTree(root)


        