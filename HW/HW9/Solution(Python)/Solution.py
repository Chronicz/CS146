class TreeNode(object):
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        r = root 
        while r:    # While root is not null
            if r.val>p.val and r.val>q.val: # Traverse left if root is larger
                r = r.left
            if r.val<p.val and r.val<q.val:# Traverse right if root is smaller
                r = r.right
            return r #Return when end

root = TreeNode(4)
root.left = TreeNode(3)
root.right = TreeNode(8)
root.left.left = TreeNode(1)
root.right.left = TreeNode(5)
root.right.right = TreeNode(9)

s= Solution()

p = root.left
q = root.left.left
lca = s.lowestCommonAncestor(root,p,q)

print(lca.val)
