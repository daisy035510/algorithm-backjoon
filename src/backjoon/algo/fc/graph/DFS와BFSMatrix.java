package backjoon.algo.fc.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFSMatrix {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[][] adj;
    static boolean[] visited;
    static int N, M, S;

    public static void main(String[] args) {

        input();
        pro();
    }

    public static void input(){

        N = sc.nextInt();
        M = sc.nextInt();
        S = sc.nextInt();

        adj = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= M; i++) {

            int j = sc.nextInt();
            int k = sc.nextInt();

            adj[j][k] = 1;
            adj[k][j] = 1;
        }
    }

    public static void pro() {

        // 1. dfs
        dfs(S);
        sb.append("\n");

        for(int i = 0 ; i < visited.length; i++) visited[i] = false;


        // 2. bfs
        bfs(S);
        System.out.println(sb.toString());
    }

    public static void dfs(int s) {

        visited[s] = true;
        sb.append(s).append(" ");

        for(int i = 1; i < adj[s].length; i++) {

            if(adj[s][i] == 0) continue;
            if(visited[i]) continue;

            dfs(i);
        }
    }

    public static void bfs(int s) {

        Queue<Integer> que = new LinkedList<>();
        que.add(s);
        visited[s] = true;

        while(!que.isEmpty()) {

            int n = que.poll();
            sb.append(n).append(" ");

            for(int y = 1; y <= N; y++) {

                if(adj[n][y] == 0) continue;
                if(visited[y]) continue;

                que.add(y);
                visited[y] = true;
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
