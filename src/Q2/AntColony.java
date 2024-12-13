package Q2;

import java.io.*;
import java.util.*;

// THIS IS MADE FROM CHATGPT AND IS NOT THE ACTUAL ANSWER
public class AntColony {

    // Directions array representing 8 possible moves (up, down, left, right, and diagonals)
    private static final int[] ROWS = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static final int[] COLS = {0, 0, -1, 1, -1, 1, -1, 1};

    // Method to read the grid from a file
    public static char[][] readMapFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<String> lines = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        int rows = lines.size();
        int cols = lines.get(0).length();
        char[][] grid = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            grid[i] = lines.get(i).toCharArray();
        }

        reader.close();
        return grid;
    }

    // Method to find the entrance in the grid
    public static int[] findEntrance(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '>') {
                    return new int[] {i, j}; // Return the coordinates of the entrance
                }
            }
        }
        return null; // Entrance should always exist according to the problem
    }

    // BFS to find the minimum number of spiders to reach food
    public static int bfs(char[][] grid, int[] entrance) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Create a queue for BFS, store [row, col, spider count]
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        queue.add(new int[] {entrance[0], entrance[1], 0});
        visited[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int spiderCount = current[2];

            // If we reach the food, return the spider count
            if (grid[r][c] == 'f') {
                return spiderCount;
            }

            // Explore the 8 possible directions
            for (int i = 0; i < 8; i++) {
                int newR = r + ROWS[i];
                int newC = c + COLS[i];

                // Check if the new position is within bounds and not visited
                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && !visited[newR][newC]) {
                    // Mark the new cell as visited
                    visited[newR][newC] = true;

                    // If it's a spider, increment the spider count
                    int newSpiderCount = spiderCount + (grid[newR][newC] == 's' ? 1 : 0);

                    // Add the new position to the queue
                    queue.add(new int[] {newR, newC, newSpiderCount});
                }
            }
        }

        return -1; // If food is unreachable, return -1 (though we assume food is reachable)
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Prompt user for the file name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        try {
            // Read the map from the file
            char[][] grid = readMapFromFile(fileName);

            // Find the entrance
            int[] entrance = findEntrance(grid);

            if (entrance != null) {
                // Call BFS to find the minimum number of spiders to reach the food
                int result = bfs(grid, entrance);

                // Output the result
                System.out.println("The minimum number of spiders to reach food is: " + result);
            } else {
                System.out.println("Entrance not found!");
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        scanner.close();
    }
}
/*
C:\Users\chan.t3\IdeaProjects\Advanced-Computer-Science-AB\Langdat\9a.txt
 */