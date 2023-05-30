package backjoon.algo.fc.graph;

import java.io.*;
import java.util.*;

public class DFS와BFSArrayList {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] adj;
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

        adj = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {

            int j = sc.nextInt();
            int k = sc.nextInt();

            adj[j].add(k);
            adj[k].add(j);
        }

        // 정렬
        for(int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }
    }

    public static void pro() {

        // 1. dfs
        dfs(S);
        sb.append("\n");

        for(int i = 1; i < visited.length; i++) visited[i] = false;

        // 2. bfs
        bfs(S);
        System.out.println(sb.toString());
    }

    public static void dfs(int s) {

        visited[s] = true;
        sb.append(s).append(" ");

        for(int i : adj[s]) {

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
            for(int k : adj[n]) {

                if(visited[k]) continue;

                que.add(k);
                visited[k] = true;
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
