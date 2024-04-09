class Solution:

    image = [[1,1,1],
        [1,1,0],
        [1,0,1]]
    sr = 1
    sc = 1
    color = 2

    def fill(self, image, sr, sc, color, current):
        # Check if starting pixel is out of bound where sr or sc is less than 0 or larger than image length/width
        if (sr < 0 or sr >= len(image) or sc < 0 or sc >= len(image[0])):
            return
    
        # Check if current pixel is the same as the starting pixel color
        if (current != image[sr][sc]):
            return
    
        # If it is the same so we fill the starting pixel
        image[sr][sc] = color

        # We recursively call 4 directions (up down left right)
        self.fill(image, sr, sc+1, color, current)
        self.fill(image, sr, sc-1, color, current)
        self.fill(image, sr-1, sc, color, current)
        self.fill(image, sr+1, sc, color, current)

    def floodFill(self, image, sr, sc, color):
        # If the starting pixel is already the target color we return;
        if (image[sr][sc] == color): return image

        # dfe flood fill
        self.fill(image, sr, sc, color, image[sr][sc])
        return image


test = Solution()
test.floodFill(test.image, test.sr, test.sc, test.color)
print(test.image)


