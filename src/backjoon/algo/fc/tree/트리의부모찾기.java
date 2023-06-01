package backjoon.algo.fc.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] adj;
    static int[] parent;

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void input() {

        N = sc.nextInt();
        adj = new ArrayList[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        // 인접 리스트 구성하기
        for (int i = 1; i < N; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    public static void pro() {
        dfs(1, -1);
        for(int i = 2; i <= N; i++)
            sb.append(parent[i]).append("\n");

        System.out.println(sb.toString());

    }

    public static void dfs(int x, int par) {
        System.out.println("x : " + x + ", par : " + par);
        for(int y : adj[x]) {
            if(y == par) continue;
            parent[y] = x;
            dfs(y, x);
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
