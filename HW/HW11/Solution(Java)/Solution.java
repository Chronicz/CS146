class Solution {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // if new color is already in starting pixel return otherwise infinite loop
        if (image[sr][sc] == color)
            return image;
        // dfs floodfill
        fill(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public static void fill(int[][] image, int sr, int sc, int color, int current) {
        // Check if sr and sc is in bound of image, less than 0
        // or larger than length/width of image
        // if out of bound return else fill
        // Provided that this is a square image where length == width
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length)
            return;

        // Check if current pixel has the same color if so we proceed if not we return
        if (current != image[sr][sc])
            return;

        // Fill
        image[sr][sc] = color;

        // We recursively to check the 4 direction (up down left right)
        fill(image, sr, sc + 1, color, current);
        fill(image, sr, sc - 1, color, current);
        fill(image, sr - 1, sc, color, current);
        fill(image, sr + 1, sc, color, current);
    }
}