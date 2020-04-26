package amazonsde12020;

import java.util.LinkedList;
import java.util.Queue;

public class InfectPatients2DMat {

    int infectPatients(int[][]mat) {

        Queue<Integer> queue = new LinkedList<>();
        int height = mat.length;
        int width = mat[0].length;
        boolean[][] visited = new boolean[height][width];
        int timer = 0;
        int row = 0;
        int col = 0;

        queue.add(mat[row][col]);

        while(!queue.isEmpty()) {

            if(row >= height || row < 0 || col > width || col < 0 || visited[row][col] == true)
                continue;

            visited[row][col] = true;

            int element = queue.poll();
            if(element == 1){
                mat[row][col-1] = 1;
                queue.add(mat[row][col-1]);

                mat[row][col+1] = 1;
                queue.add(mat[row][col+1]);

                mat[row-1][col] = 1;
                queue.add(mat[row-1][col]);

                mat[row+1][col] = 1;
                queue.add(mat[row+1][col]);
                timer += 1;

            }
        }

        return timer;
    }

    public static void main(String[] args) {

        InfectPatients2DMat infectPatients2DMat = new InfectPatients2DMat();

        int [][] mat = {
                            {1,1,0,0},
                            {0,0,1,1},
                            {1,0,0,0},
                            {0,1,1,0}
                        };

        System.out.println(infectPatients2DMat.infectPatients(mat));
    }
}
