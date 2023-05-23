package algo.fc.graph;

import java.io.*;
import java.util.*;

public class AdjacecnyMatrix {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M, V;
    static int[][] adj;
    static boolean[] visit;

    public static void main(String[] args) {
        inuput();
        pro();
    }

    static void inuput() {

        N = scan.nextInt(); // 정점
        M = scan.nextInt(); // 간선의 갯수
        V = scan.nextInt(); // 시작점

        adj = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for(int i = 1; i <= M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            //  adj[x][y] = adj[y][x] = 1;
            adj[x][y] = 1;
            adj[y][x] = 1;

        }
    }

    static void pro() {

        dfs(V);
        sb.append('\n');
        for(int i = 1; i <= N; i++) visit[i] = false;
        bfs(V);
        System.out.println(sb);
    }

    public static void dfs(int x) {

        visit[x] = true;
        sb.append(x).append(' ');

        for(int y = 1; y <= N; y++) {
            if(adj[x][y] == 0) continue;
            if(visit[y]) continue;
            dfs(y);
        }
    }

    public static void bfs(int start) {

        Queue<Integer> que = new LinkedList<>();

        // 방문가능하므로 넣어준다
        que.add(start);
        visit[start] = true;

        while(!que.isEmpty()) {
            int x  = que.poll();
            sb.append(x).append(' ');

            for(int y = 1; y <= N; y++) {
                if(adj[x][y] == 0) continue;
                if(visit[y]) continue;
                que.add(y);
                visit[y] = true;
            }
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
