package backjoon.algo.fc.graph;

import java.io.*;
import java.util.StringTokenizer;

public class 연구소 {

    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N, M;
    static int[][] adj;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};

    public static void main(String[] args) {

        input();
        pro();
    }

    public static void input(){

        N = sc.nextInt();
        M = sc.nextInt();

        adj = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                adj[i][j] = sc.nextInt();
            }
        }

//        System.out.println(Arrays.deepToString(adj));
    }

    public static void pro() {

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
