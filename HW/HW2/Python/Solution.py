class Solution(object):
    def firstBadVersion(self, n):
        def binarySearchSolution(left, right):
            while left < right:
                mid = (left + right)//2
                if not isBadVersion(mid):
                    left = mid + 1
                else:
                    right = mid
            return left
        return binarySearchSolution(1,n)