package algo.fc.graph;

import java.io.*;
import java.util.*;

public class AdjacecnyList {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M, V;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    public static void main(String[] args) {
        inuput();
        pro();
    }

    static void inuput() {

        N = scan.nextInt(); // 정점
        M = scan.nextInt(); // 간선의 갯수
        V = scan.nextInt(); // 시작점

        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
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

        for(int y : adj[x]) {

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

            for(int y : adj[x]) {
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
