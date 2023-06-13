package backjoon.algo.fc.graph;

import java.io.*;
import java.util.StringTokenizer;

public class 미로탐색 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static boolean[][] visited;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] adj;
    static int CNT = 0;

    public static void main(String[] args) {

        input();
        pro();
    }

    public static void input(){

        N = sc.nextInt();
        M = sc.nextInt();

        adj = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i = 1; i <= N; i++) {
            char[] arr = sc.nextLine().toCharArray();
            for(int j = 1; j <= M; j++) {
                adj[i][j] = arr[j-1] - '0';
            }
        }

//        System.out.println(Arrays.deepToString(adj));
    }

    public static void pro() {

        bfs(1,1);
        System.out.println(CNT);

    }

    public static void bfs(int x, int y) {

        visited[x][y] = true;
        CNT++;
        System.out.println("x :" + x + ", y: " + y);

        for(int i = 0; i < dir.length; i++) {
            int dx = dir[i][0];
            int dy = dir[i][1];
            int nx = dx + x;
            int ny = dy + y;

            // 범위를 벗어난다면
            if (nx < 1 || ny < 1 || nx > N || ny > M) continue;

            // 방문한 적이 있다면
            if (visited[nx][ny]) continue;

            // 방문할 곳이 0 이라면
            if (adj[nx][ny] == 0) continue;
//            bfs(nx, ny);

            System.out.println("aaa");
            // 오른쪽으로 간다면
            if (dx == 1 && adj[nx][ny] == 1) bfs(nx, ny);
            // 아래로 내려간다면
            else if (dy == 1 && adj[nx][ny] == 1) bfs(nx, ny);
            // 위로만 올라갈 수 있다면
            else if (dy == -1 && adj[nx][ny] == 1) bfs(nx, ny);
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
