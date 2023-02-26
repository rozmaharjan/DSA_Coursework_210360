//import java.util.Scanner;
//import java.util.Stack;
//
//public class Question8A {
//
//    public static int getMaxSquareArea(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int maxArea = 0;
//        int[] histogram = new int[n];
//
//        // Step 1: Calculate the histogram for each row
//        for (int i = 0; i < m; i++) {
//            // calculate histogram for the current row
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 1) {
//                    histogram[j] = 0;
//                } else {
//                    histogram[j]++;
//                }
//            }
//            // calculate the maximum area of the square for the current row
//            int area = largestSquareArea(histogram);
//            maxArea = Math.max(maxArea, area);
//        }
//
//        return maxArea;
//    }
//
//    // Step 2: Implement the largest square in a histogram algorithm using a stack
//    private static int largestSquareArea(int[] heights) {
//        int n = heights.length;
//        Stack<Integer> stack = new Stack<>();
//        int maxArea = 0;
//        int i = 0;
//        while (i <= n) {
//            int h = (i == n) ? 0 : heights[i];
//            if (stack.isEmpty() || h >= heights[stack.peek()]) {
//                stack.push(i);
//                i++;
//            } else {
//                int height = heights[stack.pop()];
//                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
//                int size = Math.min(height, width);
//                int area = size * size;
//                maxArea = Math.max(maxArea, area);
//            }
//        }
//        return maxArea;
//    }
//
//    public static void main(String[] args) {
//        int[][] matrix = {{1, 0, 1, 0, 0},
//                {0, 1, 1, 1, 1},
//                {0, 0, 0, 0, 1},
//                {0, 0, 0, 1, 1},
//                {0, 1, 0, 1, 1}};
//
//        // Find the maximum area of square made by 0s in the matrix
//        int maxArea = Question8A.getMaxSquareArea(matrix);
//        System.out.println("Maximum area of square made by 0s: " + maxArea);
//    }
//}
class MaxSquareArea {

    public static int getMaxSquareArea(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxArea = 0;

        // initialize first row and first column of dp matrix
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0];
            maxArea = Math.max(maxArea, dp[i][0]);
        }
        for (int j = 0; j < cols; j++) {
            dp[0][j] = matrix[0][j];
            maxArea = Math.max(maxArea, dp[0][j]);
        }

        // fill remaining cells of dp matrix
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxArea = Math.max(maxArea, dp[i][j]);
                }
            }
        }

        return maxArea * maxArea;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 1, 0, 1, 1}};
        int maxSquareArea = getMaxSquareArea(matrix);
        System.out.println("Maximum area of square made by 0s: " + maxSquareArea);
    }
}