import collections
from typing import List, Optional

class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):

        self.val = val

        self.left = left

        self.right = right

class Solution():
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # Our final result list
        result = []
        # Python's deque new knowledge obtained
        """ 
        Deque is preferred over a list in the cases where 
        we need quicker append and pop operations from 
        both the ends of the container, as deque provides an O(1) time complexity for 
        append and pop operations as compared to a list that provides O(n) time complexity.
        """
        q = collections.deque()
        # First level only has root
        q.append(root)
        # while queue is not empty
        while q:
            qLength = len(q)
            levelList = []
            for i in range(qLength):
                node = q.popleft();
                # check if node is null
                if node:
                    # add level node to our levelList and traverse left and right
                    levelList.append(node.val)
                    q.append(node.left)
                    q.append(node.right)
                # check if levelList is empty
                if levelList:
                    result.append(levelList)
                
        # Done and return
        return result
        
          